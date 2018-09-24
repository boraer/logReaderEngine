package org.cs.logreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = { "org.cs" })
@EnableScheduling
public class LogReaderEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogReaderEngineApplication.class, args);
	}
}
