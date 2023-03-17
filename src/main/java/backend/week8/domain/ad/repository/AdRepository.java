package backend.week8.domain.ad.repository;

import backend.week8.domain.ad.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
	int countByAgroup_AgroupNameAndAdUseConfigYnAndAdActYn(String aGroupName, int adUseConfigYn, int adActYn);

	int countByAgroup_AgroupNameAndAdActYn(String aGroupName, int adActYn);
}
