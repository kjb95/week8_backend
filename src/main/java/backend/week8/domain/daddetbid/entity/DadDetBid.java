package backend.week8.domain.daddetbid.entity;

import backend.week8.domain.daddet.entity.DadDet;
import lombok.*;

import javax.persistence.*;

@Table(name = "DAD_DET_BID")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadDetBid {
    @Id
    @Column(name="DAD_DET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dadDetId;
    @OneToOne
    @MapsId
    @JoinColumn(name="DAD_DET_ID")
    private DadDet dadDet;

    @Column(name="BID_COST")
    private int bidCost;
}
