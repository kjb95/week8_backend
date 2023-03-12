package backend.week8.domain.agroup.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "AGroup")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AGroup {
	@Id
	@Column(name = "AGROUP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aGroupId;

	@Column(name = "AGROUP_NAME", nullable = false)
	private String aGroupName;
	@Column(name = "REG_TIME", nullable = false)
	private LocalDateTime regTime;
	@Column(name = "AGROUP_ACT_YN", nullable = false)
	private int aGroupActYn;
	@Column(name = "AGROUP_USE_CONFIG_YN", nullable = false)
	private int aGroupUseConfigYn;
}
