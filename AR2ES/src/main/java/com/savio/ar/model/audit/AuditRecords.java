package com.savio.ar.model.audit;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auditrecords")
public class AuditRecords {

	private List<AuditMergeEvent> events = new ArrayList<AuditMergeEvent>();

	@XmlElement(name = "event")
	public List<AuditMergeEvent> getEvents() {
		return events;
	}

	public void setEvents(List<AuditMergeEvent> events) {
		this.events = events;
	}
	
}
