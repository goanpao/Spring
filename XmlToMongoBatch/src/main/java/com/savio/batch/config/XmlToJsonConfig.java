package com.savio.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemWriter;
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
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.savio.batch.model.ControlData;
import com.savio.batch.model.General;
import com.savio.batch.model.PGroups;
import com.savio.batch.model.Paras;
import com.savio.batch.processor.GeneralFilterProcessor;

@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
public class XmlToJsonConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

//	@Bean 
//	public ResourcelessTransactionManager transactionManager() {
//		return new ResourcelessTransactionManager();
//	}
//			    
//	@Bean 
//	public MapJobRepositoryFactoryBean jobRepository() {
//		MapJobRepositoryFactoryBean jobRepository = new MapJobRepositoryFactoryBean();
//		jobRepository.setTransactionManager(transactionManager());
//		return jobRepository;
//	}
//
//	@Bean
//	public SimpleJobLauncher jobLauncher() {
//		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
//		jobLauncher.setJobRepository((JobRepository) jobRepository());
//		return jobLauncher;
//	}
//			    
	@Value("file:C:/Temp/TL/iiGAAP2014/*.xml")
	private Resource[] xmlFiles;
		  
	@Bean
	public MultiResourceItemReader<General> multiResourceReader() throws Exception {
		MultiResourceItemReader<General> multiResourceReader = new MultiResourceItemReader<General>();
		
		multiResourceReader.setResources(xmlFiles);
		multiResourceReader.setDelegate(xmlItemReader());
		
		return multiResourceReader;
	}
	
	
	@Bean
	public StaxEventItemReader<General> xmlItemReader() throws Exception {
		Jaxb2Marshaller genUnMarshaller = new Jaxb2Marshaller();
		genUnMarshaller.setClassesToBeBound(new Class[] { General.class, ControlData.class, PGroups.class, Paras.class });
		genUnMarshaller.afterPropertiesSet();

		StaxEventItemReader<General> xmlItemReader = new StaxEventItemReader<General>();
		xmlItemReader.setUnmarshaller(genUnMarshaller);
		xmlItemReader.setFragmentRootElementName("dtl-general");
//		xmlItemReader.setResource(new FileSystemResource(
//				"C:/Temp/TL/Test/contracts.xml"));
		return xmlItemReader;
	}

	@Bean
	public ItemProcessor<General, General> generalFilterProcessor() {
		return new GeneralFilterProcessor();
	}

	@Bean
	public ItemWriter<General> fileWriter() {
		FlatFileItemWriter<General> fileWriter = new FlatFileItemWriter<General>();
		fileWriter.setResource(new FileSystemResource(
				"C:/Temp/TL/Test/outputGeneral.txt"));
		fileWriter.setShouldDeleteIfExists(true);
		PassThroughLineAggregator<General> lineAggregator = new PassThroughLineAggregator<General>();
		fileWriter.setLineAggregator(lineAggregator);
		fileWriter.close();
		return fileWriter;
	}

	@Bean 
	public Mongo mongo() throws Exception {
	      return new MongoClient("localhost");
	 }
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "TL");
	}
	
	@Bean 
	public ItemWriter<General> mongodbItemWriter() throws Exception {
		MongoItemWriter<General> mongodbItemWriter = new MongoItemWriter<General>();
		mongodbItemWriter.setTemplate(mongoTemplate());
		mongodbItemWriter.setCollection("General");
		return mongodbItemWriter;
	}

		
	@Bean
	public Job importGeneralJob(JobBuilderFactory jobs, Step step1) {
		return jobs
				.get("importGeneral")
				.incrementer(new RunIdIncrementer())
				.flow(step1)
				.end()
				.build();
	}

	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory,
			ItemReader<General> multiResourceReader, 
			ItemWriter<General> mongodbItemWriter,
			ItemProcessor<General, General> generalFilterProcessor) {
		return stepBuilderFactory.get("step1")
				.<General, General> chunk(10)
				.reader(multiResourceReader)
				.processor(generalFilterProcessor)
				.writer(mongodbItemWriter)
				.build();
	}
	
}
