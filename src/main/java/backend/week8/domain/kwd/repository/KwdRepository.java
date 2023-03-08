package backend.week8.domain.kwd.repository;

import backend.week8.domain.kwd.entity.Kwd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KwdRepository extends JpaRepository<Kwd, Long> {
}
