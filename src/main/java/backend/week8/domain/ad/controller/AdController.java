package backend.week8.domain.ad.controller;

import backend.week8.domain.ad.dto.FindItemsInAdGroupRequestDto;
import backend.week8.domain.ad.dto.FindItemsInAdGroupResponseDto;
import backend.week8.domain.ad.dto.RegisterAdRequestDto;
import backend.week8.domain.ad.entity.Ad;
import backend.week8.domain.ad.service.AdService;
import backend.week8.domain.agroup.entity.AGroup;
import backend.week8.domain.agroup.service.AGroupService;
import backend.week8.domain.daddet.service.DadDetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ad")
public class AdController {
	private final AdService adService;
	private final AGroupService aGroupService;
	private final DadDetService dadDetService;

	/**
	 * 광고 등록
	 */
	@PostMapping
	public ResponseEntity<Void> registerAd(@RequestBody RegisterAdRequestDto registerAdRequestDto) {
		AGroup aGroup = aGroupService.registerAGroupById(registerAdRequestDto.getAgroupId());
		Ad ad = adService.registerAd(aGroup, registerAdRequestDto.getItemId(), registerAdRequestDto.getAdvId());
		dadDetService.registerDirectAdDetails(ad, registerAdRequestDto.getKeywordList());
		return ResponseEntity.ok()
				.build();
	}

	/**
	 * 조건(상품 명, 상품 번호)에 따라 한 광고 그룹에 속한 상품들 조회
	 */
	@PostMapping("/items/search")
	public ResponseEntity<FindItemsInAdGroupResponseDto> findItemsInAdGroup(@RequestBody FindItemsInAdGroupRequestDto findItemsInAdGroupRequestDto) {
		FindItemsInAdGroupResponseDto findItemsInAdGroupResponseDto = adService.findItemsInAdGroup(findItemsInAdGroupRequestDto);
		return ResponseEntity.ok()
				.body(findItemsInAdGroupResponseDto);
	}
}
