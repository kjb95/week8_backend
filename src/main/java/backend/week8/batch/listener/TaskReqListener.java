package backend.week8.batch.listener;

import backend.week8.domain.taskReq.entity.TaskReq;
import backend.week8.domain.taskReq.entity.enus.TaskStatus;
import backend.week8.domain.taskReq.repository.TaskReqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static backend.week8.common.constant.Constant.TASK_REQ_IDS_EXECUTION_CONTEXT_KEY;

@RequiredArgsConstructor
@Component
public class TaskReqListener {
	private final TaskReqRepository taskReqRepository;
	private final MultiResourceItemReader multiResourceItemReader;
	private ExecutionContext executionContext;
	@Value("${file.dir}")
	private String fileDir;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) throws MalformedURLException {
		List<TaskReq> taskReqs = taskReqRepository.findByStatus(TaskStatus.REQ);
		if (taskReqs.size() == 0) {
			return;
		}
		executionContext = stepExecution.getExecutionContext();
		setResources(taskReqs);
		List<Long> taskReqIds = updateExecutionContext(taskReqs);
		taskReqRepository.updateStatusAndStartTime(taskReqIds, TaskStatus.ING, LocalDateTime.now());
	}

	private void setResources(List<TaskReq> taskReqs) throws MalformedURLException {
		Resource[] resources = new Resource[taskReqs.size()];
		for (int i = 0; i < taskReqs.size(); i++) {
			TaskReq taskReq = taskReqs.get(i);
			String fileFullPath = "file:" + fileDir + taskReq.getReqFilePath();
			resources[i] = new UrlResource(fileFullPath);
		}
		multiResourceItemReader.setResources(resources);
	}

	private List<Long> updateExecutionContext(List<TaskReq> taskReqs) {
		List<Long> taskReqIds = taskReqs.stream()
				.map(TaskReq::getId)
				.collect(Collectors.toList());
		executionContext.put(TASK_REQ_IDS_EXECUTION_CONTEXT_KEY, taskReqIds);
		return taskReqIds;
	}
}
