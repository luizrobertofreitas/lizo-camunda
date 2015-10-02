package org.lizo.camunda.service.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public final class LizoProcess {

	private String processInstanceId;
	private String name;
	private String description;
	private Integer priority;
	private String assignee;
	private Date creationTime;
	private String message;
	
	public LizoProcess() {}
	
	public LizoProcess(final String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	
	public void setProcessInstanceId(final String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	
	public String getProcessInstanceId() {
		return this.processInstanceId;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(final Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(final String assignee) {
		this.assignee = assignee;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(final Integer priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LizoProcess [processInstanceId=" + processInstanceId + ", name=" + name + ", description=" + description
				+ ", priority=" + priority + ", assignee=" + assignee + ", creationTime=" + creationTime + ", message="
				+ message + "]";
	}
}
