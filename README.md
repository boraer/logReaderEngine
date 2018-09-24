# Log Reader Engine Project

Reading logs continuously from a file and make calculations from the given logs. 

# Motivation

This project has been developed for CS Coding Assignment.

# Tech / Frameworks Used

This project was developed by using given technologies;

* Java 8
* Java NIO
* Spring Boot 2
* Cron
* JPA
* Hibernate
* Gradle
* AOP
* JSON

# Business Logic

The application works as multithreaded and sets CronTask for executing. In the BatchConfiguration.java file, There are 2 crontask which are assigned to application. One of these is used for generating example log data and write to file. The other one is used for reading and making the calculations. 

# Code & Run

After downloading the project, it may be run as SpringBootApplication. Before runnig the application it need to be set environment variable SPRING_PROFILES_ACTIVE as test. With assigning the profile application would use the test properties.  

In the code, logging mechanism is done with Spring AOP. The reader engine is run every minute once and read from the last position, The log generator engine is run very 23 seconds and generate dummy data. The data is formed as Json object. 

In the application.properties file it is needed to set file path correctly. It may be changed cron.reader.expression , cron.write.expression and time range parameter for calculation.

# Test Case

There are 4 test cases that controlling

* Reading data from file
* Writing data to file
* Read and Process data 
* Generate Log data and write to file

## License

Apache 2.0 © [boraer]()
