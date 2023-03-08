package backend.week8.domain.cnrReq.entity;

import backend.week8.domain.cnrReq.entity.enums.CnrIngStatus;
import backend.week8.domain.cnrReq.entity.enums.CnrInputDiv;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "CNR_REQ")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CnrReq {
    @Id
    @Column(name="CNR_REQ_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cnrReqId;

    @Column(name="DAD_DET_ID", nullable = false)
    private Long dadDetId;
    @Column(name="CNR_ING_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private CnrIngStatus cnrIngStatus;
    @Column(name="CNR_INPUT_DIV", nullable = false)
    @Enumerated(EnumType.STRING)
    private CnrInputDiv cnrInputDiv;
    @Column(name="CNR_REQ_TIME", nullable = false)
    private LocalDateTime cnrReqTime;
    @Column(name="CNR_PROC_TIME")
    private LocalDateTime cnrProcTime;
    @Column(name="CNR_COMPLETE_YN", nullable = false)
    private int cnrCompleteYn;
    @Column(name="CNR_FAIL_CAUSE")
    private String cnrFailCause;
    @Column(name="CNR_FAIL_COMT")
    private String cnrFailComt;
}
