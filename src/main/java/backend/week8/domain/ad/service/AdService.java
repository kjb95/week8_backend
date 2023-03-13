package backend.week8.domain.ad.service;

import backend.week8.domain.ad.entity.Ad;
import backend.week8.domain.ad.repository.AdRepository;
import backend.week8.domain.adv.entity.Adv;
import backend.week8.domain.adv.repository.AdvRepository;
import backend.week8.domain.agroup.entity.AGroup;
import backend.week8.domain.agroup.repository.AGroupRepository;
import backend.week8.domain.item.entity.Item;
import backend.week8.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdService {
	private final AdRepository adRepository;
	private final ItemRepository itemRepository;
	private final AdvRepository advRepository;

	/**
	 * 광고 등록
	 */
	public Ad registerAd(AGroup aGroup, long itemId, String advId) {
		Item item = itemRepository.findById(itemId)
				.get();
		Adv adv = advRepository.findById(advId)
				.get();
		Ad ad = new Ad(aGroup, item, adv);
		return adRepository.save(ad);
	}
}
