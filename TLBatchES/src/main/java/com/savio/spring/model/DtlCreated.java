package com.savio.spring.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "created")
public class DtlCreated {

	private String createdDate;

	@XmlAttribute(name="date")
	public String getCreated() {
		return createdDate;
	}

	public void setCreated(String createdDate) {
		this.createdDate = createdDate;
	}

}
