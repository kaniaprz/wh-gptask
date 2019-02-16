package com.williamhill.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.williamhill.helpers.OSValidator;
import com.williamhill.helpers.PropertiesReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;

public class EndToEndBase {
    protected WebDriver driver;

    /**
     * Setup the to be either Firefox or remote web driver.
     * Configuration is loaded from properties file testconfig.properties
     * Test could be executed with local browser or Selenium Grid instantion
     */

    protected WebDriver setUpDriver()throws IOException {

        /**
         * Checking configuration for test executions from properties file.
         */
        boolean useRemoteGrid = Boolean.parseBoolean(PropertiesReader.readProperty("src/test/resources/properties/testconfig.properties", "useRemote"));
        String browser = PropertiesReader.readProperty("src/test/resources/properties/testconfig.properties", "browser");

        /**
         * Checking boolean for useRemote param from properties file.
         * Desired Capabilities used to execute test using nodes in Selenium Grid.
         * If useRemoteGrid=false the test are executed locally using browser on your machine.
         * OS validator helper checking which Operation system is used for build then select proper driver.
         */


        if (useRemoteGrid) {
            String remoteGridUrl=PropertiesReader.readProperty("src/test/resources/properties/testconfig.properties", "gridURL");
            if (browser.equals("chrome")) {
                //Execute with chrome driver
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL(remoteGridUrl), capabilities);
            }
            else if (browser.equals("firefox")) {
                //Execute with firefox drive
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                driver = new RemoteWebDriver(new URL(remoteGridUrl), capabilities);
            }
        }
        else{
            String OS = OSValidator.getOS();
            if (OS.equals("windows")){
                if (browser.equals("chrome")) {
                    //Execute with chrome driver
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/" + OS + "/chromedriver.exe");
                    driver = new ChromeDriver();

                } else if (browser.equals("firefox")) {
                    //Execute with firefox drive
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/" + OS + "geckodriver.exe");
                    driver = new ChromeDriver();
                }
            }
            else if(OS.equals("linux")){
                if (browser.equals("chrome")) {
                    //Execute with chrome driver
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/" + OS + "/chromedriver");
                    driver = new ChromeDriver();

                } else if (browser.equals("firefox")) {
                    //Execute with firefox drive
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/" + OS + "geckodriver");
                    driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }

    /**
     * Run setUpDriver before each test.
     */

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        setUpDriver();
    }

    /**
     * Tidy up after test run
     */
    @AfterClass
    public void tearDownTest() {
        driver.close();
        driver.quit();
    }


}
