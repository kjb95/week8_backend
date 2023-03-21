package backend.week8.domain.agroup.dto.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FindAdGroupsDto {
	private long key;
	private String agroupName;
	private int agroupUseConfigYn;
	private long countAdAct;
	private long countAdUseConfig;
}
