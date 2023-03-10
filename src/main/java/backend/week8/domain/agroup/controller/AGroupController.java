package backend.week8.domain.agroup.controller;

import backend.week8.domain.agroup.dto.AGroupsDto;
import backend.week8.domain.agroup.dto.RegisterAGroupRequestDto;
import backend.week8.domain.agroup.service.AGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/agroup")
public class AGroupController {
	private final AGroupService aGroupService;

	/**
	 * 모든 광고 그룹 조회
	 */
	@GetMapping
	public ResponseEntity<AGroupsDto> findAllAGroup() {
		AGroupsDto aGroupsDto = aGroupService.findAllAGroup();
		return ResponseEntity.ok()
				.body(aGroupsDto);
	}

	/**
	 * 광고 그룹 이름으로 새로운 광고그룹 등록
	 */
	@PostMapping
	public ResponseEntity<Void> registerAGroup(@RequestBody RegisterAGroupRequestDto registerAGroupRequestDto) {
		aGroupService.registerAGroup(registerAGroupRequestDto);
		return ResponseEntity.ok()
				.build();
	}
}
