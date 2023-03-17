package backend.week8.domain.agroup.service;

import backend.week8.domain.ad.repository.AdRepository;
import backend.week8.domain.agroup.dto.AGroupDto;
import backend.week8.domain.agroup.dto.AGroupIdAndNameDto;
import backend.week8.domain.agroup.dto.FindAGroupResponseDto;
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
	private final AdRepository adRepository;
	private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";

	/**
	 * 모든 광고 그룹의 아이디와 이름만 조회
	 */
	public FindAllAGroupIdAndNameResponseDto findAllAGroupIdAndName() {
		List<AGroupIdAndNameDto> aGroups = aGroupRepository.findAll()
				.stream()
				.map(aGroup -> new AGroupIdAndNameDto(aGroup.getAgroupId(), aGroup.getAgroupName()))
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

	/**
	 * 조건에 따른 그룹 검색
	 */
	public FindAGroupResponseDto findAGroup(String groupNameCondition) {
		List<AGroupDto> aGroups = aGroupRepository.findByAgroupNameContains(groupNameCondition)
				.stream()
				.map(this::createAGroupDto)
				.collect(Collectors.toList());
		return new FindAGroupResponseDto(aGroups);
	}

	private AGroupDto createAGroupDto(AGroup agroup) {
		String isGroupOn = agroup.getAgroupUseConfigYn() == 1 ? "ON" : "OFF";
		int numOfItemLive = adRepository.countByAgroup_AgroupNameAndAdUseConfigYnAndAdActYn(agroup.getAgroupName(), 1, 1);
		int numOfItemAll = adRepository.countByAgroup_AgroupNameAndAdActYn(agroup.getAgroupName(), 1);
		String itemCountLiveAndAll = numOfItemLive + " / " + numOfItemAll;
		return AGroupDto.builder()
				.key(agroup.getAgroupId())
				.agroupName(agroup.getAgroupName())
				.agroupUseConfigYn(isGroupOn)
				.itemCountLiveAndAll(itemCountLiveAndAll)
				.build();
	}
}
