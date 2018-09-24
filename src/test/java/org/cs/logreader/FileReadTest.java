package org.cs.logreader;

import static org.junit.Assert.*;

import org.cs.logmodel.ReturnType;
import org.cs.logreader.service.TailFileReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles= {"test"})
public class FileReadTest {

	@Autowired
	private TailFileReader reader;
	
	@Test
	public void test() {
		ReturnType type=null;
		try {
		 type = 	reader.fileRead("classpath:read", 0L);
		//   type = reader.fileRead("read", 0L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println(type.getFileString());
		assertNotNull(type);
	}

}
