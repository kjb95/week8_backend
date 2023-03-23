package backend.week8.domain.daddetbid.repository;

import backend.week8.domain.daddetbid.entity.DadDetBid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadDetBidRepository extends JpaRepository<DadDetBid, Long> {
}
