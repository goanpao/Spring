package com.savio.ar.model.metric;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@XmlRootElement(name = "Ingest")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@Document(indexName = "metricprd", type = "ingest")
public class IngestEvent {

	@Id
	private String esId;
	private String typeOfRec;
	private String beginTimeStamp;
	private int numNewDocs;

	private int bytes;
	private double byteIndexedPerSecond;
	private double docsIndexedPerSecond;
	private double meanTotResp;
	private double maxTotResp;
	private int totalTokenSize;
	private int totalIndexTime;
	private int successCount;

	private int totalTimeInCpsQueue;
	private int totalTimeInCpsProcessing;
	private int totalTimeInCpsBatchProcessing;
	private int totalTimeInIndexQueue;
	private int totalTimeInIndexProcessing;
	private int totalTimeInIndexBatchProcessing;
	private int totalTimeInStatusdbQueue;
	private int totalTimeInStatusdbUpdating;
	private int totalTimeInStatusdbBatchUpdating;

	private int maxCpsProcessingTime;
	private int maxIndexingTime;

	private double meanLatency;
	private double maxLatency;
	
	@XmlElement(name = "TypeOfRec")
	public String getTypeOfRec() {
		return typeOfRec;
	}

	public void setTypeOfRec(String typeOfRec) {
		this.typeOfRec = typeOfRec;
	}

	@XmlElement(name = "BeginTimeStamp")
	public String getBeginTimeStamp() {
		return beginTimeStamp;
	}

	public void setBeginTimeStamp(String beginTimeStamp) {
		this.beginTimeStamp = beginTimeStamp;
	}

	@XmlElement(name = "ByteIndexedPerSecond")
	public double getByteIndexedPerSecond() {
		return byteIndexedPerSecond;
	}

	public void setByteIndexedPerSecond(double byteIndexedPerSecond) {
		this.byteIndexedPerSecond = byteIndexedPerSecond;
	}

	@XmlElement(name = "DocsIndexedPerSecond")
	public double getDocsIndexedPerSecond() {
		return docsIndexedPerSecond;
	}

	public void setDocsIndexedPerSecond(double docsIndexedPerSecond) {
		this.docsIndexedPerSecond = docsIndexedPerSecond;
	}

	
	@XmlElement(name = "MeanTotResp")
	public double getMeanTotResp() {
		return meanTotResp;
	}

	public void setMeanTotResp(double meanTotResp) {
		this.meanTotResp = meanTotResp;
	}
	
	@XmlElement(name = "MaxTotResp")
	public double getMaxTotResp() {
		return maxTotResp;
	}

	public void setMaxTotResp(double maxTotResp) {
		this.maxTotResp = maxTotResp;
	}
	
	@XmlElement(name = "TotalTokenSize")
	public int getTotalTokenSize() {
		return totalTokenSize;
	}

	public void setTotalTokenSize(int totalTokenSize) {
		this.totalTokenSize = totalTokenSize;
	}
	
	@XmlElement(name = "TotalIndexTime")
	public int getTotalIndexTime() {
		return totalIndexTime;
	}

	public void setTotalIndexTime(int totalIndexTime) {
		this.totalIndexTime = totalIndexTime;
	}

	@XmlElement(name = "SuccessCount")
	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	@XmlElement(name = "total_time_in_cps_queue")
	public int getTotalTimeInCpsQueue() {
		return totalTimeInCpsQueue;
	}

	public void setTotalTimeInCpsQueue(int totalTimeInCpsQueue) {
		this.totalTimeInCpsQueue = totalTimeInCpsQueue;
	}
	
	@XmlElement(name = "total_time_in_cps_processing")
	public int getTotalTimeInCpsProcessing() {
		return totalTimeInCpsProcessing;
	}

	public void setTotalTimeInCpsProcessing(int totalTimeInCpsProcessing) {
		this.totalTimeInCpsProcessing = totalTimeInCpsProcessing;
	}

	@XmlElement(name = "total_time_in_cps_batch_processing")
	public int getTotalTimeInCpsBatchProcessing() {
		return totalTimeInCpsBatchProcessing;
	}

	public void setTotalTimeInCpsBatchProcessing(
			int totalTimeInCpsBatchProcessing) {
		this.totalTimeInCpsBatchProcessing = totalTimeInCpsBatchProcessing;
	}

	@XmlElement(name = "total_time_in_index_queue")
	public int getTotalTimeInIndexQueue() {
		return totalTimeInIndexQueue;
	}

	public void setTotalTimeInIndexQueue(int totalTimeInIndexQueue) {
		this.totalTimeInIndexQueue = totalTimeInIndexQueue;
	}
	
	@XmlElement(name = "total_time_in_index_processing")
	public int getTotalTimeInIndexProcessing() {
		return totalTimeInIndexProcessing;
	}

	public void setTotalTimeInIndexProcessing(int totalTimeInIndexProcessing) {
		this.totalTimeInIndexProcessing = totalTimeInIndexProcessing;
	}

	@XmlElement(name = "total_time_in_index_batch_processing")
	public int getTotalTimeInIndexBatchProcessing() {
		return totalTimeInIndexBatchProcessing;
	}

	public void setTotalTimeInIndexBatchProcessing(int totalTimeInIndexBatchProcessing) {
		this.totalTimeInIndexBatchProcessing = totalTimeInIndexBatchProcessing;
	}
	
	@XmlElement(name = "total_time_in_statusdb_queue")
	public int getTotalTimeInStatusdbQueue() {
		return totalTimeInStatusdbQueue;
	}

	public void setTotalTimeInStatusdbQueue(
			int totalTimeInStatusdbQueue) {
		this.totalTimeInStatusdbQueue = totalTimeInStatusdbQueue;
	}

	@XmlElement(name = "total_time_in_statusdb_updating")
	public int getTotalTimeInStatusdbUpdating() {
		return totalTimeInStatusdbUpdating;
	}

	public void setTotalTimeInStatusdbUpdating(int totalTimeInStatusdbUpdating) {
		this.totalTimeInStatusdbUpdating = totalTimeInStatusdbUpdating;
	}

	@XmlElement(name = "total_time_in_statusdb_batch_updating")
	public int getTotalTimeInStatusdbBatchUpdating() {
		return totalTimeInStatusdbBatchUpdating;
	}

	public void setTotalTimeInStatusdbBatchUpdating(int totalTimeInStatusdbBatchUpdating) {
		this.totalTimeInStatusdbBatchUpdating = totalTimeInStatusdbBatchUpdating;
	}

	@XmlElement(name = "max_cps_processing_time")
	public int getMaxCpsProcessingTime() {
		return maxCpsProcessingTime;
	}

	public void setMaxCpsProcessingTime(int maxCpsProcessingTime) {
		this.maxCpsProcessingTime = maxCpsProcessingTime;
	}

	@XmlElement(name = "max_indexing_time")
	public int getMaxIndexingTime() {
		return maxIndexingTime;
	}

	public void setMaxIndexingTime(int maxIndexingTime) {
		this.maxIndexingTime = maxIndexingTime;
	}

	@XmlElement(name = "meanLatency")
	public double getMeanLatency() {
		return meanLatency;
	}

	public void setMeanLatency(double meanLatency) {
		this.meanLatency = meanLatency;
	}

	@XmlElement(name = "MaxLatency")
	public double getMaxLatency() {
		return maxLatency;
	}

	public void setMaxLatency(double maxLatency) {
		this.maxLatency = maxLatency;
	}

	@Override
	public String toString() {
		return "ClassPojo [ "
				+ ", TypeOfRec = " + typeOfRec
				+ ", BeginTimeStamp = " + beginTimeStamp
				+ ", NumNewDocs = " + numNewDocs 
				+ ", Bytes = " + bytes
				+ ", ByteIndexedPerSecond = " + byteIndexedPerSecond 
				+ ", DocsIndexedPerSecond = " + docsIndexedPerSecond 
				+ ", MeanTotResp = " + meanTotResp 
				+ ", MaxTotResp = " + maxTotResp 
				+ ", TotalTokenSize = " + totalTokenSize 
				+ ", TotalIndexTime = " + totalIndexTime
				+ ", SuccessCount = " + successCount
				+ ", total_time_in_cps_queue = " + totalTimeInCpsQueue
				+ ", total_time_in_cps_processing = " + totalTimeInCpsProcessing
				+ ", total_time_in_cps_batch_processing = " + totalTimeInCpsBatchProcessing 
				+ ", total_time_in_index_queue = " + totalTimeInIndexQueue
				+ ", total_time_in_index_processing = " + totalTimeInIndexProcessing 
				+ ", total_time_in_index_batch_processing = " + totalTimeInIndexBatchProcessing 
				+ ", total_time_in_statusdb_queue = " + totalTimeInStatusdbQueue
				+ ", total_time_in_statusdb_updating = " + totalTimeInStatusdbUpdating
				+ ", total_time_in_statusdb_batch_updating = " + totalTimeInStatusdbBatchUpdating
				+ ", max_cps_processing_time = " + maxCpsProcessingTime
				+ ", max_indexing_time = " + maxIndexingTime
				+ ", MeanLatency = " + meanLatency 
				+ ", MaxLatency = " + maxLatency
				+ "]";
	}
}
