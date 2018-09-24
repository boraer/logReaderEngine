package org.cs.logreader.dao.repository.impl;

import java.util.Hashtable;

import org.cs.logmodel.EventLog;
import org.cs.logreader.dao.entity.EventDataAlertLog;
import org.cs.logreader.dao.repository.LocalRepo;
import org.springframework.stereotype.Repository;

@Repository
public class LocalRepoImpl implements LocalRepo {

	private static Hashtable<String, EventLog> repo = new Hashtable<>();

	@Override
	public void add(EventLog alertDataLog) {

		repo.put(alertDataLog.getId(), alertDataLog);
	}

	@Override
	public EventLog getEventLog(String id) {

		return repo.get(id);
	}

	@Override
	public Boolean consistInLookup(String id) {
		
		return repo.containsKey(id);
	}

}
