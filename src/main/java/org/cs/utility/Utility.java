package org.cs.utility;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.cs.logmodel.EventLog;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility {

	public static String uuidGenerator() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static String[] string2StringArr(String input, String regexPattern) {

		return input.split(regexPattern);
	}

	public static List<EventLog> split(String str) {
		return Stream.of(str.split("}")).map(elem -> {
			ObjectMapper mapper = new ObjectMapper();
			EventLog log = null;
			try {
				log = mapper.readValue(elem + "}", EventLog.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return log;
		}).collect(Collectors.toList());
	}

	public static Integer generateNumber() {
		Random rand = new Random();
		int value = rand.nextInt(50);
		return value;
	}
}