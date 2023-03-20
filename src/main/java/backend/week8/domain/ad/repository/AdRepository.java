package backend.week8.domain.ad.repository;

import backend.week8.domain.ad.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
	int countByAgroup_AgroupNameAndAdUseConfigYnAndAdActYn(String aGroupName, int adUseConfigYn, int adActYn);

	int countByAgroup_AgroupNameAndAdActYn(String aGroupName, int adActYn);

	@Query("SELECT a FROM Ad a JOIN a.item i WHERE a.item.itemName LIKE %:itemName% AND a.item.itemNo LIKE %:itemNo% AND a.adv.advId=:advId AND a.agroup.agroupId=:agroupId AND a.item.itemActYn=1")
	List<Ad> findAdGroupWithItem(String itemName, String itemNo, String advId, Long agroupId);
}