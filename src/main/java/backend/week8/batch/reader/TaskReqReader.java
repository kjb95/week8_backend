package backend.week8.batch.reader;

import backend.week8.batch.dto.DadDetReportCsvDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@RequiredArgsConstructor
@Configuration
public class TaskReqReader {
	@Bean
	public FlatFileItemReader taskReqItemReader() {
		return new FlatFileItemReaderBuilder<DadDetReportCsvDto>().name("taskReqItemReader")
				.targetType(DadDetReportCsvDto.class)
				.linesToSkip(1)
				.lineTokenizer(new DelimitedLineTokenizer())
				.build();
	}

	@Bean
	public MultiResourceItemReader multiResourceItemReader() {
		return new MultiResourceItemReaderBuilder<>().name("multiResourceItemReader")
				.resources(new Resource[]{})
				.delegate(taskReqItemReader())
				.build();
	}
}
