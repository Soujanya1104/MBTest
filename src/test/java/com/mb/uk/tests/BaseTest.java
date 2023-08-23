package com.mb.uk.tests;


import com.mb.uk.web.utils.ConfigReader;
import com.mb.uk.web.utils.Constants;
import com.mb.uk.web.utils.DriverManager;
import com.mb.uk.web.utils.ExtentReport;
import org.testng.annotations.*;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

public class BaseTest {

    /**
     * @implNote Load Configs
     * @throws IOException
     */
    @BeforeSuite
    protected void loadConfigs() throws IOException {
        ConfigReader.loadProps();
        ExtentReport.initReports();
    }

    /**
     * @implNote Set up driver
     * @param browser
     * @throws Exception
     */
    @BeforeMethod
    @Parameters({"browser"})
    protected void setDriver(@Optional("chrome") String browser) throws Exception{
        DriverManager.launchDriver(getBrowser(browser));
        DriverManager.driver.get(ConfigReader.getConfigProps().getProperty("URL"));
        DriverManager.driver.manage().window().maximize();
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        DriverManager.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    /**
     * @implNote Get Browser from Constants
     * @param browser
     * @return
     */
    public String getBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome"))
            return Constants.CHROME;
        else if(browser.equalsIgnoreCase("firefox"))
            return Constants.FIREFOX;
        else
            return Constants.EDGE;
    }

    /**
     * @implNote quite driver
     */
    @AfterMethod
    protected void tearDown(){
        DriverManager.quitDriver();
    }
}
