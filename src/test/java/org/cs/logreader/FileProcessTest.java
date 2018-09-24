package org.cs.logreader;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import org.cs.logreader.engine.FileProcessEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles= {"test"})
public class FileProcessTest {

	
	@Autowired
	private FileProcessEngine processor;
	
	
	@Test
	public void test() {
		
	processor.processFiles();
	}

}
