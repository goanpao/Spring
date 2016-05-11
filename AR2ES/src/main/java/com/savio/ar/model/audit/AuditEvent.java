package com.savio.ar.model.audit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

@XmlRootElement(name = "event")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@Document(indexName="event", type="event")
public class AuditEvent {

	@Id
	private String id;
	private String searchType;
	
	private String component;	
	//@Field(type=FieldType.Date, index=FieldIndex.analyzed, format=DateFormat.basic_date_time)
	private String timestamp;
	
    private String query;
    private String searchTerm;
    private String objectId;
    @Field(type=FieldType.String, index=FieldIndex.not_analyzed)
    private String searchUserName;
    private String is_super_user;
    private QueryOptionCollection queryOptionCollection; 
    private String node_name;
    private String library_path;
    private String fetch_count;
    private String total_hits;
    private String start_time;
    private int exec_time;
    private int fetch_time;
    private int total_time;
    private String status;

	@XmlElement(name = "QUERY_ID")
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
		
	@XmlElement(name = "QUERY")
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String getSearchTerm() {
		return searchTerm;
	}
	
	public void setSearchTerm(String searchQuery) {
		this.searchTerm = "";

		Pattern ftcontains = Pattern.compile("(?<=\\. ftcontains)(.*?)(?=with)");
		Matcher m = ftcontains.matcher(searchQuery);
		while (m.find()) {
			this.searchTerm = m.group().replace("(", "").replace(")", "").replace("'", ""); 
		}
	}

	public String getObjectId() {
		return objectId;
	}
	
	public void setObjectId(String objectId) {
		this.objectId = "";

		Pattern ftcontains = Pattern.compile("(?<=r_object_id ftcontains)(.*?)(?=with)");
		Matcher m = ftcontains.matcher(objectId);
		while (m.find()) {
			this.objectId = m.group().replace("(", "").replace(")", "").replace("'", ""); 
		}
		
	}
	
	@XmlElement(name = "USER_NAME")
	public String getSearchUserName() {
		return searchUserName;
	}
	public void setSearchUserName(String searchUserName) {
		this.searchUserName = searchUserName;
	}
	
	@XmlElement(name = "IS_SUPER_USER")
	public String getIs_super_user() {
		return is_super_user;
	}
	public void setIs_super_user(String is_super_user) {
		this.is_super_user = is_super_user;
	}
	
	@XmlElement(name = "QUERY_OPTION")
	public QueryOptionCollection getQueryOptionCollection() {
		return queryOptionCollection;
	}
	public void setQueryOptionCollection(QueryOptionCollection queryOptionCollection) {
		this.queryOptionCollection = queryOptionCollection;
	}
	
	@XmlElement(name = "NODE_NAME")
	public String getNode_name() {
		return node_name;
	}
	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}
	
	@XmlElement(name = "LIBRARY_PATH")
	public String getLibrary_path() {
		return library_path;
	}
	public void setLibrary_path(String library_path) {
		this.library_path = library_path;
	}
	
	@XmlElement(name = "FETCH_COUNT")
	public String getFetch_count() {
		return fetch_count;
	}
	public void setFetch_count(String fetch_count) {
		this.fetch_count = fetch_count;
	}
	
	@XmlElement(name = "TOTAL_HITS")
	public String getTotal_hits() {
		return total_hits;
	}
	public void setTotal_hits(String total_hits) {
		this.total_hits = total_hits;
	}
	
	@XmlElement(name = "START_TIME")
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	
	@XmlElement(name = "EXEC_TIME")
	public int getExecTime() {
		return exec_time;
	}
	public void setExecTime(int exec_time) {
		this.exec_time = exec_time;
	}
	
	@XmlElement(name = "FETCH_TIME")
	public int getFetchTime() {
		return fetch_time;
	}
	public void setFetchTime(int fetch_time) {
		this.fetch_time = fetch_time;
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

	@Override
	public String toString() {
		return String.format("Event  [id=%s, searchType='%s', searchUserName='%s', time='%s']", id, searchType, searchUserName, timestamp  );
	}

}
