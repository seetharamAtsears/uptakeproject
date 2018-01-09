# uptakeproject
Problem Defenition:

Please make a test for the Uptake home page, at least one other page on the site, and write a test using the page 
object model pattern which verifies that navigation between those pages works correctly. You can decide the details, 
such as which pages to use, and how to verify that they are correct. 

This project is developed in 
JAVA  and JDK version 1.7 
Maven
Selenium: Version 3.8.1
TestNG  version 6.8
Browser Firfox 45.0
For more details check pom.xml

Framework is implemented in page object model
Used TestNG to develop the testcases

Here i am listing one complere UseCase which i have tested and implemented

Getting Demo for WIND industry
1. Launk uptake.com and verify
2. Navigate to WIND INdusties and verify
3. Enter the customer detail in Demo Form


Test Report:

[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building uptake 2.0
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ uptake ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\sdasara\eclipse-workspace\uptake\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ uptake ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ uptake ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\sdasara\eclipse-workspace\uptake\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ uptake ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ uptake ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\sdasara\eclipse-workspace\uptake\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ uptake ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ uptake ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestSuite
2018-01-09 00:33:45 INFO  utils.Driver:81 - Setting default driver timeout to 20
2018-01-09 00:33:45 INFO  utils.Driver:81 - Client browser name:firefox
2018-01-09 00:33:45 INFO  utils.Driver:81 - Client browser Version:xpff45
2018-01-09 00:33:45 INFO  utils.Driver:81 - Configuring settings for Firefox
Jan 09, 2018 12:33:56 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: OSS
2018-01-09 00:33:56 INFO  uptake.UpTakeTest:81 - ==================================================================
2018-01-09 00:33:56 INFO  uptake.UpTakeTest:81 - =====>     Step1: Launching uptake http://www.uptake.com/
2018-01-09 00:33:56 INFO  uptake.UpTakeTest:81 - ==================================================================
2018-01-09 00:34:02 INFO  lib.UpTake:81 - Industrial Analytics for Global Industry | Uptake
2018-01-09 00:34:02 INFO  lib.UpTake:81 - Title From Page: Industrial Analytics for Global Industry | Uptake
2018-01-09 00:34:02 INFO  uptake.UpTakeTest:81 - ==================================================================
2018-01-09 00:34:02 INFO  uptake.UpTakeTest:81 - =====>     Step2: Navigting to Wind Industry
2018-01-09 00:34:02 INFO  uptake.UpTakeTest:81 - ==================================================================
2018-01-09 00:34:07 INFO  lib.UpTake:81 - WIND
2018-01-09 00:34:07 INFO  lib.UpTake:81 - https://www.uptake.com/industries/wind
2018-01-09 00:34:07 INFO  lib.UpTake:81 - Successfully Navigated to WIND Industies
2018-01-09 00:34:07 INFO  uptake.UpTakeTest:81 - ==================================================================
2018-01-09 00:34:07 INFO  uptake.UpTakeTest:81 - =====>     Step3: Click on Demo button of Wind Industry
2018-01-09 00:34:07 INFO  uptake.UpTakeTest:81 - ==================================================================
2018-01-09 00:34:09 INFO  industries.Wind:81 - REQUEST A PRODUCT DEMO.
2018-01-09 00:34:09 INFO  industries.Wind:81 - Successfully Navigated to Demo customer collection Details
2018-01-09 00:34:09 INFO  uptake.UpTakeTest:81 - ==================================================================
2018-01-09 00:34:09 INFO  uptake.UpTakeTest:81 - =====>     Step4: Enter the Customer details for Demo of Wind Industry
2018-01-09 00:34:09 INFO  uptake.UpTakeTest:81 - ==================================================================
2018-01-09 00:34:11 INFO  utils.Common:81 - -Please select-
2018-01-09 00:34:11 INFO  utils.Common:81 - Aviation
2018-01-09 00:34:11 INFO  utils.Common:81 - Construction
2018-01-09 00:34:11 INFO  utils.Common:81 - Cybersecurity
2018-01-09 00:34:12 INFO  utils.Common:81 - Energy
2018-01-09 00:34:12 INFO  utils.Common:81 - Equipment Dealers
2018-01-09 00:34:12 INFO  utils.Common:81 - Fleet
2018-01-09 00:34:12 INFO  utils.Common:81 - Manufacturing
2018-01-09 00:34:12 INFO  utils.Common:81 - Mining
2018-01-09 00:34:12 INFO  utils.Common:81 - Rail
2018-01-09 00:34:12 INFO  utils.Common:81 - Smart Cities
2018-01-09 00:34:12 INFO  utils.Common:81 - Wind
2018-01-09 00:34:13 INFO  utils.Common:81 - -Please select-
2018-01-09 00:34:13 INFO  utils.Common:81 - Under 500
2018-01-09 00:34:13 INFO  utils.Common:81 - -Please select-
2018-01-09 00:34:13 INFO  utils.Common:81 - Leadership
2018-01-09 00:34:13 INFO  utils.Common:81 - Information Technology
2018-01-09 00:34:13 INFO  utils.Common:81 - Engineering
2018-01-09 00:34:13 INFO  utils.Common:81 - Product Development
2018-01-09 00:34:13 INFO  utils.Common:81 - Sales & Marketing
2018-01-09 00:34:13 INFO  utils.Common:81 - Production / Manufacturing
2018-01-09 00:34:13 INFO  utils.Common:81 - Services
2018-01-09 00:34:13 INFO  utils.Common:81 - Other
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 31.389 s - in TestSuite
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 37.880 s
[INFO] Finished at: 2018-01-09T00:34:16-06:00
[INFO] Final Memory: 10M/126M
[INFO] ------------------------------------------------------------------------



