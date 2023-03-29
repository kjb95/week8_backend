package backend.week8.domain.dadDetReport.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DadDetReportId implements Serializable {
	@Column(name = "ADV_ID")
	private String advId;
	@Column(name = "DATE")
	private LocalDateTime date;
	@Column(name = "DAD_DET_ID")
	private String dadDetId;
}
