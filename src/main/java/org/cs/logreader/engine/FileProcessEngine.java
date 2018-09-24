package org.cs.logreader.engine;

import java.util.List;
import java.util.concurrent.Callable;


import org.cs.logmodel.EventLog;
import org.cs.logmodel.ReturnType;
import org.cs.logreader.dao.entity.EventDataAlertLog;
import org.cs.logreader.dao.repository.LocalRepo;
import org.cs.logreader.service.EventDataAlertService;
import org.cs.logreader.service.TailFileReader;
import org.cs.utility.JsonUtility;
import org.cs.utility.Utility;
import org.cs.utility.impl.JsonUtilityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName="prototype")
public class FileProcessEngine implements Runnable {

	@Autowired
	private EventDataAlertService alertDaoService;

	@Autowired
	private TailFileReader fileReader;

	/*
	@Autowired
	private JsonUtility jsonUtility;
*/
	@Autowired
	private LocalRepo localRepo;

	@Value("${process.filepath}")
	private String filePath;

	@Value("${process.timerange}")
	private Long timeRange;

	private volatile Long lastKnownFilePosition = 0L;

	@Override
	public void run() {
		processFiles();
	}

	public void processFiles() {

		ReturnType type = new ReturnType();

		try {

			type = fileReader.fileRead(filePath, lastKnownFilePosition);
			
			if (type.getResult() == 0) {
				lastKnownFilePosition = type.getLastPosition();
				 JsonUtility jsonUtility = new JsonUtilityImpl();
				String[] fileJsonObjList = org.cs.utility.Utility.string2StringArr(type.getFileString(), "}");
				// List<EventLog> list = Utility.split(type.getFileString());
			
				 for (int i = 0; i < fileJsonObjList.length-1; i++) {
					EventLog inLog = jsonUtility.parseJsonStr(fileJsonObjList[i]+"}");
					// inmemory datastore
					Boolean exist = localRepo.consistInLookup(inLog.getId());
					if (exist) {
						EventLog repoLog = localRepo.getEventLog(inLog.getId());
						Long val = Math.abs(repoLog.getTimestamp() - inLog.getTimestamp());
						if ( timeRange< val) {
							// add to hsqldb
							EventDataAlertLog alertLog = new EventDataAlertLog();
							alertLog.setAlert(true);
							alertLog.setDuration(val);
							alertLog.setHost(inLog.getHost());
							alertLog.setId(inLog.getId());
							alertLog.setType(inLog.getType());
							try {
							alertDaoService.addEventDataAlert(alertLog);
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
							}
						}
					} else {
						
						localRepo.add(inLog);
					}
				}
				
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
   
	}

	public FileProcessEngine() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
