package com.savio.ar.model.audit;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "QUERY_OPTION")
public class QueryOptionCollection {
	private String collection=""; 
	private String domain="cmsprod"; 
	private String locale="en"; 
	private String batch_size="0"; 
	private String timeout="0"; 
	private String cached="true"; 
	private String spooling="false"; 
	private String security_eval="false"; 
	private String streaming_result="false"; 
	private String execution_plan="false"; 
	private String wait_for_results="true"; 
	private String security_filter=""; 
	private String return_summary="true"; 
	private String return_text="false"; 
	private String application_name=""; 
	private String parallel_execution="false"; 
	private String parallel_summary="false"; 
	private String system_query="false";

	@XmlAttribute(name = "COLLECTION")
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	
	@XmlAttribute(name = "DOMAIN")
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	@XmlAttribute(name = "LOCALE")
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	@XmlAttribute(name = "BATCH_SIZE")
	public String getBatch_size() {
		return batch_size;
	}
	public void setBatch_size(String batch_size) {
		this.batch_size = batch_size;
	}
	
	@XmlAttribute(name = "TIMEOUT")
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	
	@XmlAttribute(name = "CACHED")
	public String getCached() {
		return cached;
	}
	public void setCached(String cached) {
		this.cached = cached;
	}
	
	@XmlAttribute(name = "SPOOLING")
	public String getSpooling() {
		return spooling;
	}
	public void setSpooling(String spooling) {
		this.spooling = spooling;
	}
	
	@XmlAttribute(name = "SECURITY_EVAL")
	public String getSecurity_eval() {
		return security_eval;
	}
	public void setSecurity_eval(String security_eval) {
		this.security_eval = security_eval;
	}
	
	@XmlAttribute(name = "STREAMING_RESULT")
	public String getStreaming_result() {
		return streaming_result;
	}
	public void setStreaming_result(String streaming_result) {
		this.streaming_result = streaming_result;
	}
	
	@XmlAttribute(name = "EXECUTION_PLAN")
	public String getExecution_plan() {
		return execution_plan;
	}
	public void setExecution_plan(String execution_plan) {
		this.execution_plan = execution_plan;
	}
	
	@XmlAttribute(name = "WAIT_FOR_RESULTS")
	public String getWait_for_results() {
		return wait_for_results;
	}
	public void setWait_for_results(String wait_for_results) {
		this.wait_for_results = wait_for_results;
	}
	
	@XmlAttribute(name = "SECURITY_FILTER")
	public String getSecurity_filter() {
		return security_filter;
	}
	public void setSecurity_filter(String security_filter) {
		this.security_filter = security_filter;
	}
	
	@XmlAttribute(name = "RETURN_SUMMARY")
	public String getReturn_summary() {
		return return_summary;
	}
	public void setReturn_summary(String return_summary) {
		this.return_summary = return_summary;
	}
	
	@XmlAttribute(name = "RETURN_TEXT")
	public String getReturn_text() {
		return return_text;
	}
	public void setReturn_text(String return_text) {
		this.return_text = return_text;
	}
	
	@XmlAttribute(name = "APPLICATION_NAME")
	public String getApplication_name() {
		return application_name;
	}
	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}
	
	@XmlAttribute(name = "PARALLEL_EXECUTION")
	public String getParallel_execution() {
		return parallel_execution;
	}
	public void setParallel_execution(String parallel_execution) {
		this.parallel_execution = parallel_execution;
	}
	
	@XmlAttribute(name = "PARALLEL_SUMMARY")
	public String getParallel_summary() {
		return parallel_summary;
	}
	public void setParallel_summary(String parallel_summary) {
		this.parallel_summary = parallel_summary;
	}
	
	@XmlAttribute(name = "SYSTEM_QUERY")
	public String getSystem_query() {
		return system_query;
	}
	public void setSystem_query(String system_query) {
		this.system_query = system_query;
	}

}
