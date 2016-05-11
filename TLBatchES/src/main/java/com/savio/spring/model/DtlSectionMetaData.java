package com.savio.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dtl-section-metadata")
public class DtlSectionMetaData {

	private String contentDomain;
	private String includeInToc;
	
	@XmlElement(name="content-domain")
	public String getContentDomain() {
		return contentDomain;
	}
	
	public void setContentDomain(String contentDomain) {
		this.contentDomain = contentDomain;
	}
	
	@XmlElement(name="include-in-toc")
	public String getIncludeInToc() {
		return includeInToc;
	}
	
	public void setIncludeInToc(String includeInToc) {
		this.includeInToc = includeInToc;
	}
}
