# wh-gptask


## Locally 

Properties needed to run Selenium GUI test:
`useRemote=false`

## Remote

Properties needed to run Selenium GUI test:
`useRemote=true`
`gridURL=http://<hub_ip_adress>:<hub_port>/wd/hub`

Command to run testsuite from command line:

### Hub

Prerequisite:
JAVA installed on server
Configuration:
1. Download - Selenium Standalone Server version 3.141.59
2. Run it as Hub from commandline
`java -jar selenium-server-standalone-3.141.5.jar -role hub`


### Node

Prerequisite:
JAVA installed on server
Configuration:
1. Download - Selenium Standalone Server version 3.141.59
2. Download ChromeDriver
3. Download FirefoxDriver
4. Run it as Hub from commandline
    * chromeDriver
    `java -Dwebdriver.chrome.driver=<chrome_driver_path> -jar selenium-server-standalone-3.141.5.jar -role webdriver -hub http://<hub_ip_adress>:4444/grid/register -port 5555
`
