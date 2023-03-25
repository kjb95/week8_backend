package backend.week8.domain.cnrReq.service;

import backend.week8.domain.cnrReq.dto.request.UpdateCheckProcessRequestDto;
import backend.week8.domain.cnrReq.dto.response.CnrFailCauseResponseDto;
import backend.week8.domain.cnrReq.dto.response.FindAllCnrFailCauseResponseDto;
import backend.week8.domain.cnrReq.entity.CnrReq;
import backend.week8.domain.cnrReq.entity.enums.CnrFailCause;
import backend.week8.domain.dadDet.dto.response.AdCheckListResponseDto;
import backend.week8.domain.dadDet.dto.response.FindAllAdCheckListResponseDto;
import backend.week8.domain.dadDet.entity.DadDet;
import backend.week8.domain.dadDet.entity.enums.DadCnrStatus;
import backend.week8.domain.dadDet.repository.DadDetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CnrReqService {
	private static final String NOT_FOUND_DAD_DET = "존재하지 않는 직접광고 상세 아이디";
	private final DadDetRepository dadDetRepository;

	/**
	 * 검수 진행 상태, 검수 처리 시간, 검수 완료 여부, 직접광고 검수 상태, 검수 실패 사유, 검수 실패 코멘트 변경
	 */
	public void updateCheckProcess(UpdateCheckProcessRequestDto updateCheckProcessRequestDto) {
		DadDet dadDet = dadDetRepository.findById(updateCheckProcessRequestDto.getDadDetId())
				.orElseThrow(() -> new NoSuchElementException(NOT_FOUND_DAD_DET));
		CnrReq cnrReq = dadDet.getCnrReq();
		cnrReq.setCnrIngStatus(updateCheckProcessRequestDto.isCnrIngStatus());
		if (updateCheckProcessRequestDto.isCnrIngStatus()) {
			dadDet.setDadCnrStatus(DadCnrStatus.APPROVAL);
			return;
		}
		dadDet.setDadCnrStatus(DadCnrStatus.REJECT);
		cnrReq.setCnrFailCause(CnrFailCause.valueOf(updateCheckProcessRequestDto.getSelectedCnrFailCause()));
		cnrReq.setCnrFailComt(updateCheckProcessRequestDto.getCnrFailComt());
	}

	/**
	 * 모든 검수 실패 사유 조회
	 */
	public FindAllCnrFailCauseResponseDto findAllCnrFailCause() {
		List<CnrFailCauseResponseDto> failCauses = Arrays.stream(CnrFailCause.values())
				.map(cnrFailCause -> new CnrFailCauseResponseDto(cnrFailCause.name(), cnrFailCause.getDescription()))
				.collect(Collectors.toList());
		return new FindAllCnrFailCauseResponseDto(failCauses);
	}

	/**
	 * 광고 검수 대상 리스트 조회
	 */
	public FindAllAdCheckListResponseDto findAllAdCheckList(String kwdName) {
		List<AdCheckListResponseDto> allAdCheckList = dadDetRepository.findAllAdCheckList(kwdName);
		return new FindAllAdCheckListResponseDto(allAdCheckList);
	}
}
