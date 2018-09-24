package org.cs.loggenerator.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


import org.cs.logmodel.EventLog;
import org.cs.logmodel.ReturnType;

public interface TailFileWriter {

	ReturnType writeLogFile(String filePath,String input)  throws FileNotFoundException;
	
	ReturnType writeLogFile(String filePath,byte[] input)  throws FileNotFoundException,IOException;
	
	ReturnType writeLogFile(String filePath,List<EventLog> list)  throws FileNotFoundException,IOException;
	
}
