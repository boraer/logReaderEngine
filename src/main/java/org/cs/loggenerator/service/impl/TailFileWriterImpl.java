package org.cs.loggenerator.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.List;

import org.cs.loggenerator.service.TailFileWriter;
import org.cs.logmodel.EventLog;
import org.cs.logmodel.ReturnType;
import org.cs.utility.JsonUtility;
import org.cs.utility.impl.JsonUtilityImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class TailFileWriterImpl implements TailFileWriter {

	@Override
	public ReturnType writeLogFile(String filePath, String input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType writeLogFile(String filePath, byte[] input) throws FileNotFoundException, IOException {
		
		File file = ResourceUtils.getFile(filePath);
		
		ReturnType type = new ReturnType();

		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		FileChannel writeCh = randomAccessFile.getChannel();
		ByteBuffer buffer = ByteBuffer.wrap(input);
        writeCh.write(buffer);
        writeCh.close();
        randomAccessFile.close();
        type.setResult(0);
		return type;
	}

	@Override
	public ReturnType writeLogFile(String filePath, List<EventLog> list) throws FileNotFoundException, IOException {
File file = ResourceUtils.getFile(filePath);
		
		ReturnType type = new ReturnType();

		//RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		FileChannel writeCh =  new FileOutputStream(file, true).getChannel();
	

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			EventLog eventLog = (EventLog) iterator.next();
			//System.out.println(eventLog.toString());
			JsonUtility json = new JsonUtilityImpl();
			byte[] input = json.generateEventLogByte(eventLog);
			ByteBuffer buffer = ByteBuffer.wrap(input);
	        writeCh.write(buffer);
	        
		}

        writeCh.close();
      //  randomAccessFile.close();
        type.setResult(0);
		return type;
	}

}
