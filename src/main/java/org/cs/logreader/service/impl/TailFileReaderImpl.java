package org.cs.logreader.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.cs.logmodel.ReturnType;
import org.cs.logreader.service.TailFileReader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class TailFileReaderImpl implements TailFileReader {

	public TailFileReaderImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ReturnType fileRead(String filePath, Long lastKnownPosition) throws IOException, Exception {

		File file = ResourceUtils.getFile(filePath);
		Long fileLength = file.length();
		ReturnType type = new ReturnType();
		
		if (lastKnownPosition < fileLength) {
			RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
			FileChannel ch = randomAccessFile.getChannel();
			StringBuilder stb = new StringBuilder();
			
			MappedByteBuffer mappedByteBuffer = ch.map(FileChannel.MapMode.READ_ONLY,
					lastKnownPosition, fileLength-lastKnownPosition);
			byte[] data = new byte[2048]; // Needs to be Byte Array only as MappedBuffer play only with Byte[]
			while (mappedByteBuffer.hasRemaining()) {
				int remaining = data.length;

				if (mappedByteBuffer.remaining() < remaining)
					remaining = mappedByteBuffer.remaining();
				data = new byte[2048];
				mappedByteBuffer.get(data, 0, remaining);
				stb.append(new String(data));

			}
			
			
			type.setFileString(stb.toString());
			type.setLastPosition(ch.size());
			type.setResult(0);
			mappedByteBuffer.clear();
			ch.close();
			randomAccessFile.close();
		}
		else
		{
			type.setResult(1);
		}
		return type;
	}

}
