package com.savio.ar.model.audit;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@XmlRootElement(name = "event")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@Document(indexName="mergeevent", type="mergeevent")
public class AuditMergeEvent {

	@Id
	private String id;
	private String searchType;
	private String component;
	private String timestamp;

	private String indexName;
	private int indexSize;
	private String domain;
	private String collection;
	private String library_path;
	private String node_name;
	private String type;
	private String triggerTime;
	private String start_time;
	private String finishTime;
	private int waitTime;
	private int processTime;
	private int total_time;
	private String status;
	private String detail;
	private String storageLocation;

	@XmlElement(name = "MERGE_ID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

    @XmlAttribute(name = "name")
    public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	@XmlAttribute(name = "component")
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}

	@XmlAttribute(name = "timestamp")
	//@XmlJavaTypeAdapter(EventDateAdapter.class)
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	@XmlElement(name = "INDEX_NAME")
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	
	@XmlElement(name = "INDEX_SIZE")
	public int getIndexSize() {
		return indexSize;
	}
	public void setIndexSize(int indexSize) {
		this.indexSize = indexSize;
	}
	
	@XmlElement(name = "DOMAIN")
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	@XmlElement(name = "COLLECTION")
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	
	@XmlElement(name = "LIBRARY_PATH")
	public String getLibrary_path() {
		return library_path;
	}
	public void setLibrary_path(String library_path) {
		this.library_path = library_path;
	}
	
	@XmlElement(name = "NODE_NAME")
	public String getNode_name() {
		return node_name;
	}
	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}
			
	@XmlElement(name = "TYPE")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement(name = "TRIGGER_TIME")
	public String getTriggerTime() {
		return triggerTime;
	}
	public void setTriggerTime(String triggerTime) {
		this.triggerTime = triggerTime;
	}
	
	@XmlElement(name = "START_TIME")
	public String getStart_time() {
		return start_time;
	}
	public void setStartTime(String start_time) {
		this.start_time = start_time;
	}
	
	@XmlElement(name = "FINISH_TIME")
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	
	@XmlElement(name = "WAIT_TIME")
	public int getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	@XmlElement(name = "PROCESS_TIME")
	public int getProcessTime() {
		return processTime;
	}
	public void setProcessTime(int processTime) {
		this.processTime = processTime;
	}
	
	@XmlElement(name = "TOTAL_TIME")
	public int getTotalTime() {
		return total_time;
	}
	public void setTotalTime(int total_time) {
		this.total_time = total_time;
	}
	
	@XmlElement(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@XmlElement(name = "DETAIL")
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@XmlElement(name = "STORAGE_LOCATION")
	public String getStorageLocation() {
		return storageLocation;
	}
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	
	@Override
	public String toString() {
		return String.format("MergeEvent  [id=%s, searchType='%s', indexName='%s', time='%s']", id, searchType, indexName, timestamp  );
	}

}
