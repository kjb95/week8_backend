package backend.week8.domain.agroup.controller;

import backend.week8.domain.agroup.dto.*;
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
	 * 모든 광고 그룹의 아이디와 이름만 조회
	 */
	@GetMapping("/all")
	public ResponseEntity<FindAllAGroupIdAndNameResponseDto> findAllAGroupIdAndName() {
		FindAllAGroupIdAndNameResponseDto findAllAGroupIdAndNameResponseDto = aGroupService.findAllAGroupIdAndName();
		return ResponseEntity.ok()
				.body(findAllAGroupIdAndNameResponseDto);
	}

	/**
	 * 조건에 따른 그룹 검색
	 */
	@GetMapping()
	public ResponseEntity<FindAGroupResponseDto> findAGroup(@RequestParam String groupName) {
		FindAGroupResponseDto findAGroupResponseDto = aGroupService.findAGroup(groupName);
		return ResponseEntity.ok()
				.body(findAGroupResponseDto);
	}

	/**
	 * 광고그룹 사용 설정 변경
	 */
	@PutMapping("/use-config")
	public ResponseEntity<Void> updateAdGroupUseConfig(@RequestBody UpdateAdGroupUseConfig updateAdGroupUseConfig) {
		aGroupService.updateAdGroupUseConfig(updateAdGroupUseConfig);
		return ResponseEntity.ok()
				.build();
	}

	/**
	 * 광고그룹 등록
	 */
	@PostMapping
	public ResponseEntity<Void> registerAdGroup(@RequestBody RegisterAdGroupRequestDto registerAdGroupRequestDto) {
		aGroupService.registerAGroupByName(registerAdGroupRequestDto.getAdGroupName());
		return ResponseEntity.ok()
				.build();
	}

	/**
	 * 광고 그룹 활성 여부 끄기
	 */
	@PutMapping("/act-off")
	public ResponseEntity<Void> updateAdGroupActOff(@RequestBody UpdateAdGroupActOff updateAdGroupActOff) {
		aGroupService.updateAdGroupActOff(updateAdGroupActOff);
		return ResponseEntity.ok()
				.build();
	}
}
