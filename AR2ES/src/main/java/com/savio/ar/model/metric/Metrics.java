package com.savio.ar.model.metric;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metrics")
public class Metrics {

	private List<MetricRecord> records = new ArrayList<MetricRecord>();
	
	@XmlElement(name = "record")
	public List<MetricRecord> getRecords() {
		return records;
	}

	public void setRecords(List<MetricRecord> records) {
		this.records = records;
	}

}
