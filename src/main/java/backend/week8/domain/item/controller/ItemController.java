package backend.week8.domain.item.controller;

import backend.week8.domain.item.dto.FindItemsRequestDto;
import backend.week8.domain.item.dto.FindItemsResponseDto;
import backend.week8.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService itemService;

    /**
     * 조건에 따른 상품 조회
     */
    @PostMapping("/search")
    public ResponseEntity<FindItemsResponseDto> findItems(@RequestBody FindItemsRequestDto findItemsRequestDto) {
        FindItemsResponseDto findItemsResponseDto = itemService.findItems(findItemsRequestDto);
        return ResponseEntity.ok()
                .body(findItemsResponseDto);
    }
}
