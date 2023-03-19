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
	@GetMapping("/all-id-name")
	public ResponseEntity<FindAllAdGroupIdAndNameResponseDto> findAllAdGroupIdAndName() {
		FindAllAdGroupIdAndNameResponseDto findAllAdGroupIdAndNameResponseDto = aGroupService.findAllAdGroupIdAndName();
		return ResponseEntity.ok()
				.body(findAllAdGroupIdAndNameResponseDto);
	}

	/**
	 * 조건에 따른 광고 그룹 검색
	 */
	@GetMapping("/all")
	public ResponseEntity<FindAdGroupsResponseDto> findAdGroups(@RequestParam String groupName) {
		FindAdGroupsResponseDto findAdGroupsResponseDto = aGroupService.findAdGroups(groupName);
		return ResponseEntity.ok()
				.body(findAdGroupsResponseDto);
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

	/**
	 * 광고 그룹 한개 조회
	 */
	@PostMapping("/search")
	public ResponseEntity<FindAdGroupResponseDto> findAdGroup(@RequestBody FindAdGroupRequestDto findAdGroupRequestDto) {
		FindAdGroupResponseDto findAdGroupResponseDto = aGroupService.findAdGroup(findAdGroupRequestDto);
		return ResponseEntity.ok()
				.body(findAdGroupResponseDto);
	}

	/**
	 * 광고 그룹명 변경
	 */
	@PutMapping("/ad-group-name")
	public ResponseEntity<FindAdGroupResponseDto> updateAdGroupName(@RequestBody UpdateAdGroupNameRequestDto updateAdGroupNameRequestDto) {
		aGroupService.updateAdGroupName(updateAdGroupNameRequestDto);
		return ResponseEntity.ok()
				.build();
	}

}
