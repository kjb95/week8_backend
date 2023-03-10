package backend.week8.domain.agroup.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AGroupDto {
	private Long aGroupId;
	private String aGroupName;
	private LocalDateTime regTime;
	private int aGroupActYn;
	private int aGroupUseConfigYn;
}
