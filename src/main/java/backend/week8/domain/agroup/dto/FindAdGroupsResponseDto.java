package backend.week8.domain.agroup.dto;

import backend.week8.domain.ad.dto.AdGroupDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FindAdGroupsResponseDto {
	private List<AdGroupDto> agroups;
}
