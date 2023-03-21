package backend.week8.domain.agroup.dto.request;

import backend.week8.domain.agroup.dto.response.AdGroupResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FindAllAdGroupResponseDto {
	private List<AdGroupResponseDto> agroups;
}
