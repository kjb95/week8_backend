package backend.week8.domain.ad.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindItemsInAdGroupRequestDto {
	private Long adGroupId;
	private String advId;
	private String itemName;
	private String itemNo;
}
