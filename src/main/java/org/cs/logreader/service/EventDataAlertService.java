package org.cs.logreader.service;

import java.util.List;

import org.cs.logmodel.ReturnType;
import org.cs.logreader.dao.entity.EventDataAlertLog;

public interface EventDataAlertService {

	ReturnType addEventDataAlert(EventDataAlertLog log);
	
	List<EventDataAlertLog> getAllEventDataLogs();
	
	EventDataAlertLog updateEventDataAlert(EventDataAlertLog log);
	
	ReturnType deleteEventDataAlert(EventDataAlertLog log);
}
