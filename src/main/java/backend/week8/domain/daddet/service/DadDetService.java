package backend.week8.domain.daddet.service;

import backend.week8.domain.daddet.dto.request.FindKeywordsInItemRequestDto;
import backend.week8.domain.daddet.dto.response.FindKeywordsInItemResponseDto;
import backend.week8.domain.daddet.dto.response.KeywordInItemResponseDto;
import backend.week8.domain.daddet.entity.DadDet;
import backend.week8.domain.daddet.repository.DadDetRepository;
import backend.week8.domain.kwd.entity.Kwd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DadDetService {
	private final DadDetRepository dadDetRepository;

	/**
	 * 한 상품이 가지는 키워드 조회
	 */
	public FindKeywordsInItemResponseDto findKeywordsInItem(FindKeywordsInItemRequestDto findKeywordsInItemRequestDto) {
		List<DadDet> dadDets = dadDetRepository.findDadDetInItemLikeKeywordName(findKeywordsInItemRequestDto.getItemId(), findKeywordsInItemRequestDto.getKeywordNameSearch());
		List<KeywordInItemResponseDto> keywords = dadDets.stream()
				.map((this::createKeywordInItemResponseDto))
				.collect(Collectors.toList());
		return new FindKeywordsInItemResponseDto(keywords);
	}

	private KeywordInItemResponseDto createKeywordInItemResponseDto(DadDet dadDet) {
		Kwd kwd = dadDet.getKwd();
		String isOn = dadDet.getDadUseConfigYn() == 1 ? "ON" : "OFF";
		return new KeywordInItemResponseDto(kwd.getKwdId(), kwd.getKwdName(), isOn);
	}
}
