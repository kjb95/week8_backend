package backend.week8.domain.dadDetReport.service;

import backend.week8.domain.dadDetReport.dto.enums.ChartReportCategory;
import backend.week8.domain.dadDetReport.dto.response.ChartReportResponseDto;
import backend.week8.domain.dadDetReport.dto.response.DadDetReportCategoryResponseDto;
import backend.week8.domain.dadDetReport.dto.response.FindAllDadDetReportCategoryResponseDto;
import backend.week8.domain.dadDetReport.dto.response.FindDadDetReportResponseDto;
import backend.week8.domain.dadDetReport.repository.DadDetReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DadDetReportService {
	private final DadDetReportRepository dadDetReportRepository;

	/**
	 * 리포트 차트 데이터 조회
	 */
	public FindDadDetReportResponseDto findDadDetReport(long dadDetId) {
		List<ChartReportResponseDto> chartReports = new ArrayList<>();
		dadDetReportRepository.findByDadDetReportId_DadDetId(dadDetId)
				.forEach(dadDetReport -> chartReports.addAll(dadDetReport.createChartReport()));
		return new FindDadDetReportResponseDto(chartReports);
	}

	/**
	 * 직접광고 리포트의 모든 데이터 카테고리 조회
	 */
	public FindAllDadDetReportCategoryResponseDto findAllDadDetReportCategory() {
		List<DadDetReportCategoryResponseDto> categories = Arrays.stream(ChartReportCategory.values())
				.map(chartReportCategory -> new DadDetReportCategoryResponseDto(chartReportCategory.getDescription(), chartReportCategory.getDescription()))
				.collect(Collectors.toList());
		return new FindAllDadDetReportCategoryResponseDto(categories);
	}
}