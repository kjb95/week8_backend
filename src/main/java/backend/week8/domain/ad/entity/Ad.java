package backend.week8.domain.ad.entity;

import backend.week8.domain.adv.entity.Adv;
import backend.week8.domain.agroup.entity.AGroup;
import backend.week8.domain.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "AD")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ad {
    @Id
    @Column(name = "AD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adId;

    @OneToOne
    @JoinColumn(name = "AGROUP_ID", nullable = false)
    private AGroup aGroup;
    @ManyToOne
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item item;
    @Column(name = "AD_USE_CONFIG_YN", nullable = false)
    private int adUseConfigYn;
    @Column(name = "REG_TIME", nullable = false)
    private LocalDateTime regTime;
    @Column(name = "AD_ACT_YN", nullable = false)
    private int adActYn;
    @ManyToOne
    @JoinColumn(name = "ADV_ID", nullable = false)
    private Adv adv;
}
