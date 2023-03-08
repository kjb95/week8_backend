package backend.week8.domain.daddet.repository;

import backend.week8.domain.daddet.entity.DadDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadDetRepository extends JpaRepository<DadDet, Long> {
}
