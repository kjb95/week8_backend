package backend.week8.domain.item.controller;

import backend.week8.domain.ad.dto.FindItemsInAdGroupRequestDto;
import backend.week8.domain.ad.dto.FindItemsInAdGroupResponseDto;
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
     * 조건(상품 명, 상품 번호)에 따라 상품들 조회
     */
    @PostMapping("/search")
    public ResponseEntity<FindItemsResponseDto> findItems(@RequestBody FindItemsRequestDto findItemsRequestDto) {
        FindItemsResponseDto findItemsResponseDto = itemService.findItems(findItemsRequestDto);
        return ResponseEntity.ok()
                .body(findItemsResponseDto);
    }

    /**
     * 조건(상품 명, 상품 번호)에 따라 한 광고 그룹에 속한 상품들 조회
     */
    @PostMapping("/in-ad-group/search")
    public ResponseEntity<FindItemsInAdGroupResponseDto> findItemsInAdGroup(@RequestBody FindItemsInAdGroupRequestDto findItemsInAdGroupRequestDto) {
        FindItemsInAdGroupResponseDto findItemsInAdGroupResponseDto = itemService.findItemsInAdGroup(findItemsInAdGroupRequestDto);
        return ResponseEntity.ok()
                .body(findItemsInAdGroupResponseDto);
    }
}
