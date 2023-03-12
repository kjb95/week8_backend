package backend.week8.domain.item.service;

import backend.week8.common.enums.AdultYN;
import backend.week8.common.enums.ItemActYN;
import backend.week8.domain.item.dto.FindItemsRequestDto;
import backend.week8.domain.item.dto.FindItemsResponseDto;
import backend.week8.domain.item.dto.ItemDto;
import backend.week8.domain.item.entity.Item;
import backend.week8.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {
	private final ItemRepository itemRepository;

	private ItemDto conversionItem(Item item) {
		ModelMapper modelMapper = new ModelMapper();
		ItemDto itemDto = modelMapper.map(item, ItemDto.class);
		String convertedAdultYn = AdultYN.findWordByFlag(itemDto.getAdultYn());
		String convertedItemActYn = ItemActYN.findWordByFlag(itemDto.getItemActYn());
		itemDto.setAdultYn(convertedAdultYn);
		itemDto.setItemActYn(convertedItemActYn);
		itemDto.setKey(Long.toString(item.getItemId()));
		return itemDto;
	}

	public FindItemsResponseDto findItems(FindItemsRequestDto findItemsRequestDto) {
		List<ItemDto> items = itemRepository.findByItemNameContainsAndItemNoContains(findItemsRequestDto.getItemName(), findItemsRequestDto.getItemNo())
				.stream()
				.map(this::conversionItem)
				.collect(Collectors.toList());
		return new FindItemsResponseDto(items);
	}
}
