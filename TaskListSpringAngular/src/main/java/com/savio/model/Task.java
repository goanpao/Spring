package com.savio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task_list")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="task_id")
	private int id;

	@Column(name="task_name")
	private String taskName;

	@Column(name="task_description")
	private String taskDescription;

	@Column(name="task_priority")
	private String taskPriority;

	@Column(name="task_status")
	private String taskStatus;

	@Column(name="task_archived")
	private int taskArchived = 0;


	public Task() {
	}

	public int getTaskId() {
		return this.id;
	}

	public void setTaskId(int taskId) {
		this.id = taskId;
	}

	public int getTaskArchived() {
		return taskArchived;
	}

	public void setTaskArchived(int taskArchived) {
		this.taskArchived = taskArchived;
	}

	public String getTaskDescription() {
		return this.taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskPriority() {
		return this.taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return String.format("Task  [id=%s, taskName='%s', taskDescription='%s', taskPriority='%s', taskStatus='%s']", 
				id, taskName, taskDescription, taskPriority, taskStatus  );
	}
}
