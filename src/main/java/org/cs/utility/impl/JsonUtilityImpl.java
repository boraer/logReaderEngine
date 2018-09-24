package org.cs.utility.impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;


import org.cs.logmodel.EventLog;
import org.cs.utility.JsonUtility;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtilityImpl implements JsonUtility {

	@Override
	public EventLog parseJsonStr(String input) throws JsonParseException, JsonMappingException, IOException {
	  System.out.println(input);
		ObjectMapper mapper = new ObjectMapper();
	  EventLog log = mapper.readValue(input, EventLog.class);
		return log;
	}

	public JsonUtilityImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generateEventLog(EventLog log) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writeValueAsString(log);
		return s;
	}

	@Override
	public byte[] generateEventLogByte(EventLog log) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		byte[] arr = mapper.writeValueAsBytes(log);
		return arr;
	}

	@Override
	public byte[] generateEventLogByteList(List<EventLog> listLog) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		return null;
	}

	
}
