package backend.week8.domain.taskReq.repository;

import backend.week8.domain.taskReq.entity.TaskReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskReqRepository extends JpaRepository<TaskReq, Long> {
}
