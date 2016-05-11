package com.savio.ar.model.metric;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "record")
public class MetricRecord {

	private IngestEvent ingestEvent;
	private String timestamp;
	
	@XmlElement(name = "Ingest")
	public IngestEvent getIngestEvent() {
		return ingestEvent;
	}

	public void setIngestEvent(IngestEvent ingestEvent) {
		this.ingestEvent = ingestEvent;
	}

	@XmlAttribute(name = "timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
