# Api Test

This application uses the Maven wrapper MVNW to run it. If you do 
not have this wrapper then in a terminal window do the following   
  
  - cd to this applications root folder __/answer__
  - run the command 
  ``` 
mvn -N io.takari:maven:wrapper
```


## To Run the application
From the command line 
  ``` 
mvnw spring-boot:run
  ``` 
or generate a Jar file with 
  ``` 
mvnw clean package
  ``` 
then run
  ``` 
java -jar target/answer-0.1.0.jar
  ``` 


