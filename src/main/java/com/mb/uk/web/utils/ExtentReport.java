package com.mb.uk.web.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReport {

    private static ExtentReports extent;
    public static ExtentTest extentTest;

    /**
     * @implNote Initializes Report object
     */
    public static void initReports(){
        extent=new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setReportName("Mercedes Benz feature test");
    }

    /**
     * @implNote Flush the Report object
     * @throws IOException
     */
    public static void flushReport() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("index.html").toURI());
    }

    /**
     * @implNote Create a Test for Reporting
     * @param testCaseName
     */
    public static void createTest(String testCaseName){
        extentTest=extent.createTest(testCaseName);
    }

    /**
     * @implNote Returns Current Test object
     * @return
     */
    public static ExtentTest getExtentTest(){
        return extentTest;
    }

}
