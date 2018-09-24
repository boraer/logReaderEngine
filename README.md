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

## Example Data Set

{"id":"836aa0b8-7268-43dc-919f-351dd80ba12d","state":"FINISHED","timestamp":1537792966000}{"id":"27ec672f-5be9-424b-a4d9-d9d71d5ee6e3","state":"FINISHED","timestamp":1537792966000}{"id":"28cc93b9-db7e-4910-bb5b-a3f0e9bb71d8","state":"FINISHED","timestamp":1537792966000}{"id":"2e46c016-9a19-4e34-8143-3f0173575c99","state":"FINISHED","timestamp":1537792966000}{"id":"372ebd14-906a-418a-93ff-72fef68b6c0e","state":"FINISHED","timestamp":1537792966000}{"id":"cf2e851a-c325-4ffd-8b72-79b912335d6d","state":"FINISHED","type":"APPLICATION_LOG","host":"123456","timestamp":1537792966000}{"id":"022b899a-559a-4656-a815-d26b5ab91b77","state":"FINISHED","type":"APPLICATION_LOG","host":"123456","timestamp":1537792966000}{"id":"a60b7151-4b4a-4fe5-8472-b7adf1eac0c5","state":"FINISHED","type":"APPLICATION_LOG","host":"123456","timestamp":1537792966000}{"id":"5096abd4-29c1-442a-8870-d2da7d4d9910","state":"STARTED","timestamp":1537792966000}{"id":"a2322ac7-644e-4c43-a07c-d68d05344188","state":"STARTED","timestamp":1537792966000}{"id":"3859b6ff-b328-4893-9257-46f92c061ad7","state":"FINISHED","timestamp":1537792966000}{"id":"95f0b7cd-287f-4f19-a5fe-b3f76d0ff6d3","state":"STARTED","timestamp":1537792966000}{"id":"a1f3a77a-7800-43a4-b65b-31674112584f","state":"FINISHED","timestamp":1537792966000}{"id":"89601df9-5342-427a-bf8c-a41394145f5b","state":"FINISHED","timestamp":1537792966000}{"id":"6b41943d-cfca-490b-9ac7-a8d106df5234","state":"STARTED","timestamp":1537792966000}{"id":"bef5d152-7d00-4f07-90c2-03ddfd762983","state":"STARTED","timestamp":1537792966000}{"id":"3bdf214a-d5c5-4e37-8973-78cdacbae411","state":"FINISHED","timestamp":1537792966000}{"id":"2600d287-9ff4-48ef-9f4e-9f0c13cb1624","state":"STARTED","timestamp":1537792966000}


In the application.properties file it is needed to set file path correctly. It may be changed cron.reader.expression , cron.write.expression and time range parameter for calculation.

# Test Case

There are 4 test cases that controlling

* Reading data from file
* Writing data to file
* Read and Process data 
* Generate Log data and write to file

## License

Apache 2.0 © [boraer]()
