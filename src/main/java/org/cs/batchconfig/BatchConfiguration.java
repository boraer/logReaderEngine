package org.cs.batchconfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.cs.loggenerator.engine.LogGeneratorEngine;
import org.cs.logreader.engine.FileProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class BatchConfiguration implements SchedulingConfigurer {

	@Autowired
	private FileProcessEngine readerProcessor;
	
	@Autowired
	private LogGeneratorEngine logGenerator;
	
	@Value("${cron.reader.expression}")
	private String readerExpression;
	
	@Value("${cron.writer.expression}")
	private String writerExpression;
	
	
	@Bean
	public ExecutorService createExecutor()
	{
	    ExecutorService executor = Executors.newFixedThreadPool(5);
		return executor;
	}
	
	@Bean
	@Qualifier("TaskSchedularExecutor")
	public TaskScheduler threadPoolTaskSchedulerForDaily() {

		ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
		executor.setPoolSize(10);
		executor.setAwaitTerminationSeconds(60);
		executor.initialize();

		return executor;
	}
	
	@Bean
    CronTask taskReaderCron() {

		CronTask task = new CronTask(readerProcessor, readerExpression);
		return task;
	}
	
	@Bean
    CronTask taskWriterCron() {

		CronTask task = new CronTask(logGenerator, writerExpression);
		return task;
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		taskRegistrar.setTaskScheduler(threadPoolTaskSchedulerForDaily());
		taskRegistrar.scheduleCronTask(taskReaderCron());
		taskRegistrar.scheduleCronTask(taskWriterCron());
	}
	
	
}
