package com.savio.spring.config;


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
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.savio.spring.elasticsearch.ElasticSearchItemWriter;
import com.savio.spring.model.DtlSection;
import com.savio.spring.model.DtlGeneralProlog;
import com.savio.spring.model.DtlGeneral;
import com.savio.spring.model.DtlSectionMetaData;
import com.savio.spring.model.DtlSectionRef;
import com.savio.spring.model.PGroups;
import com.savio.spring.model.Paras;
import com.savio.spring.processor.DtlGeneralESFilterProcessor;
import com.savio.spring.processor.DtlGeneralFilterProcessor;
import com.savio.spring.processor.DtlSectionESFilterProcessor;
import com.savio.spring.processor.DtlSectionFilterProcessor;


@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
public class TLBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Value("file:C:/Temp/TL/iiGAAP2014/*.xml")
	private Resource[] xmlFiles;
		  
	@Bean
	public MultiResourceItemReader<DtlGeneral> multiResourceGeneralReader() throws Exception {
		MultiResourceItemReader<DtlGeneral> multiResourceReader = new MultiResourceItemReader<DtlGeneral>();
		
		multiResourceReader.setResources(xmlFiles);
		multiResourceReader.setDelegate(xmlGeneralItemReader());
		
		return multiResourceReader;
	}

	@Bean
	public MultiResourceItemReader<DtlSection> multiResourceSectionReader() throws Exception {
		MultiResourceItemReader<DtlSection> multiResourceSectionReader = new MultiResourceItemReader<DtlSection>();
		
		multiResourceSectionReader.setResources(xmlFiles);
		multiResourceSectionReader.setDelegate(xmlSectionItemReader());
		
		return multiResourceSectionReader;
	}

	@Bean
	public StaxEventItemReader<DtlGeneral> xmlGeneralItemReader() throws Exception {
		Jaxb2Marshaller genUnMarshaller = new Jaxb2Marshaller();
		genUnMarshaller.setClassesToBeBound(new Class[] { DtlGeneral.class, DtlGeneralProlog.class, PGroups.class, Paras.class });
		genUnMarshaller.afterPropertiesSet();

		StaxEventItemReader<DtlGeneral> xmlGeneralItemReader = new StaxEventItemReader<DtlGeneral>();
		xmlGeneralItemReader.setUnmarshaller(genUnMarshaller);
		xmlGeneralItemReader.setFragmentRootElementName("dtl-general");
		return xmlGeneralItemReader;
	}

	@Bean
	public StaxEventItemReader<DtlSection> xmlSectionItemReader() throws Exception {
		Jaxb2Marshaller genUnMarshaller = new Jaxb2Marshaller();
		genUnMarshaller.setClassesToBeBound(new Class[] { DtlSection.class, DtlSectionMetaData.class, DtlSectionRef.class });
		genUnMarshaller.afterPropertiesSet();

		StaxEventItemReader<DtlSection> xmlSectionItemReader = new StaxEventItemReader<DtlSection>();
		xmlSectionItemReader.setUnmarshaller(genUnMarshaller);
		xmlSectionItemReader.setFragmentRootElementName("dtl-section");
		return xmlSectionItemReader;
	}

	@Bean
	public ItemProcessor<DtlGeneral, DtlGeneral> generalFilterProcessor() {
		return new DtlGeneralFilterProcessor();
	}

	@Bean
	public ItemProcessor<DtlSection, DtlSection> sectionFilterProcessor() {
		return new DtlSectionFilterProcessor();
	}

	@Bean
	public ItemProcessor<DtlGeneral, IndexQuery> generalESFilterProcessor() {
		return new DtlGeneralESFilterProcessor();
	}

	@Bean
	public ItemProcessor<DtlSection, IndexQuery> sectionESFilterProcessor() {
		return new DtlSectionESFilterProcessor();
	}

	@Bean
	public ItemWriter<DtlGeneral> fileGeneralWriter() {
		FlatFileItemWriter<DtlGeneral> fileWriter = new FlatFileItemWriter<DtlGeneral>();
		fileWriter.setResource(new FileSystemResource(
				"C:/Temp/TL/Test/outputGeneral.txt"));
		fileWriter.setShouldDeleteIfExists(true);
		PassThroughLineAggregator<DtlGeneral> lineAggregator = new PassThroughLineAggregator<DtlGeneral>();
		fileWriter.setLineAggregator(lineAggregator);
		fileWriter.close();
		return fileWriter;
	}
	
	@Bean
	public ItemWriter<DtlSection> fileSectionWriter() {
		FlatFileItemWriter<DtlSection> fileWriter = new FlatFileItemWriter<DtlSection>();
		fileWriter.setResource(new FileSystemResource(
				"C:/Temp/TL/Test/outputSection.txt"));
		fileWriter.setShouldDeleteIfExists(true);
		PassThroughLineAggregator<DtlSection> lineAggregator = new PassThroughLineAggregator<DtlSection>();
		fileWriter.setLineAggregator(lineAggregator);
		fileWriter.close();
		return fileWriter;
	}

	
    @Bean
    public ElasticSearchItemWriter elasticSearchItemWriter() throws Exception {
//    	ElasticSearchItemWriter elasticSearchItemWriter = new ElasticSearchItemWriter(elasticSearchOperations());
//    	elasticSearchItemWriter.afterPropertiesSet();
//    	List<IndexQuery> items = asList(query());
//    	elasticSearchItemWriter.write();
//        return elasticSearchItemWriter;
    	return new ElasticSearchItemWriter(elasticSearchOperations());
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
	public Job importGeneralJob(JobBuilderFactory jobs, Step step1, Step step2) {
		return jobs
				.get("importTL")
				.incrementer(new RunIdIncrementer())
				.start(step1)
				.next(step2)
				.build();
	}

	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory,
			ItemReader<DtlGeneral> multiResourceGeneralReader, 
			ItemWriter<IndexQuery> elasticSearchItemWriter,
			ItemProcessor<DtlGeneral, IndexQuery> generalFilterProcessor) {
		return stepBuilderFactory.get("step1")
				.<DtlGeneral, IndexQuery> chunk(10)
				.reader(multiResourceGeneralReader)
				.processor(generalFilterProcessor)
				.writer(elasticSearchItemWriter)
				.build();
	}
	
	@Bean
	public Step step2(StepBuilderFactory stepBuilderFactory,
			ItemReader<DtlSection> multiResourceSectionReader, 
			ItemWriter<IndexQuery> elasticSearchItemWriter,
			ItemProcessor<DtlSection, IndexQuery> sectionFilterProcessor) {
		return stepBuilderFactory.get("step2")
				.<DtlSection, IndexQuery> chunk(10)
				.reader(multiResourceSectionReader)
				.processor(sectionFilterProcessor)
				.writer(elasticSearchItemWriter)
				.build();
	}

}
