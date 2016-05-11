package com.savio.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dtl-section-ref")
public class DtlSectionRef {

	private DtlCreated createdDate;

	@XmlElement(name="created")
	public DtlCreated getCreated() {
		return createdDate;
	}

	public void setCreated(DtlCreated createdDate) {
		this.createdDate = createdDate;
	}
	
}
