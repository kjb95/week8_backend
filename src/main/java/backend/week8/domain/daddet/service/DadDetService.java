package backend.week8.domain.daddet.service;

import backend.week8.domain.ad.dto.KeywordDto;
import backend.week8.domain.ad.entity.Ad;
import backend.week8.domain.cnrReq.entity.CnrReq;
import backend.week8.domain.cnrReq.repository.CnrReqRepository;
import backend.week8.domain.daddet.entity.DadDet;
import backend.week8.domain.daddetbid.entity.DadDetBid;
import backend.week8.domain.daddetbid.repository.DadDetBidRepository;
import backend.week8.domain.kwd.entity.Kwd;
import backend.week8.domain.kwd.repository.KwdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DadDetService {
	private final KwdRepository kwdRepository;
	private final CnrReqRepository cnrReqRepository;
	private final DadDetBidRepository dadDetBidRepository;

	/**
	 * 직접광고 상세 등록
	 */
	public void registerDirectAdDetails(Ad ad, List<KeywordDto> keywordList) {
		keywordList.stream()
				.forEach(keyword -> registerDirectAdDetails(ad, keyword));
	}

	private void registerDirectAdDetails(Ad ad, KeywordDto keyword) {
		CnrReq cnrReq = cnrReqRepository.save(new CnrReq());
		Kwd kwd = kwdRepository.save(new Kwd(keyword.getKeywordName()));
		DadDet dadDet = new DadDet(ad, kwd, cnrReq);
		dadDetBidRepository.save(new DadDetBid(dadDet, keyword.getBid()));
		cnrReq.setDadDetId(dadDet.getDadDetId());
		cnrReqRepository.save(cnrReq);
	}
}
