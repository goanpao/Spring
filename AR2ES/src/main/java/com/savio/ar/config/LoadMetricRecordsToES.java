package com.savio.ar.config;


import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.savio.ar.model.metric.MetricRecord;
import com.savio.ar.model.metric.Metrics;
import com.savio.ar.service.metric.MetricsEventService;

@Configuration
@EnableAutoConfiguration
@EnableElasticsearchRepositories(basePackages="com.savio.ar.repository")
@ComponentScan(basePackages="com.savio.ar.service")
public class LoadMetricRecordsToES implements CommandLineRunner {

	@Value("file:C:/AMS/xPloreAudit/metrics.xml")
	private Resource[] xmlFiles;

	@Autowired
    private MetricsEventService metricsEventService;
	
    public void run(String... args) throws Exception {
    	for (int i=0; i < xmlFiles.length; i++) {
    		System.out.println("File Name : " + xmlFiles[i].getFilename());
    		loadEvents(xmlFiles[i].getInputStream());
    	}    		
    }

    public void loadEvents(InputStream is) throws XMLStreamException, JAXBException {
		XMLInputFactory xif = XMLInputFactory.newInstance();
		XMLStreamReader xmlr = xif.createXMLStreamReader(is, "ISO-8859-1");
		
		JAXBContext jc = JAXBContext.newInstance(Metrics.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		xmlr.nextTag();						
		while(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
			JAXBElement<Metrics> jaxbEvent = unmarshaller.unmarshal(xmlr,Metrics.class);
			for (MetricRecord record : jaxbEvent.getValue().getRecords()) {
				metricsEventService.addEvent(record.getIngestEvent());
			}

			if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
				xmlr.next();
			}			
		}
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(LoadMetricRecordsToES.class, args);
    }    
}
