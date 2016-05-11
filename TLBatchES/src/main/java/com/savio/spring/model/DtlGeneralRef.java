package com.savio.spring.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dtl-general-ref")
public class DtlGeneralRef {

	private DtlCreated createdDate;
	private String collectionType;
	private String id;
	private String navtitle;
	private String type;
	private String href;
	
	@XmlElement(name="created")
	public DtlCreated getCreated() {
		return createdDate;
	}

	public void setCreated(DtlCreated createdDate) {
		this.createdDate = createdDate;
	}

	@XmlAttribute(name="collection-type")
	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	@XmlAttribute(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name="navtitle")
	public String getNavtitle() {
		return navtitle;
	}

	public void setNavtitle(String navtitle) {
		this.navtitle = navtitle;
	}

	@XmlAttribute(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlAttribute(name="href")
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
