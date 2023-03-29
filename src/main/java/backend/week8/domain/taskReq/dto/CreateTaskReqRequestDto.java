package backend.week8.domain.taskReq.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateTaskReqRequestDto {
	private String memberId;
	private String jobName;
	private String taskReqFile;
}
