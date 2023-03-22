package backend.week8.domain.daddet.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindKeywordsInItemRequestDto {
	private long itemId;
	private String keywordNameSearch;
}
