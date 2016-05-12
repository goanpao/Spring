package com.savio.batch.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.savio.batch.config.XmlToJsonConfig;
import com.savio.batch.model.ControlData;
import com.savio.batch.model.General;
import com.savio.batch.model.PGroups;
import com.savio.batch.model.Paras;

@ComponentScan
@EnableAutoConfiguration
public class JaxbConversionApp {

	General general = null;
	
	public static void main(String[] args) {
//		JaxbConversionTest test = new JaxbConversionTest();
//		test.loadList();
//		test.displayList();
		
        ApplicationContext ctx = SpringApplication.run(XmlToJsonConfig.class, args);
//		System.exit(SpringApplication.exit(SpringApplication.run(
//		        XmlToJsonConfig.class, args)));
	}
	
	private void loadList() {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(General.class);
			XMLInputFactory xif = XMLInputFactory.newFactory();
	        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
	        XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(new File("C:/Temp/TL/Test/contracts.xml")));
	        
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			general = (General)unmarshaller.unmarshal(xsr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private void displayList() {
		System.out.println("General Id : " + general.getId());
		System.out.println("General Title: " + removeSpaces(general.getTitle()));
		ControlData cd = general.getCd();
		System.out.println("CD Domain : " + cd.getContentDomain());
		System.out.println("CD Content Provider : " + cd.getContentProvider());
		System.out.println("CD Language : " + cd.getLanguage());
		System.out.println("CD Publish Date : " + cd.getPublishedDate());
		for (PGroups pgroup : general.getPgroups()) {
			System.out.println("pGroup ID : " + pgroup.getPgroupId());
			System.out.println("pGroup Title : " + removeSpaces(pgroup.getTitle()));
			for (Paras paras : pgroup.getParas()) {
				System.out.println("Para ID : " + paras.getId());
				System.out.println("Para : " + removeSpaces(paras.getPtext()));
			}
		}		
	}
	
	private String removeSpaces(String str) {
		return str.replaceAll(" +", " ").replaceAll("[\n\r\t]", "").trim();
	}
}
