package backend.week8.domain.ad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AdGroupDto {
	private long key;
	private String agroupName;
	private String agroupUseConfigYn;
	private String itemCountLiveAndAll;
}
