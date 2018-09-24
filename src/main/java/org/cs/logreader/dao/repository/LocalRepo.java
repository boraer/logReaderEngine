package org.cs.logreader.dao.repository;

import org.cs.logmodel.EventLog;
import org.cs.logreader.dao.entity.EventDataAlertLog;


public interface LocalRepo {

	void add(EventLog alertDataLog);
	
	EventLog getEventLog(String id);
	
	Boolean consistInLookup(String id);
	
}
