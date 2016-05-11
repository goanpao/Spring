package com.savio.ar.model.metric;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@XmlRootElement(name = "Ingest")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@Document(indexName="metric", type="IAMessage")
public class IngestIAEvent {

	@Id
	private String esId;
	
	private String ErrorType;
	private String Domain;
	private String ErrorMessage;
	private String TypeOfRec;
	private String QueueId;
	private String ID;
	private String BeginTimeStamp;
	private String IAInstanceName;

	@XmlElement(name = "ErrorType")
	public String getErrorType() {
		return ErrorType;
	}

	public void setErrorType(String ErrorType) {
		this.ErrorType = ErrorType;
	}

	@XmlElement(name = "Domain")
	public String getDomain() {
		return Domain;
	}

	public void setDomain(String Domain) {
		this.Domain = Domain;
	}

	@XmlElement(name = "ErrorMessage")
	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String ErrorMessage) {
		this.ErrorMessage = ErrorMessage;
	}

	@XmlElement(name = "TypeOfRec")
	public String getTypeOfRec() {
		return TypeOfRec;
	}

	public void setTypeOfRec(String TypeOfRec) {
		this.TypeOfRec = TypeOfRec;
	}

	@XmlElement(name = "QueueId")
	public String getQueueId() {
		return QueueId;
	}

	public void setQueueId(String QueueId) {
		this.QueueId = QueueId;
	}

	@XmlElement(name = "ID")
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	@XmlElement(name = "BeginTimeStamp")
	public String getBeginTimeStamp() {
		return BeginTimeStamp;
	}

	public void setBeginTimeStamp(String BeginTimeStamp) {
		this.BeginTimeStamp = BeginTimeStamp;
	}

	@XmlElement(name = "IAInstanceName")
	public String getIAInstanceName() {
		return IAInstanceName;
	}

	public void setIAInstanceName(String IAInstanceName) {
		this.IAInstanceName = IAInstanceName;
	}

	@Override
	public String toString() {
		return "ClassPojo [ErrorType = " + ErrorType + ", Domain = " + Domain
				+ ", ErrorMessage = " + ErrorMessage + ", TypeOfRec = "
				+ TypeOfRec + ", QueueId = " + QueueId + ", ID = " + ID
				+ ", BeginTimeStamp = " + BeginTimeStamp
				+ ", IAInstanceName = " + IAInstanceName + "]";
	}
}
