package backend.week8.domain.ad.service;

import backend.week8.domain.ad.dto.FindItemsInAdGroupRequestDto;
import backend.week8.domain.ad.dto.FindItemsInAdGroupResponseDto;
import backend.week8.domain.ad.dto.ItemsInAdGroupDto;
import backend.week8.domain.ad.entity.Ad;
import backend.week8.domain.ad.repository.AdRepository;
import backend.week8.domain.adv.entity.Adv;
import backend.week8.domain.adv.repository.AdvRepository;
import backend.week8.domain.agroup.entity.AGroup;
import backend.week8.domain.item.entity.Item;
import backend.week8.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

	/**
	 * 조건(상품 명, 상품 번호)에 따라 한 광고 그룹에 속한 상품들 조회
	 */
	public FindItemsInAdGroupResponseDto findItemsInAdGroup(FindItemsInAdGroupRequestDto findItemsInAdGroupRequestDto) {
		List<ItemsInAdGroupDto> items = adRepository.findAdGroupWithItem(findItemsInAdGroupRequestDto.getItemName(), findItemsInAdGroupRequestDto.getItemNo(), findItemsInAdGroupRequestDto.getAdvId(), findItemsInAdGroupRequestDto.getAdGroupId())
				.stream()
				.map(this::createItemsInAdGroupDto)
				.collect(Collectors.toList());
		return new FindItemsInAdGroupResponseDto(items);
	}

	private ItemsInAdGroupDto createItemsInAdGroupDto(Ad ad) {
		Item item = ad.getItem();
		return new ItemsInAdGroupDto(item.getItemId(), item.getItemNo(), item.getItemName(), ad.getAdUseConfigYn() == 1);
	}
}
