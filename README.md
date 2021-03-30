# PaymentAutomationFramework
Selenium Automation Framework Manual Guide


Prerequisites:-
-	Required Set Path for Java and Maven in Environment Variable
Java_Home path and Maven_Home

How To run test: 

-	Unzip folder and put in directory 
-	You can directly run from command Prompt cmd

Step 1:- Open Cmd ->  Go into directory of project
Step 2:- Give command mvn clean
Step 3:-  Give below command for run testcases any browser

// this for direct run from Console with giving

-	mvn test -Dbrowser=firefox -PCredit_Card_Payment
-	mvn test -Dbrowser=firefox -PCucumber_Test
-	mvn test -Dbrowser=firefox -PACH_Payment
-	mvn test -Dbrowser=chrome -PACH_Payment
-	mvn test -Dbrowser=chrome -PCredit_Card_Payment
-	mvn test -Dbrowser=chrome -PCucumber_Test


HeadLess Browser Script

-	mvn test -Dbrowser=headless_chrome -PCredit_Card_Payment
-	mvn test -Dbrowser= headless_chrome -PCucumber_Test
-	mvn test -Dbrowser=headless_firefox -PCredit_Card_Payment
-	mvn test -Dbrowser= headless_firefox -PCucumber_Test
-	mvn test -Dbrowser= headless_firefox -PACH_Payment
-	mvn test -Dbrowser= headless_chrome -PACH_Payment


Step 4:-  After successfully test run you can go to directory and go to reports folder for check reports.html  looks like this. Dir: ..\\reports
 

 

