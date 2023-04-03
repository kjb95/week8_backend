package backend.week8.batch.processor;

import backend.week8.batch.dto.DadDetReportCsvDto;
import backend.week8.domain.dadDetReport.entity.DadDetReport;
import backend.week8.domain.dadDetReport.entity.DadDetReportId;
import backend.week8.domain.taskReq.entity.TaskReq;
import backend.week8.domain.taskReq.entity.enus.TaskStatus;
import backend.week8.domain.taskReq.repository.TaskReqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static backend.week8.common.constant.Constant.NOT_FOUND_TASK_REQ;
import static backend.week8.common.constant.Constant.TASK_REQ_IDS_EXECUTION_CONTEXT_KEY;

@Component
@RequiredArgsConstructor
public class TaskReqItemProcessor implements ItemProcessor<DadDetReportCsvDto, DadDetReport> {
	private final TaskReqRepository taskReqRepository;
	private StepExecution stepExecution;
	private ExecutionContext executionContext;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
		executionContext = stepExecution.getExecutionContext();
	}

	@Override
	public DadDetReport process(DadDetReportCsvDto item) {
		long taskReqId = executionContext.getLong(item.getFileName());
		TaskReq taskReq = taskReqRepository.findById(taskReqId)
				.orElseThrow(() -> new NoSuchElementException(NOT_FOUND_TASK_REQ));
		String advId = taskReq.getMember()
				.getMemberId();
		DadDetReportId dadDetReportId = new DadDetReportId(advId, item.getBaseDate(), item.getDadDetId());
		return new DadDetReport(dadDetReportId, item.getImpressions(), item.getClicks(), item.getAverageImpressionRank(), item.getAverageClickCost(), item.getAdvertisingCost());
	}

	@AfterStep
	public ExitStatus afterStep(StepExecution stepExecution) {
		List<Long> taskReqIds = (List<Long>) executionContext.get(TASK_REQ_IDS_EXECUTION_CONTEXT_KEY);
		if (taskReqIds != null) {
			taskReqRepository.updateStatusAndEndTime(taskReqIds, TaskStatus.COMPLETE, LocalDateTime.now());
		}
		return ExitStatus.COMPLETED;
	}
}
