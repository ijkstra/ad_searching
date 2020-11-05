ads-searching-system

Description
The Ads searching system is an ads platform to rank and display ads for users.

Motivation
By calculating the relativity between the user's query and the ads provided by merchants, this ads searching system displays the most relevant ads that users are most interested in so that user are more likely to click the ads. In the meantime, merchants can easily target the most potential customers and put the right ads with the lowest cost.

How does it work
Merchants provide a list of ads which contain keywords, bid price, and total budget. Our system store all the information and build the forwarded and inverted indexes.
When user types the query on the search box, the system parses the query and calculates the relevant score between the query and the ads. Then the system processes a workflow to select, filter, price, and allocate the relevant ads.
Finally the ads is sent and displayed to the user interface.
How to build it
Redis, MySQL, Kafka, Tomcat, Spring Boot, Spring Cloud, JUnit, IntelliJ

How to run ads searching system
Run the project locally
Step1. Install MySQL and Kafka

Step2. Get source code from Github and run ads-searching-system server

Clone the project from github
Go to project folder, open the project in IntelliJ by the POM file
Run $ mvn clean install to compile and install the project
Right click the Main java file under java folder, click on Run Main.main() button

Type the url(https://localhost:9080/) to open the project on your browser


Technology Stack:

Web Server: Tomcat
Query Parsing: Inverted indexing implemented in JVM
Cache: Redis
Database: MySQL
Cloud Platform: Spring Cloud
Unit Testing: JUnit
JUnit is a unit testing framework to write repeatable tests. These unit tests are typically written and run by software developers to ensure that code meets its design and behaves as intended.
Build Tool: Maven
Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
