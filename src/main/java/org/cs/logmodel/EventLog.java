package org.cs.logmodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonPropertyOrder(value={"id","state","type","host","timestamp"})
@JsonInclude(Include.NON_NULL)
public class EventLog {
	
	private String id;
	private String state;
	private Long timestamp;
	private String type;
	private String host;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public EventLog(String id, String state, Long timestamp, String type, String host) {
		super();
		this.id = id;
		this.state = state;
		this.timestamp = timestamp;
		this.type = type;
		this.host = host;
	}
	
	
	public EventLog(String id, String state, Long timestamp) {
		super();
		this.id = id;
		this.state = state;
		this.timestamp = timestamp;
	}
	public EventLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EventLog [id=" + id + ", state=" + state + ", timestamp=" + timestamp + ", type=" + type + ", host="
				+ host + "]";
	}
	
	

}
