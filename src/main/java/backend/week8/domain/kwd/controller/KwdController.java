package backend.week8.domain.kwd.controller;

import backend.week8.domain.kwd.dto.response.FindAllKwdResponseDto;
import backend.week8.domain.kwd.service.KwdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kwd")
@Transactional
public class KwdController {
	private final KwdService kwdService;

	/**
	 * 모든 키워드 조회(수동 검수 키워드 1)
	 */
	@GetMapping
	public ResponseEntity<FindAllKwdResponseDto> findAllKwd(@RequestParam String kwdName) {
		FindAllKwdResponseDto findAllKwdResponseDto = kwdService.findAllKwd(kwdName);
		return ResponseEntity.ok()
				.body(findAllKwdResponseDto);
	}
}
