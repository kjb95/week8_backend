package backend.week8.batch.listener;

import backend.week8.domain.taskReq.entity.TaskReq;
import backend.week8.domain.taskReq.entity.enus.TaskStatus;
import backend.week8.domain.taskReq.repository.TaskReqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterWrite;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;

import static backend.week8.common.constant.Constant.NOT_FOUND_TASK_REQ;
import static backend.week8.common.constant.Constant.TASK_REQ_ID_EXECUTION_CONTEXT_KEY;

@RequiredArgsConstructor
@Component
public class TaskReqListener {
	private final TaskReqRepository taskReqRepository;
	private final FlatFileItemReader flatFileItemReader;
	private StepExecution stepExecution;
	private ExecutionContext executionContext;
	@Value("${file.dir}")
	private String fileDir;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) throws MalformedURLException {
		this.stepExecution = stepExecution;
		executionContext = stepExecution.getExecutionContext();
		TaskReq taskReq = taskReqRepository.findByStatus(TaskStatus.REQ);
		taskReq.updateTaskStatusIng();
		taskReq.updateStartTime();
		taskReqRepository.save(taskReq);
		executionContext.put(TASK_REQ_ID_EXECUTION_CONTEXT_KEY, taskReq.getId());
		String fileFullPath = "file:" + fileDir + taskReq.getReqFilePath();
		flatFileItemReader.setResource(new UrlResource(fileFullPath));
	}

	@AfterWrite
	public void afterWrite() {
		long taskReqId = (long) executionContext.get(TASK_REQ_ID_EXECUTION_CONTEXT_KEY);
		TaskReq taskReq = taskReqRepository.findById(taskReqId)
				.orElseThrow(() -> new NoSuchElementException(NOT_FOUND_TASK_REQ));
		taskReq.updateTaskStatusComplete();
		taskReq.updateEndTime();
	}
}
