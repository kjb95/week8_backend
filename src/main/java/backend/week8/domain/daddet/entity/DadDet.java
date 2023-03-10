package backend.week8.domain.daddet.entity;

import backend.week8.domain.ad.entity.Ad;
import backend.week8.domain.cnrReq.entity.CnrReq;
import backend.week8.domain.daddet.entity.enums.DadCnrStatus;
import backend.week8.domain.kwd.entity.Kwd;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "DAD_DET")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadDet {
    @Id
    @Column(name = "DAD_DET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dadDetId;

    @ManyToOne
    @JoinColumn(name = "AD_ID", nullable = false)
    private Ad ad;
    @ManyToOne
    @JoinColumn(name = "KWD_ID", nullable = false)
    private Kwd kwd;
    @Column(name = "DAD_CNR_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private DadCnrStatus dadCnrStatus;
    @OneToOne
    @JoinColumn(name = "CNR_REQ_ID", nullable = false)
    private CnrReq cnrReq;
    @Column(name = "DAD_USE_CONFIG_YN", nullable = false)
    private int dadUseConfigYn;
    @Column(name = "DAD_ACT_YN", nullable = false)
    private int dadActYn;
    @Column(name = "REG_TIME", nullable = false)
    private LocalDateTime regTime;
}
