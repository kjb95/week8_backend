package backend.week8.domain.item.service;

import backend.week8.domain.ad.dto.FindItemsInAdGroupRequestDto;
import backend.week8.domain.ad.dto.FindItemsInAdGroupResponseDto;
import backend.week8.domain.ad.dto.ItemsInAdGroupDto;
import backend.week8.domain.ad.entity.Ad;
import backend.week8.domain.ad.repository.AdRepository;
import backend.week8.domain.item.dto.FindItemsRequestDto;
import backend.week8.domain.item.dto.FindItemsResponseDto;
import backend.week8.domain.item.dto.ItemDto;
import backend.week8.domain.item.entity.Item;
import backend.week8.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/item")
@RequiredArgsConstructor
@Service
public class ItemService {
	private final ItemRepository itemRepository;
	private final AdRepository adRepository;

	/**
	 * 조건에 따른 상품 조회
	 */
	public FindItemsResponseDto findItems(FindItemsRequestDto findItemsRequestDto) {
		List<ItemDto> items = itemRepository.findByItemNameContainsAndItemNoContainsAndItemActYn(findItemsRequestDto.getItemName(), findItemsRequestDto.getItemNo(), 1)
				.stream()
				.map((item) -> new ItemDto(item.getItemId(), item.getItemNo(), item.getItemName(), item.getAdultYn(), item.getItemOrgCost(), item.getItemActYn()))
				.collect(Collectors.toList());
		return new FindItemsResponseDto(items);
	}

	/**
	 * 조건(상품 명, 상품 번호)에 따라 한 광고 그룹에 속한 상품들 조회
	 */
	public FindItemsInAdGroupResponseDto findItemsInAdGroup(FindItemsInAdGroupRequestDto findItemsInAdGroupRequestDto) {
		List<ItemsInAdGroupDto> items = adRepository.findAdWithItem(findItemsInAdGroupRequestDto.getItemName(), findItemsInAdGroupRequestDto.getItemNo(), findItemsInAdGroupRequestDto.getAdvId()
						, findItemsInAdGroupRequestDto.getAdGroupId())
				.stream()
				.map(this::createItemsInAdGroupDto)
				.collect(Collectors.toList());
		return new FindItemsInAdGroupResponseDto(items);
	}

	private ItemsInAdGroupDto createItemsInAdGroupDto(Ad ad) {
		Item item = ad.getItem();
		String isOnAdUseConfig = ad.getAdUseConfigYn() == 1 ? "ON" : "OFF";
		return new ItemsInAdGroupDto(item.getItemId(), item.getItemNo(), item.getItemName(), isOnAdUseConfig);
	}
}
