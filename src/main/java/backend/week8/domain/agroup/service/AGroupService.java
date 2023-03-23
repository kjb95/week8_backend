package backend.week8.domain.agroup.service;

import backend.week8.domain.ad.repository.AdRepository;
import backend.week8.domain.agroup.dto.UpdateAdGroupUseConfigRequestDto;
import backend.week8.domain.agroup.dto.repository.FindAdGroupsDto;
import backend.week8.domain.agroup.dto.request.FindAdGroupRequestDto;
import backend.week8.domain.agroup.dto.request.FindAllAdGroupResponseDto;
import backend.week8.domain.agroup.dto.request.UpdateAdGroupActOffRequestDto;
import backend.week8.domain.agroup.dto.request.UpdateAdGroupNameRequestDto;
import backend.week8.domain.agroup.dto.response.AdGroupIdAndNameResponseDto;
import backend.week8.domain.agroup.dto.response.AdGroupResponseDto;
import backend.week8.domain.agroup.dto.response.FindAdGroupResponseDto;
import backend.week8.domain.agroup.dto.response.FindAllAdGroupIdAndNameResponseDto;
import backend.week8.domain.agroup.entity.AGroup;
import backend.week8.domain.agroup.repository.AGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AGroupService {
	private static final String DUPLICATED_ADGROUP_NAME = "이미 존재하는 광고그룹 이름 입니다";
	private static final String NOT_FOUND_AD_GROUP_ID = "존재하지 않는 광고그룹 아이디";
	private final AGroupRepository aGroupRepository;
	private final AdRepository adRepository;

	/**
	 * 모든 광고 그룹의 아이디와 이름만 조회
	 */
	public FindAllAdGroupIdAndNameResponseDto findAllAdGroupIdAndName() {
		List<AdGroupIdAndNameResponseDto> aGroups = aGroupRepository.findAllByAgroupActYn(1)
				.stream()
				.map(aGroup -> new AdGroupIdAndNameResponseDto(aGroup.getAgroupId(), aGroup.getAgroupName()))
				.collect(Collectors.toList());
		return new FindAllAdGroupIdAndNameResponseDto(aGroups);
	}

	/**
	 * 조건에 따른 그룹 검색
	 */
	public FindAllAdGroupResponseDto findAllAdGroup(String groupNameCondition) {
		List<FindAdGroupsDto> findAdGroupsDtos = aGroupRepository.findAdGroups(groupNameCondition);
		List<AdGroupResponseDto> adGroups = findAdGroupsDtos.stream()
				.map(group -> createAGroupDto(group))
				.collect(Collectors.toList());
		return new FindAllAdGroupResponseDto(adGroups);
	}

	private AdGroupResponseDto createAGroupDto(FindAdGroupsDto group) {
		String isGroupOn = group.getAgroupUseConfigYn() == 1 ? "ON" : "OFF";
		String itemCountLiveAndAll = group.getCountAdUseConfig() + " / " + group.getCountAdAct();
		return new AdGroupResponseDto(group.getKey(), group.getAgroupName(), isGroupOn, itemCountLiveAndAll);
	}

	/**
	 * 광고그룹 사용 설정 변경
	 */
	public void updateAdGroupUseConfig(UpdateAdGroupUseConfigRequestDto updateAdGroupUseConfigRequestDto) {
		int useConfig = updateAdGroupUseConfigRequestDto.isOn() ? 1 : 0;
		aGroupRepository.updateUseConfig(updateAdGroupUseConfigRequestDto.getAdGroupIds(), useConfig);
	}

	/**
	 * 광고그룹 등록
	 */
	public void registerAGroupByName(String agroupName) {
		if (aGroupRepository.existsByAgroupName(agroupName)) {
			throw new IllegalArgumentException(DUPLICATED_ADGROUP_NAME);
		}
		aGroupRepository.save(new AGroup(agroupName));
	}

	/**
	 * 광고 그룹 활성 여부 끄기
	 */
	public void updateAdGroupActOff(UpdateAdGroupActOffRequestDto updateAdGroupActOffRequestDto) {
		aGroupRepository.updateActOff(updateAdGroupActOffRequestDto.getAdGroupIds());
	}

	/**
	 * 광고 그룹 한개 조회
	 */
	public FindAdGroupResponseDto findAdGroup(FindAdGroupRequestDto findAdGroupRequestDto) {
		AGroup aGroup = aGroupRepository.findByAgroupIdAndAgroupActYn(findAdGroupRequestDto.getAdGroupId(), 1)
				.orElseThrow(() -> new NoSuchElementException(NOT_FOUND_AD_GROUP_ID));
		int agroupItemsCount = adRepository.countItemsInAdGroup(aGroup.getAgroupId());
		return new FindAdGroupResponseDto(aGroup.getAgroupName(), aGroup.getAgroupUseConfigYn(), agroupItemsCount, aGroup.getRegTime());
	}

	/**
	 * 광고 그룹명 변경
	 */
	public void updateAdGroupName(UpdateAdGroupNameRequestDto updateAdGroupNameRequestDto) {
		boolean isExistAgroupName = aGroupRepository.existsByAgroupName(updateAdGroupNameRequestDto.getAdGroupName());
		if (isExistAgroupName) {
			throw new IllegalArgumentException(DUPLICATED_ADGROUP_NAME);
		}
		AGroup aGroup = aGroupRepository.findById(updateAdGroupNameRequestDto.getAdGroupId())
				.orElseThrow(() -> new NoSuchElementException(NOT_FOUND_AD_GROUP_ID));
		aGroup.setAgroupName(updateAdGroupNameRequestDto.getAdGroupName());
		aGroupRepository.save(aGroup);
	}
}
