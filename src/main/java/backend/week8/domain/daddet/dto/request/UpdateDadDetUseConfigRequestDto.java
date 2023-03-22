package backend.week8.domain.daddet.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateDadDetUseConfigRequestDto {
	private List<Long> kwdIds;
	private boolean on;
}
