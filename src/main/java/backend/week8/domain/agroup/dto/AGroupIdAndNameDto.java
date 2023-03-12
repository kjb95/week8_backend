package backend.week8.domain.agroup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AGroupIdAndNameDto {
	private Long aGroupId;
	private String aGroupName;
}
