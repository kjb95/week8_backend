package backend.week8.domain.taskReq.entity;

import backend.week8.domain.member.entity.Member;
import backend.week8.domain.taskReq.entity.enus.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "TASK_REQ")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskReq {

	public TaskReq(Member member, String taskName, String taskReqFilePath) {
		this.member = member;
		this.taskName = taskName;
		this.taskReqFilePath = taskReqFilePath;
		taskStatus = TaskStatus.REQ;
		taskReqTime = LocalDateTime.now();
	}

	@Id
	@Column(name = "TASK_REQ_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID")
	private Member member;
	@Enumerated(EnumType.STRING)
	@Column(name = "TASK_STATUS")
	private TaskStatus taskStatus;
	@Column(name = "TASK_NAME")
	private String taskName;
	@Column(name = "TASK_REQ_FILE_PATH")
	private String taskReqFilePath;
	@Column(name = "TASK_REQ_TIME")
	private LocalDateTime taskReqTime;
	@Column(name = "TASK_START_TIME")
	private LocalDateTime taskStartTime;
	@Column(name = "TASK_END_TIME")
	private LocalDateTime taskEndTime;
}
