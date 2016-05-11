package com.savio.ar.model.metric;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@XmlRootElement(name = "Ingest")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@Document(indexName="metric", type="Warn")
public class WarnEvent {

	@Id
	private String esId;
	
	private String id;
	private String Format;
	private String Domain;
	private String TypeOfRec;
	private String BeginTimeStamp;
	private String ErrorCode;
	private String Error;

	@XmlElement(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "Format")
	public String getFormat() {
		return Format;
	}

	public void setFormat(String Format) {
		this.Format = Format;
	}

	@XmlElement(name = "Domain")
	public String getDomain() {
		return Domain;
	}

	public void setDomain(String Domain) {
		this.Domain = Domain;
	}

	@XmlElement(name = "TypeOfRec")
	public String getTypeOfRec() {
		return TypeOfRec;
	}

	public void setTypeOfRec(String TypeOfRec) {
		this.TypeOfRec = TypeOfRec;
	}

	@XmlElement(name = "ID")
	public String getBeginTimeStamp() {
		return BeginTimeStamp;
	}

	public void setBeginTimeStamp(String BeginTimeStamp) {
		this.BeginTimeStamp = BeginTimeStamp;
	}

	@XmlElement(name = "ErrorCode")
	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String ErrorCode) {
		this.ErrorCode = ErrorCode;
	}

	@XmlElement(name = "Error")
	public String getError() {
		return Error;
	}

	public void setError(String Error) {
		this.Error = Error;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", Format = " + Format + ", Domain = "
				+ Domain + ", TypeOfRec = " + TypeOfRec + ", BeginTimeStamp = "
				+ BeginTimeStamp + ", ErrorCode = " + ErrorCode + ", Error = "
				+ Error + "]";
	}
}
