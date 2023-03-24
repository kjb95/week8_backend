package backend.week8.domain.dadDet.repository;

import backend.week8.domain.dadDet.entity.DadDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DadDetRepository extends JpaRepository<DadDet, Long> {
	@Modifying(clearAutomatically = true)
	@Query("UPDATE DadDet d SET d.dadUseConfigYn=:useConfig WHERE d.ad.adId IN (SELECT a.adId FROM Ad a WHERE a.item.itemId IN(:itemIds))")
	void updateUseConfigByItemIds(List<Long> itemIds, int useConfig);

	@Query("SELECT d FROM DadDet d JOIN FETCH d.kwd k WHERE d.ad.adId IN (SELECT a.adId FROM Ad a WHERE a.item.itemId=:itemId) AND k.kwdName LIKE %:keywordName% AND d.dadActYn=1")
	List<DadDet> findDadDetInItemLikeKeywordName(long itemId, String keywordName);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE DadDet d SET d.dadUseConfigYn=:useConfig WHERE d.kwd.kwdId IN :kwdIds")
	void updateUseConfigByKwdIds(List<Long> kwdIds, int useConfig);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE DadDet d SET d.dadActYn=0 WHERE d.kwd.kwdId IN :kwdIds")
	void updateDadDetActOff(List<Long> kwdIds);
}

