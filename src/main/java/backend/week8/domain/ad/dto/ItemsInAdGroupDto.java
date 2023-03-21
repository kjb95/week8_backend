package backend.week8.domain.ad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemsInAdGroupDto {
	private Long itemId;
	private String itemNo;
	private String itemName;
	private String adUseConfigYn;
}
