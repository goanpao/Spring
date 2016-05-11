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

import com.savio.ar.model.audit.AuditRecords;
import com.savio.ar.model.audit.AuditEvent;
import com.savio.ar.model.audit.AuditMergeEvent;
import com.savio.ar.service.audit.AuditEventService;

@Configuration
@EnableAutoConfiguration
@EnableElasticsearchRepositories(basePackages="com.savio.ar.repository")
@ComponentScan(basePackages="com.savio.ar.service")
public class LoadAuditRecordsToES implements CommandLineRunner {

	@Value("file:C:/AMS/xPloreAudit/auditRecords.xml")
	private Resource[] xmlFiles;

	@Autowired
    private AuditEventService eventService;
	
    public void run(String... args) throws Exception {
    	for (int i=0; i < xmlFiles.length; i++) {
    		System.out.println("File Name : " + xmlFiles[i].getFilename());
    		loadEvents(xmlFiles[i].getInputStream());
    	}    		
    }

    public void loadEvents(InputStream is) throws XMLStreamException, JAXBException {
		XMLInputFactory xif = XMLInputFactory.newInstance();
		XMLStreamReader xmlr = xif.createXMLStreamReader(is, "ISO-8859-1");
		
		JAXBContext jc = JAXBContext.newInstance(AuditRecords.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		xmlr.nextTag();						
		while(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
			JAXBElement<AuditRecords> jaxbEvent = unmarshaller.unmarshal(xmlr,AuditRecords.class);
//			for (AuditEvent event : jaxbEvent.getValue().getEvents()) {
//				if (event.getQuery() != null) {
//					event.setSearchTerm(event.getQuery());
//					event.setObjectId(event.getQuery());
//				}
//				eventService.addEvent(event);
//			}
			for (AuditMergeEvent mergeEvent : jaxbEvent.getValue().getEvents()) {
				if (mergeEvent.getSearchType().equals("FINAL_MERGE"))
					eventService.addMergeEvent(mergeEvent);
			}

			if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
				xmlr.next();
			}			
		}
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(LoadAuditRecordsToES.class, args);
    }    
}
