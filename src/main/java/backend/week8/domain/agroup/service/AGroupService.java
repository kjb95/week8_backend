package backend.week8.domain.agroup.service;

import backend.week8.domain.agroup.dto.AGroupIdAndNameDto;
import backend.week8.domain.agroup.dto.FindAllAGroupIdAndNameResponseDto;
import backend.week8.domain.agroup.entity.AGroup;
import backend.week8.domain.agroup.repository.AGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AGroupService {
	private final AGroupRepository aGroupRepository;
	private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";

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

	/**
	 * 이미 존재하는 광고그룹 아이디면 아무일도 일어나지 않음
	 * 존재하지 않은 광고그룹 아이디면 광고그룹 생성
	 *
	 * @return 광고 아이디
	 */
	public AGroup registerAGroup(String aGroupId) {
		if (!aGroupId.matches(NUMBER_REGEX)) {
			return aGroupRepository.save(new AGroup(aGroupId));
		}
		AGroup aGroup = aGroupRepository.findById(Long.parseLong(aGroupId))
				.orElseGet(() -> new AGroup(aGroupId));
		return aGroupRepository.save(aGroup);
	}
}
