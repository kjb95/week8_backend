package backend.week8.domain.adv.service;

import backend.week8.domain.adv.dto.FindAdvResponseDto;
import backend.week8.domain.adv.dto.UpdateAdIngActRequestDto;
import backend.week8.domain.adv.dto.UpdateDayLimitBudgetRequestDto;
import backend.week8.domain.adv.entity.Adv;
import backend.week8.domain.adv.repository.AdvRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AdvService {

	private static final String NOT_FOUND_ADV = "존재하지 않는 광고주 아이디";
	private final AdvRepository advRepository;

	public FindAdvResponseDto findAdv(String advId) {
		Adv adv = advRepository.findById(advId)
				.orElseThrow(() -> new NoSuchElementException(NOT_FOUND_ADV));
		ModelMapper modelMapper = new ModelMapper();
		FindAdvResponseDto findAdvResponseDto = modelMapper.map(adv, FindAdvResponseDto.class);
		if (adv.getAdIngActYn() == 0) {
			findAdvResponseDto.setAdIngActYn(false);
		}
		return findAdvResponseDto;
	}

	public void updateDayLimitBudget(UpdateDayLimitBudgetRequestDto updateDayLimitBudgetRequestDto) {
		Adv adv = advRepository.findById(updateDayLimitBudgetRequestDto.getAdvId())
				.orElseThrow(() -> new NoSuchElementException(NOT_FOUND_ADV));
		adv.setDayLimitBudget(updateDayLimitBudgetRequestDto.getDayLimitBudget());
		advRepository.save(adv);
	}

	public void updateAdIngAct(UpdateAdIngActRequestDto updateAdIngActRequestDto) {
		Adv adv = advRepository.findById(updateAdIngActRequestDto.getAdvId())
				.orElseThrow(() -> new NoSuchElementException(NOT_FOUND_ADV));
		adv.setAdIngActYn(updateAdIngActRequestDto.isOn() ? 1 : 0);
		advRepository.save(adv);
	}
}
