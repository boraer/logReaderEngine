package org.cs.logreader.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Event_Data_Alert_Log")
public class EventDataAlertLog {

	@Id
	@Column(name="Id")
	private String id;
	
	@Column(name="Type",nullable=true)
	private String type;
	
	@Column(name="Host",nullable=true)
	private String host;
	
	@Column(name="Duration")
	private Long duration;
	
	@Column(name="Alert")
	private Boolean alert;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Boolean getAlert() {
		return alert;
	}

	public void setAlert(Boolean alert) {
		this.alert = alert;
	}

	public EventDataAlertLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventDataAlertLog(String id, String type, String host, Long duration, Boolean alert) {
		super();
		this.id = id;
		this.type = type;
		this.host = host;
		this.duration = duration;
		this.alert = alert;
	}

	@Override
	public String toString() {
		return "EventDataAlertLog [id=" + id + ", type=" + type + ", host=" + host + ", duration=" + duration
				+ ", alert=" + alert + "]";
	}
	
	
}
