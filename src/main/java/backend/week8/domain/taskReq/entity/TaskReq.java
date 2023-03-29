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

	public TaskReq(Member member, String name, String reqFilePath) {
		this.member = member;
		this.name = name;
		this.reqFilePath = reqFilePath;
		status = TaskStatus.REQ;
		reqTime = LocalDateTime.now();
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
	private TaskStatus status;
	@Column(name = "TASK_NAME")
	private String name;
	@Column(name = "TASK_REQ_FILE_PATH")
	private String reqFilePath;
	@Column(name = "TASK_REQ_TIME")
	private LocalDateTime reqTime;
	@Column(name = "TASK_START_TIME")
	private LocalDateTime startTime;
	@Column(name = "TASK_END_TIME")
	private LocalDateTime endTime;
}
