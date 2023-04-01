package backend.week8.domain.taskReq.repository;

import backend.week8.domain.taskReq.entity.TaskReq;
import backend.week8.domain.taskReq.entity.enus.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskReqRepository extends JpaRepository<TaskReq, Long> {
	@Query("SELECT t FROM TaskReq t JOIN FETCH t.member m WHERE t.status=:taskStatus")
	TaskReq findByStatus(TaskStatus taskStatus);

}
