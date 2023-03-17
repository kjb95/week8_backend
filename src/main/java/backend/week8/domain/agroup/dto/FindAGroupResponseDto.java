package backend.week8.domain.agroup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FindAGroupResponseDto {
	private List<AGroupDto> agroups;
}
