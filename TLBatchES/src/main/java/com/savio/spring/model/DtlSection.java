package com.savio.spring.model;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.elasticsearch.annotations.Document;

@XmlRootElement(name = "dtl-section")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@Document(indexName = "policy", type = "section")
public class DtlSection {

	private String id;
	private String otherprops;
	private String title;
	private DtlSectionMetaData smd;
	private DtlSectionRef sref;

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute(name = "otherprops")
	public String getOtherprops() {
		return otherprops;
	}
	public void setOtherprops(String otherprops) {
		this.otherprops = otherprops;
	}
	
	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlElement(name = "dtl-section-metadata")
	public DtlSectionMetaData getSmd() {
		return smd;
	}
	public void setSmd(DtlSectionMetaData smd) {
		this.smd = smd;
	}
	
	@XmlElement(name = "dtl-section-ref")
	public DtlSectionRef getSref() {
		return sref;
	}
	public void setSref(DtlSectionRef sref) {
		this.sref = sref;
	}
	
	@Override
	public String toString() {
		return String.format("Section  [id=%s, title='%s']", id, title  );
	}

}
