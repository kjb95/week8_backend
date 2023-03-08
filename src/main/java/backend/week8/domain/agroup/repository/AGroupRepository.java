package backend.week8.domain.agroup.repository;

import backend.week8.domain.agroup.entity.AGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AGroupRepository extends JpaRepository<AGroup, String> {

}