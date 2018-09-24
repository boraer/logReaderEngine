package org.cs.logreader.service;

import java.io.IOException;
import java.util.concurrent.Callable;

import org.cs.logmodel.ReturnType;

public interface TailFileReader{

	ReturnType fileRead(String filePath,Long lastKnownPosition) throws IOException,Exception;
	

	
}
