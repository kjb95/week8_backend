package backend.week8.domain.agroup.repository;

import backend.week8.domain.agroup.entity.AGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface AGroupRepository extends JpaRepository<AGroup, Long> {
	List<AGroup> findAllByAgroupActYn(int AgroupActYn);

	List<AGroup> findByAgroupNameContainsAndAgroupActYn(String aGroupName, int agroupActYn);

	boolean existsByAgroupName(String agroupName);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE AGroup ag SET ag.agroupUseConfigYn = :useConfig WHERE ag.agroupId IN :agroupIds")
	void updateUseConfig(List<Long> agroupIds, int useConfig);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE AGroup ag SET ag.agroupActYn = 0 WHERE ag.agroupId IN :agroupIds")
	void updateActOff(List<Long> agroupIds);

	Optional<AGroup> findByAgroupIdAndAgroupActYn(Long agroupId, int agroupActYn);
}