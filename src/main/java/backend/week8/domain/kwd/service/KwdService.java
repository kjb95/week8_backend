package backend.week8.domain.kwd.service;

import backend.week8.domain.kwd.dto.response.FindAllKwdResponseDto;
import backend.week8.domain.kwd.dto.response.KwdResponseDto;
import backend.week8.domain.kwd.repository.KwdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KwdService {

	private final KwdRepository kwdRepository;

	public FindAllKwdResponseDto findAllKwd(String kwdName) {
		List<KwdResponseDto> kwds = kwdRepository.findByManualCnrKwdYnAndKwdNameContaining(1, kwdName)
				.stream()
				.map(kwd -> new KwdResponseDto(kwd.getKwdId(), kwd.getKwdName()))
				.collect(Collectors.toList());
		return new FindAllKwdResponseDto(kwds);
	}
}
