package com.savio.diag.config;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import com.savio.diag.model.DA3Log;
import com.savio.diag.process.DA3LogESItemProcessor;
import com.savio.diag.process.DA3LogItemProcessor;
import com.savio.spring.elasticsearch.ElasticSearchItemWriter;

@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
public class DaDiagBatchConfiguration {

	@Value("file:C:/OPS/SD/2298764/INBCP0145/DA3LOG.TSV")
	private Resource diagTSVFile;

	@Bean
    public ItemReader<DA3Log> fileReader() {
    FlatFileItemReader<DA3Log> reader = new FlatFileItemReader<DA3Log>();
    reader.setResource(diagTSVFile);
    reader.setLinesToSkip(2);
    reader.setLineMapper(new DefaultLineMapper<DA3Log>() {{
        setLineTokenizer(new DelimitedLineTokenizer(DelimitedLineTokenizer.DELIMITER_TAB) {{
            setNames(new String[] { "DALogEntryID","EventID","Priority","DASeverity","Title",
            		"EventDateTime","LocalComputerName","AppDomainName","ProcessID","ProcessName",
            		"ThreadName","Win32ThreadId","Message","ModuleName","TransactionID","EngagementFileID",
            		"DAErrorCodeID","UserID","BusinessOperation","BusinessOperationStatus","LocalVersion",
            		"RemoteVersion","LogicalEMSServerID" } );
        }});
        setFieldSetMapper(new BeanWrapperFieldSetMapper<DA3Log>() {{
            setTargetType(DA3Log.class);
        }});
    }});
    return reader;	
	}
	
	@Bean
    public ItemProcessor<DA3Log, DA3Log> da3LogItemProcessor() {
        return new DA3LogItemProcessor();
    }
	
	@Bean
	public ItemWriter<DA3Log> fileWriter() {
		FlatFileItemWriter<DA3Log> fileWriter = new FlatFileItemWriter<DA3Log>();
		fileWriter.setResource(new FileSystemResource(
				"C:/OPS/SD/2298764/INBCP0145/outputDiag.txt"));
		fileWriter.setShouldDeleteIfExists(true);
		PassThroughLineAggregator<DA3Log> lineAggregator = new PassThroughLineAggregator<DA3Log>();
		fileWriter.setLineAggregator(lineAggregator);
		fileWriter.close();
		return fileWriter;
	}

	@Bean
	public ItemProcessor<DA3Log, IndexQuery> da3LogESItemProcessor() {
		return new DA3LogESItemProcessor();
	}

    @Bean
    public SearchQuery query() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        // create query as required using the methods on the builder object
        return builder.build();
    }

	@Bean
	public ElasticsearchOperations elasticSearchOperations() {
		final NodeBuilder nodeBuilder = new NodeBuilder();
		return new ElasticsearchTemplate(nodeBuilder.clusterName("elasticsearch").node().client());
	}
	
    @Bean
    public ElasticSearchItemWriter elasticSearchItemWriter() throws Exception {
    	return new ElasticSearchItemWriter(elasticSearchOperations());
    }	
    
    @Bean
    public Job importDiagJob(JobBuilderFactory jobs, Step step2) {
        return jobs.get("importDiagJob")
                .incrementer(new RunIdIncrementer())
                .flow(step2)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<DA3Log> fileReader,
            ItemWriter<DA3Log> fileWriter, ItemProcessor<DA3Log, DA3Log> da3LogItemProcessor) {
        return stepBuilderFactory.get("step1")
                .<DA3Log, DA3Log> chunk(10)
                .reader(fileReader)
                .processor(da3LogItemProcessor)
                .writer(fileWriter)
                .build();
    }

	@Bean
	public Step step2(StepBuilderFactory stepBuilderFactory,
			ItemReader<DA3Log> multiResourceGeneralReader, 
			ItemWriter<IndexQuery> elasticSearchItemWriter,
			ItemProcessor<DA3Log, IndexQuery> generalFilterProcessor) {
		return stepBuilderFactory.get("step2")
				.<DA3Log, IndexQuery> chunk(10)
				.reader(multiResourceGeneralReader)
				.processor(generalFilterProcessor)
				.writer(elasticSearchItemWriter)
				.build();
	}
    
}
