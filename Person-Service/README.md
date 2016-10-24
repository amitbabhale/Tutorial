# Person Service
##Description: This helps to store person information and create order for it

##Tools:
Gradle as a build tool
Spring Boot for bootstraping
Spring , java 8 for development
Spring-data-jpa for persistance


#How to build the project:
Download/clone project from github.
Open Spring Tool Suit editor and import project as gradle project.
Select project directory in STS import wizard and click on button build.
This will create a project structure in STS.

#how to run project from command line:
You need to set classpath for gradle and java.
On you command prompt change your current directory to person-service.
Execute following command:
1. gradlew eclipse clean build -> It will download all dependant jars and execute all junits.
2. gradlew jacoco -> it will calculate code coverage.

# To check code coverage and Junit report 
navigate to person-service directory and check for build folder
Inside build folder search for reports. Reports has 2 folders test and jacoco.
test directory contains junit test result
jacoco contain code coverage details.

