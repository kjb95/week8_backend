package backend.week8.domain.dadDetReport.dto;

import backend.week8.domain.dadDetReport.entity.DadDetReport;
import lombok.Getter;

import java.util.List;

@Getter
public class DadDetReports {

	public DadDetReports(List<DadDetReport> dadDetReports) {
		this.dadDetReports = dadDetReports;
		dadDetReports.forEach(this::computeDadDetReport);
		int size = dadDetReports.size();
		avgOfImpressions /= size;
		avgOfClicks /= size;
		avgOfAverageImpressionRank /= size;
		avgOfAverageClickCost /= size;
		avgOfAdvertisingCost /= size;
	}

	private List<DadDetReport> dadDetReports;
	private int avgOfImpressions = 0;
	private int avgOfClicks = 0;
	private double avgOfAverageImpressionRank = 0;
	private int avgOfAverageClickCost = 0;
	private int avgOfAdvertisingCost = 0;

	private void computeDadDetReport(DadDetReport dadDetReport) {
		avgOfImpressions += dadDetReport.getImpressions();
		avgOfClicks += dadDetReport.getClicks();
		avgOfAverageImpressionRank += dadDetReport.getAverageImpressionRank();
		avgOfAverageClickCost += dadDetReport.getAverageClickCost();
		avgOfAdvertisingCost += dadDetReport.getAdvertisingCost();
	}
}
