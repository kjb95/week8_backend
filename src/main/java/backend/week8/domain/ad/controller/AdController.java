package backend.week8.domain.ad.controller;

import backend.week8.domain.ad.dto.RegisterAdRequestDto;
import backend.week8.domain.ad.service.AdService;
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

	/**
	 * 광고 등록
	 */
	@PostMapping
	public ResponseEntity<Void> registerAd(@RequestBody RegisterAdRequestDto registerAdRequestDto) {
		adService.registerAd(registerAdRequestDto);
		return ResponseEntity.ok()
				.build();
	}
}
