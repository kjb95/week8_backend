package backend.week8.domain.agroup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FindAllAdGroupIdAndNameResponseDto {
	private List<AGroupIdAndNameDto> agroups;
}
