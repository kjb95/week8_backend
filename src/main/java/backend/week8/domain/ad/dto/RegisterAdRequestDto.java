package backend.week8.domain.ad.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class RegisterAdRequestDto {
	private String agroupId;
	private long itemId;
	private String advId;
	private List<KeywordDto> keywordList;
}
