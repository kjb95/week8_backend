package backend.week8.domain.agroup.service;

import backend.week8.domain.agroup.dto.AGroupDto;
import backend.week8.domain.agroup.dto.AGroupsDto;
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
		List<AGroupDto> aGroups = aGroupRepository.findAll()
				.stream()
				.map(aGroup -> modelMapper.map(aGroup, AGroupDto.class))
				.collect(Collectors.toList());
		return new AGroupsDto(aGroups);
	}
}
