package com.mb.uk.tests;

import com.mb.uk.web.utils.ExtentReport;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            ExtentReport.flushReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.getExtentTest().pass(result.getMethod().getMethodName() +" is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReport.getExtentTest().fail(result.getMethod().getMethodName() +" is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReport.getExtentTest().skip(result.getMethod().getMethodName() +" is skipped");
    }
}
