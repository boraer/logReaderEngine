package org.cs.loggenerator.engine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.cs.loggenerator.service.TailFileWriter;
import org.cs.logmodel.EventLog;
import org.cs.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName="prototype")
public class LogGeneratorEngine implements Runnable {

	@Value("${process.filepath}")
	private String filePath;
	
	@Autowired
	private TailFileWriter fileWriter;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
        try {
			process();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void process() throws InterruptedException
	{
		Date date = new Date();
		Integer size = Utility.generateNumber();
		List<EventLog> list = new CopyOnWriteArrayList<>();

		for(int i=0;i<size;i++)
		{
			EventLog log = new EventLog();
			log.setId(Utility.uuidGenerator());
			log.setTimestamp(date.getTime());
			Integer randNum = Utility.generateNumber();
			if(randNum%3==0)
			  log.setState("STARTED");		
			else
			  log.setState("FINISHED");
			
			if(randNum%5==0)
			{
				log.setHost("123456");
				log.setType("APPLICATION_LOG");
			}
			list.add(log);
		}
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			EventLog eventLog = (EventLog) iterator.next();
			EventLog copy = new EventLog();
			if(eventLog.getState().equals("STARTED"))
			{
				
				copy.setId(eventLog.getId());
				copy.setHost(eventLog.getHost());
				copy.setState("FINISHED");
				copy.setType(eventLog.getType());
				copy.setTimestamp(eventLog.getTimestamp()+Utility.generateNumber());
			}
			else
			{
				
				copy.setId(eventLog.getId());
				copy.setHost(eventLog.getHost());
				copy.setState("STARTED");
				copy.setType(eventLog.getType());
				copy.setTimestamp(eventLog.getTimestamp()-Utility.generateNumber());
			}
			list.add(copy);
		}
		
		try {
			fileWriter.writeLogFile(filePath, list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
