package com.savio.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pgroup")
public class PGroups {

	private String pgroupId;
	private String title;
	private List<Paras> paras = new ArrayList<Paras>();
	
	@XmlAttribute(name="id")
	public String getPgroupId() {
		return pgroupId;
	}
	public void setPgroupId(String pgroupId) {
		this.pgroupId = pgroupId;
	}
	
	@XmlElement(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlElement(name="paras")
	public List<Paras> getParas() {
		return paras;
	}
	public void setParas(List<Paras> paras) {
		this.paras = paras;
	}
	
	
}
