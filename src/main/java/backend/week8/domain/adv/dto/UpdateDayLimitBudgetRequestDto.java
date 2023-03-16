package backend.week8.domain.adv.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDayLimitBudgetRequestDto {
	private String advId;
	private int dayLimitBudget;
}
