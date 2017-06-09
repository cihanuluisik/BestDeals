

TECHNOLOGY STACK
Easily can be listed from pom.xml but here in case :

Spring Boots/Data, Jersey, Tomcat, H2, JPA
Maven
Cucumber
JUnit
AssertJ, Mockito

RESTFul  SERVICES EXPOSED :
/calculate              : POST method taking deal object in JSON format
/calculate/all/id/{id}  : GET method taking client id as path param

HOW TO RUN THE APP

Either
1) In the project root, run 'mvn clean spring-boot:run'
2) or run 'mvn clean package' and deploy the .war file

HOW TO RUN TESTS :
 Run 'mvn clean test' in the project root.



