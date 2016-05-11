package com.savio.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.elasticsearch.annotations.Document;


@XmlRootElement(name = "dtl-general")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@Document(indexName = "policy", type = "general")
public class DtlGeneral {

	private String id;
	private String title;
	private DtlGeneralProlog cd;
	private List<PGroups> pgroups = new ArrayList<PGroups>();

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlElement(name = "dtl-general-prolog")	
	public DtlGeneralProlog getCd() {
		return cd;
	}
	public void setCd(DtlGeneralProlog cd) {
		this.cd = cd;
	}
	
	@XmlElement(name = "pgroup")
	public List<PGroups> getPgroups() {
		return pgroups;
	}
	public void setPgroups(List<PGroups> pgroups) {
		this.pgroups = pgroups;
	}
	
	@Override
	public String toString() {
		return String.format("General  [id=%s, title='%s']", id, title  );
	}
	
	
}
