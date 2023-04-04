package backend.week8.domain.dadDetReport.entity;

import backend.week8.domain.dadDetReport.dto.enums.ChartReportCategory;
import backend.week8.domain.dadDetReport.dto.response.ChartReportResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "DAD_DET_REPORT")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DadDetReport {
	@EmbeddedId
	private DadDetReportId dadDetReportId;
	@Column(name = "IMPRESSIONS")
	private int impressions;
	@Column(name = "CLICKS")
	private int clicks;
	@Column(name = "AVERAGE_IMPRESSION_RANK")
	private double averageImpressionRank;
	@Column(name = "AVERAGE_CLICK_COST")
	private double averageClickCost;
	@Column(name = "ADVERTISING_COST")
	private int advertisingCost;

	public List<ChartReportResponseDto> createChartReport() {
		List<ChartReportResponseDto> chartReport = new ArrayList<>();
		chartReport.add(new ChartReportResponseDto(dadDetReportId.getBaseDate(), ChartReportCategory.IMPRESSIONS.getDescription(), impressions));
		chartReport.add(new ChartReportResponseDto(dadDetReportId.getBaseDate(), ChartReportCategory.CLICKS.getDescription(), clicks));
		chartReport.add(new ChartReportResponseDto(dadDetReportId.getBaseDate(), ChartReportCategory.AVERAGE_IMPRESSION_RANK.getDescription(), averageImpressionRank));
		chartReport.add(new ChartReportResponseDto(dadDetReportId.getBaseDate(), ChartReportCategory.AVERAGE_CLICK_COST.getDescription(), averageClickCost));
		chartReport.add(new ChartReportResponseDto(dadDetReportId.getBaseDate(), ChartReportCategory.ADVERTISING_COST.getDescription(), advertisingCost));
		return chartReport;
	}
}
