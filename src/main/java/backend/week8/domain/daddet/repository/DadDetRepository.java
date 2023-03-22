package backend.week8.domain.daddet.repository;

import backend.week8.domain.daddet.entity.DadDet;
import backend.week8.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DadDetRepository extends JpaRepository<DadDet, Long> {
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE DadDet d SET d.dadUseConfigYn=:useConfig WHERE d.ad.adId IN (SELECT a.adId FROM Ad a WHERE a.item.itemId IN(:itemIds))")
	void updateUseConfig(List<Long> itemIds, int useConfig);

	@Query("SELECT d FROM DadDet d WHERE d.ad.adId IN (SELECT a.adId FROM Ad a WHERE a.item.itemId=:itemId) AND d.kwd.kwdName LIKE %:keywordName%")
	List<DadDet> findDadDetInItemLikeKeywordName(long itemId, String keywordName);
}

