package backend.week8.domain.agroup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AGroupDto {
	private long key;
	private String agroupName;
	private String agroupUseConfigYn;
	private String itemCountLiveAndAll;
}
