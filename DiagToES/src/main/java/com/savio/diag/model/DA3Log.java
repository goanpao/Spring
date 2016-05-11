package com.savio.diag.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "dadiag", type = "da3log")
public class DA3Log {
	@Id
	private String DALogEntryID;
	private String EventID;
	private String Priority;
	private String DASeverity;
	private String Title;
	private String EventDateTime;
	private String LocalComputerName;
	private String AppDomainName;
	private String ProcessID;
	private String ProcessName;
	private String ThreadName;
	private String Win32ThreadId;
	private String Message;
	private String ModuleName;
	private String TransactionID;
	private String EngagementFileID;
	private String DAErrorCodeID;
	private String UserID;
	private String BusinessOperation;
	private String BusinessOperationStatus;
	private String LocalVersion;
	private String RemoteVersion;
	private String LogicalEMSServerID;
	
	public String getDALogEntryID() {
		return DALogEntryID;
	}
	public void setDALogEntryID(String dALogEntryID) {
		DALogEntryID = dALogEntryID;
	}
	public String getEventID() {
		return EventID;
	}
	public void setEventID(String eventID) {
		EventID = eventID;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	public String getDASeverity() {
		return DASeverity;
	}
	public void setDASeverity(String dASeverity) {
		DASeverity = dASeverity;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getEventDateTime() {
		return EventDateTime;
	}
	public void setEventDateTime(String eventDateTime) {
		EventDateTime = eventDateTime;
	}
	public String getLocalComputerName() {
		return LocalComputerName;
	}
	public void setLocalComputerName(String localComputerName) {
		LocalComputerName = localComputerName;
	}
	public String getAppDomainName() {
		return AppDomainName;
	}
	public void setAppDomainName(String appDomainName) {
		AppDomainName = appDomainName;
	}
	public String getProcessID() {
		return ProcessID;
	}
	public void setProcessID(String processID) {
		ProcessID = processID;
	}
	public String getProcessName() {
		return ProcessName;
	}
	public void setProcessName(String processName) {
		ProcessName = processName;
	}
	public String getThreadName() {
		return ThreadName;
	}
	public void setThreadName(String threadName) {
		ThreadName = threadName;
	}
	public String getWin32ThreadId() {
		return Win32ThreadId;
	}
	public void setWin32ThreadId(String win32ThreadId) {
		Win32ThreadId = win32ThreadId;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getModuleName() {
		return ModuleName;
	}
	public void setModuleName(String moduleName) {
		ModuleName = moduleName;
	}
	public String getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}
	public String getEngagementFileID() {
		return EngagementFileID;
	}
	public void setEngagementFileID(String engagementFileID) {
		EngagementFileID = engagementFileID;
	}
	public String getDAErrorCodeID() {
		return DAErrorCodeID;
	}
	public void setDAErrorCodeID(String dAErrorCodeID) {
		DAErrorCodeID = dAErrorCodeID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getBusinessOperation() {
		return BusinessOperation;
	}
	public void setBusinessOperation(String businessOperation) {
		BusinessOperation = businessOperation;
	}
	public String getBusinessOperationStatus() {
		return BusinessOperationStatus;
	}
	public void setBusinessOperationStatus(String businessOperationStatus) {
		BusinessOperationStatus = businessOperationStatus;
	}
	public String getLocalVersion() {
		return LocalVersion;
	}
	public void setLocalVersion(String localVersion) {
		LocalVersion = localVersion;
	}
	public String getRemoteVersion() {
		return RemoteVersion;
	}
	public void setRemoteVersion(String remoteVersion) {
		RemoteVersion = remoteVersion;
	}
	public String getLogicalEMSServerID() {
		return LogicalEMSServerID;
	}
	public void setLogicalEMSServerID(String logicalEMSServerID) {
		LogicalEMSServerID = logicalEMSServerID;
	}
	
	@Override
	public String toString() {
		return  DALogEntryID + "\t" + EventID + "\t" + Priority + "\t" + DASeverity + "\t" + 
				Title + "\t" + EventDateTime + "\t" + LocalComputerName + "\t" + 
				AppDomainName + "\t" + ProcessID + "\t" + ProcessName + "\t" + ThreadName + "\t" + 
				Win32ThreadId + "\t" + Message + "\t" + ModuleName + "\t" + TransactionID + "\t" + 
				EngagementFileID + "\t" + DAErrorCodeID + "\t" + UserID + "\t" + 
				BusinessOperation + "\t" + BusinessOperationStatus + "\t" + LocalVersion + "\t" + 
				RemoteVersion + "\t" +LogicalEMSServerID;
	}
}
