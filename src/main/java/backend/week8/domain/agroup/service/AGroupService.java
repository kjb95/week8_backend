package backend.week8.domain.agroup.service;

import backend.week8.domain.agroup.dto.AGroupDto;
import backend.week8.domain.agroup.dto.AGroupsDto;
import backend.week8.domain.agroup.dto.RegisterAGroupRequestDto;
import backend.week8.domain.agroup.entity.AGroup;
import backend.week8.domain.agroup.repository.AGroupRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AGroupService {
	private final AGroupRepository aGroupRepository;
	private final ModelMapper modelMapper = new ModelMapper();

	public AGroupsDto findAllAGroup() {
		List<AGroup> all = aGroupRepository.findAll();

		List<AGroupDto> aGroups = aGroupRepository.findAll()
				.stream()
				.map(aGroup -> {
					AGroupDto map = modelMapper.map(aGroup, AGroupDto.class);
					return map;
				})
				.collect(Collectors.toList());
		return new AGroupsDto(aGroups);
	}

	public void registerAGroup(RegisterAGroupRequestDto registerAGroupRequestDto) {
		AGroup aGroup = AGroup.builder()
				.aGroupName(registerAGroupRequestDto.getAGroupName())
				.build();
		System.out.println(aGroup.getAGroupName());
		aGroupRepository.save(aGroup);
	}
}
