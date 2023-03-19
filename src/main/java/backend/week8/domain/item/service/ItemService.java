package backend.week8.domain.item.service;

import backend.week8.domain.item.dto.FindItemsRequestDto;
import backend.week8.domain.item.dto.FindItemsResponseDto;
import backend.week8.domain.item.dto.ItemDto;
import backend.week8.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {
	private final ItemRepository itemRepository;

	/**
	 * 조건에 따른 상품 조회
	 */
	public FindItemsResponseDto findItems(FindItemsRequestDto findItemsRequestDto) {
		List<ItemDto> items = itemRepository.findByItemNameContainsAndItemNoContains(findItemsRequestDto.getItemName(), findItemsRequestDto.getItemNo())
				.stream()
				.map((item) -> new ItemDto(item.getItemId(), item.getItemNo(), item.getItemName(), item.getAdultYn(), item.getItemOrgCost(), item.getItemActYn()))
				.collect(Collectors.toList());
		return new FindItemsResponseDto(items);
	}
}
