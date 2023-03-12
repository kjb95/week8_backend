package backend.week8.domain.agroup.controller;

import backend.week8.domain.agroup.dto.FindAllAGroupIdAndNameResponseDto;
import backend.week8.domain.agroup.service.AGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/agroup")
public class AGroupController {
	private final AGroupService aGroupService;

	/**
	 * 모든 광고 그룹의 아이디와 이름만 조회
	 */
	@GetMapping
	public ResponseEntity<FindAllAGroupIdAndNameResponseDto> findAllAGroupIdAndName() {
		FindAllAGroupIdAndNameResponseDto findAllAGroupIdAndNameResponseDto = aGroupService.findAllAGroupIdAndName();
		return ResponseEntity.ok()
				.body(findAllAGroupIdAndNameResponseDto);
	}
}
