package backend.week8.domain.daddet.controller;

import backend.week8.domain.daddet.service.DadDetService;
import backend.week8.domain.daddet.dto.request.FindKeywordsInItemRequestDto;
import backend.week8.domain.daddet.dto.response.FindKeywordsInItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/daddet")
public class DadDetController {
	private final DadDetService dadDetService;

	/**
	 * 한 상품이 가지는 키워드 조회
	 */
	@PostMapping("/kwd/search")
	public ResponseEntity<FindKeywordsInItemResponseDto> findKeywordsInItem(@RequestBody FindKeywordsInItemRequestDto findKeywordsInItemRequestDto) {
		FindKeywordsInItemResponseDto findKeywordsInItemResponseDto = dadDetService.findKeywordsInItem(findKeywordsInItemRequestDto);
		return ResponseEntity.ok()
				.body(findKeywordsInItemResponseDto);
	}
}
