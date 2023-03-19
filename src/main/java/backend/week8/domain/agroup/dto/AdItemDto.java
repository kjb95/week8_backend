package backend.week8.domain.agroup.dto;

import lombok.*;

@Getter
@Setter
public class AdItemDto {

	public AdItemDto(Long key, String itemNo, String itemName, int adUseConfigYn) {
		this.key = key;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.adUseConfigYn = adUseConfigYn == 1;
	}

	private Long key;
	private String itemNo;
	private String itemName;
	private boolean adUseConfigYn;
}
