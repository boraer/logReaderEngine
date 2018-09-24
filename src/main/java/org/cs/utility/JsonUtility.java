package org.cs.utility;

import java.io.IOException;
import java.util.List;


import org.cs.logmodel.EventLog;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


public interface JsonUtility {

	EventLog parseJsonStr(String input) throws JsonParseException, JsonMappingException, IOException;
	
	String generateEventLog(EventLog log) throws JsonProcessingException;
	
	byte[] generateEventLogByte(EventLog log) throws JsonProcessingException;
	
	byte[] generateEventLogByteList(List<EventLog> listLog)throws JsonProcessingException;
	
}
