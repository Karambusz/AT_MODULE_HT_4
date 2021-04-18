Home Task 4:
Create test project for any web online store (don’t use amazon site).
Setup Selenium Grid, create testng.xml to run tests in different browsers (3-4 stable
tests)
Mandatory Conditions:
1) Programming code should correspond to Java Code Convention.
2) Use sensible names for methods and variables.


------------------------------------------------------------------
Selenium Grid setup:
1. Download Selenium Server 4 from https://www.selenium.dev/downloads/
2. Open cmd and run the following command: java -jar selenium-server-4.0.0-beta-3.jar hub
3. Download Selenium Server 4 again to another folder.
4. Download all web drivers you want to use
5. Configure the nodeConfig.toml file
6. Open cmd and run the following command: java -jar selenium-server-4.0.0-beta-3.jar node --config nodeConfig.toml