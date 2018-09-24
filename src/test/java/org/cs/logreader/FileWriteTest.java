package org.cs.logreader;

import static org.junit.Assert.*;

import org.cs.loggenerator.engine.LogGeneratorEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles= {"test"})
public class FileWriteTest {

	@Autowired
	private LogGeneratorEngine engine;
	
	@Test
	public void test() {
		try {
			engine.process();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
