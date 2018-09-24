package org.cs.logreader.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.cs.logmodel.ReturnType;
import org.cs.logreader.dao.entity.EventDataAlertLog;
import org.cs.logreader.dao.repository.EventDataAlertRepository;
import org.cs.logreader.service.EventDataAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventDataAlertServiceImpl implements EventDataAlertService {

	@Autowired
	private EventDataAlertRepository eventDataAlertRepo;
	
	@Override
	public ReturnType addEventDataAlert(EventDataAlertLog log) {
		eventDataAlertRepo.save(log);
		ReturnType type = new ReturnType();
		type.setResult(0);
		return type;
	}
/*
	@Override
	public void addEventDataAlert(EventData data) {
       EventDataAlertLog log = new EventDataAlertLog();
       log.setAlert(true);
       log.setDuration(data.getEndDate()-data.getStartDate());
       log.setHost(data.getHost());
       log.setId(data.getId());
       log.setType(data.getType());
       eventDataAlertRepo.save(log);
	}
*/
	@Override
	public List<EventDataAlertLog> getAllEventDataLogs() {
		// TODO Auto-generated method stub
		return (List<EventDataAlertLog>) eventDataAlertRepo.findAll();
	}

	@Override
	public EventDataAlertLog updateEventDataAlert(EventDataAlertLog log) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType deleteEventDataAlert(EventDataAlertLog log) {
		// TODO Auto-generated method stub
		 eventDataAlertRepo.delete(log);
		 ReturnType type = new ReturnType();
			type.setResult(0);
			return type;
	}

}
