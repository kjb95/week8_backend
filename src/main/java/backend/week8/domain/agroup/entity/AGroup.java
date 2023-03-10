package backend.week8.domain.agroup.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;

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
	@CreationTimestamp
	@Column(name = "REG_TIME", nullable = false)
	private LocalDateTime regTime;

	@ColumnDefault("1")
	@Column(name = "AGROUP_ACT_YN", nullable = false)
	private int aGroupActYn;
	@ColumnDefault("1")

	@Column(name = "AGROUP_USE_CONFIG_YN", nullable = false)
	private int aGroupUseConfigYn;
}
