
NOTE ON TEST COVERAGE

There are some unit/integration tests.
All major positive cases covered through mostly cucumber tests, integration and unit tests.
Negative major cases like Fx not existing, or attempt to save the same rate twice covered.

But edge/negative cases in numeric inputs and validations not covered, spending too much time on the task.
Thus, not all classes might have an attached unit test.

TECHNOLOGY STACK
Easily can be listed from pom.xml but here in case :

Spring Boots/Data, Jersey, Tomcat, H2, JPA
Maven
Cucumber
JUnit

WHAT REST PATH IMPLEMENTED  :
HOST_URL/calculate : POST method taking CalculateParams object in JSON format

HOW TO RUN THE APP

Either
1) In the project root, run 'mvn clean spring-boot:run'
2) or run 'mvn clean package' and deploy the .war file

HOW TO RUN TESTS :
 Run 'mvn clean test' in the project root.


NOTE ON TEST COVERAGE


