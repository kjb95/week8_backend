package backend.week8.domain.agroup.service;

import backend.week8.domain.agroup.dto.AGroupIdAndNameDto;
import backend.week8.domain.agroup.dto.FindAllAGroupIdAndNameResponseDto;
import backend.week8.domain.agroup.repository.AGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AGroupService {
	private final AGroupRepository aGroupRepository;

	/**
	 * 모든 광고 그룹의 아이디와 이름만 조회
	 */
	public FindAllAGroupIdAndNameResponseDto findAllAGroupIdAndName() {
		List<AGroupIdAndNameDto> aGroups = aGroupRepository.findAll()
				.stream()
				.map(aGroup -> new AGroupIdAndNameDto(aGroup.getAGroupId(), aGroup.getAGroupName()))
				.collect(Collectors.toList());
		return new FindAllAGroupIdAndNameResponseDto(aGroups);
	}

//	public void registerAGroup(RegisterAGroupRequestDto registerAGroupRequestDto) {
//		AGroup aGroup = AGroup.builder()
//				.aGroupName(registerAGroupRequestDto.getAGroupName())
//				.build();
//		aGroupRepository.save(aGroup);
//	}
}
