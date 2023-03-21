package backend.week8.domain.ad.service;

import backend.week8.domain.ad.dto.KeywordDto;
import backend.week8.domain.ad.dto.RegisterAdRequestDto;
import backend.week8.domain.ad.entity.Ad;
import backend.week8.domain.ad.repository.AdRepository;
import backend.week8.domain.adv.entity.Adv;
import backend.week8.domain.adv.repository.AdvRepository;
import backend.week8.domain.agroup.entity.AGroup;
import backend.week8.domain.agroup.repository.AGroupRepository;
import backend.week8.domain.cnrReq.entity.CnrReq;
import backend.week8.domain.cnrReq.repository.CnrReqRepository;
import backend.week8.domain.daddet.entity.DadDet;
import backend.week8.domain.daddetbid.entity.DadDetBid;
import backend.week8.domain.daddetbid.repository.DadDetBidRepository;
import backend.week8.domain.item.entity.Item;
import backend.week8.domain.item.repository.ItemRepository;
import backend.week8.domain.kwd.entity.Kwd;
import backend.week8.domain.kwd.repository.KwdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdService {

	private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";
	private final AdRepository adRepository;
	private final ItemRepository itemRepository;
	private final AdvRepository advRepository;
	private final AGroupRepository aGroupRepository;
	private final KwdRepository kwdRepository;
	private final CnrReqRepository cnrReqRepository;
	private final DadDetBidRepository dadDetBidRepository;

	/**
	 * 광고 등록
	 */
	public void registerAd(RegisterAdRequestDto registerAdRequestDto) {
		AGroup aGroup = registerAGroupById(registerAdRequestDto.getAgroupId());
		Ad ad = registerAd(aGroup, registerAdRequestDto.getItemId(), registerAdRequestDto.getAdvId());
		registerDirectAdDetails(ad, registerAdRequestDto.getKeywordList());
	}

	private AGroup registerAGroupById(String aGroupId) {
		if (!aGroupId.matches(NUMBER_REGEX)) {
			return aGroupRepository.save(new AGroup(aGroupId));
		}
		AGroup aGroup = aGroupRepository.findById(Long.parseLong(aGroupId))
				.orElseGet(() -> new AGroup(aGroupId));
		return aGroupRepository.save(aGroup);
	}

	private Ad registerAd(AGroup aGroup, long itemId, String advId) {
		Item item = itemRepository.findById(itemId)
				.get();
		Adv adv = advRepository.findById(advId)
				.get();
		Ad ad = new Ad(aGroup, item, adv);
		return adRepository.save(ad);
	}

	private void registerDirectAdDetails(Ad ad, List<KeywordDto> keywordList) {
		keywordList.forEach(keyword -> registerDirectAdDetails(ad, keyword));
	}

	private void registerDirectAdDetails(Ad ad, KeywordDto keyword) {
		CnrReq cnrReq = cnrReqRepository.save(new CnrReq());
		Kwd kwd = kwdRepository.findKwdByKwdName(keyword.getKeywordName())
				.orElseGet(() -> new Kwd(keyword.getKeywordName()));
		kwd = kwdRepository.save(kwd);
		DadDet dadDet = new DadDet(ad, kwd, cnrReq);
		dadDetBidRepository.save(new DadDetBid(dadDet, keyword.getBid()));
		cnrReq.setDadDetId(dadDet.getDadDetId());
		cnrReqRepository.save(cnrReq);
	}
}
