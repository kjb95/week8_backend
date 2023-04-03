package backend.week8.batch.reader;

import backend.week8.batch.dto.DadDetReportCsvDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

@RequiredArgsConstructor
public class CustomFieldSetMapper implements FieldSetMapper {
	private final MultiResourceItemReader multiResourceItemReader;

	@Override
	public DadDetReportCsvDto mapFieldSet(FieldSet fieldSet) throws BindException {
		String filename = multiResourceItemReader.getCurrentResource()
				.getFilename();
		return DadDetReportCsvDto.builder()
				.baseDate(fieldSet.readString("baseDate"))
				.dadDetId(fieldSet.readLong("dadDetId"))
				.impressions(fieldSet.readInt("impressions"))
				.clicks(fieldSet.readInt("clicks"))
				.averageImpressionRank(fieldSet.readDouble("averageImpressionRank"))
				.averageClickCost(fieldSet.readInt("averageClickCost"))
				.advertisingCost(fieldSet.readInt("advertisingCost"))
				.fileName(filename)
				.build();
	}
}