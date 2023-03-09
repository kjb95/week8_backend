package backend.week8.domain.item.service;

import backend.week8.common.enums.AdultYN;
import backend.week8.common.enums.ItemActYN;
import backend.week8.domain.item.dto.FindItemsRequestDto;
import backend.week8.domain.item.dto.FindItemsResponseDto;
import backend.week8.domain.item.dto.ItemDto;
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

    private ItemDto conversionItem(ItemDto itemDto) {
        String convertedAdultYn = AdultYN.findWordByFlag(itemDto.getAdultYn());
        String convertedItemActYn = ItemActYN.findWordByFlag(itemDto.getItemActYn());
        itemDto.setAdultYn(convertedAdultYn);
        itemDto.setItemActYn(convertedItemActYn);
        return itemDto;
    }

    public FindItemsResponseDto findItems(FindItemsRequestDto findItemsRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        List<ItemDto> items = itemRepository.findByItemNameContainsAndItemNoContains(findItemsRequestDto.getItemName(), findItemsRequestDto.getItemNo())
                .stream()
                .map(item -> modelMapper.map(item, ItemDto.class))
                .map(this::conversionItem)
                .collect(Collectors.toList());
        return new FindItemsResponseDto(items);
    }
}
