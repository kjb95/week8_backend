package backend.week8.domain.ad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FindItemsInAdGroupResponseDto {
	List<ItemsInAdGroupDto> items;
}