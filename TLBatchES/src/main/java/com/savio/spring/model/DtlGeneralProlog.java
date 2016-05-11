package com.savio.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dtl-general-prolog")
public class DtlGeneralProlog {

	private String contentProvider;
	private String contentDomain;
	private String excludeFromIndex;
	private String includeInToc;
	private String language;
	private String publishedDate;
	private String recall;
	
	@XmlElement(name="content-provider")
	public String getContentProvider() {
		return contentProvider;
	}
	public void setContentProvider(String contentProvider) {
		this.contentProvider = contentProvider;
	}
	
	@XmlElement(name="content-domain")
	public String getContentDomain() {
		return contentDomain;
	}
	public void setContentDomain(String contentDomain) {
		this.contentDomain = contentDomain;
	}
	
	@XmlElement(name="exclude-from-index")
	public String getExcludeFromIndex() {
		return excludeFromIndex;
	}
	public void setExcludeFromIndex(String excludeFromIndex) {
		this.excludeFromIndex = excludeFromIndex;
	}
	
	@XmlElement(name="include-in-toc")
	public String getIncludeInToc() {
		return includeInToc;
	}
	public void setIncludeInToc(String includeInToc) {
		this.includeInToc = includeInToc;
	}
	
	@XmlElement(name="language")
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@XmlElement(name="published-date")
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	@XmlElement(name="recall")
	public String getRecall() {
		return recall;
	}
	public void setRecall(String recall) {
		this.recall = recall;
	}
		
}
