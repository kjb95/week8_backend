package backend.week8.batch.processor;

import backend.week8.batch.dto.DadDetReportCsvDto;
import backend.week8.domain.dadDet.repository.DadDetRepository;
import backend.week8.domain.dadDetReport.entity.DadDetReport;
import backend.week8.domain.dadDetReport.entity.DadDetReportId;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskReqItemProcessor implements ItemProcessor<DadDetReportCsvDto, DadDetReport> {
	private final DadDetRepository dadDetRepository;

	@Override
	public DadDetReport process(DadDetReportCsvDto item) {
		String advId = dadDetRepository.findAdvIdByDadDetId(item.getDadDetId());
		DadDetReportId dadDetReportId = new DadDetReportId(advId, item.getBaseDate(), item.getDadDetId());
		return new DadDetReport(dadDetReportId, item.getImpressions(), item.getClicks(), item.getAverageImpressionRank(), item.getAverageClickCost(), item.getAdvertisingCost());
	}
}
