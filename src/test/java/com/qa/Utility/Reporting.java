package com.qa.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
    public ExtentHtmlReporter htmlReport;
    public ExtentReports extentReports;
    public ExtentTest xtest;

    public void onStart(ITestContext testContext) {
        String dateStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String reportName = "TestAutomationMobileReport-" + dateStamp + ".html";
        String reportDirPath = System.getProperty("user.dir") + File.separator + "Reporter";

        // Ensure the Reporter directory exists
        File reportDir = new File(reportDirPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        htmlReport = new ExtentHtmlReporter(reportDirPath + File.separator + reportName);
        htmlReport.config().setDocumentTitle("Test Automation Execution Summary");
        htmlReport.config().setReportName("Bervistay UI functional Testing");
        htmlReport.config().setTheme(Theme.STANDARD);
        htmlReport.config().setAutoCreateRelativePathMedia(true);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReport);
        extentReports.setSystemInfo("QA Name", "Shashidhar");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("OS", "Windows 11");
        extentReports.setSystemInfo("hostname", "localhost");
    }

    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }

    public void onTestSuccess(ITestResult tr) {
        xtest = extentReports.createTest(tr.getName());
        xtest.log(Status.PASS, "The Test is Passed Successfully");
        xtest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult tr) {
        xtest = extentReports.createTest(tr.getName());
        xtest.log(Status.FAIL, "The Test is Failed");
        xtest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
        xtest.log(Status.FAIL, tr.getThrowable());

        String screenshotDirPath = System.getProperty("user.dir") + File.separator + "Screenshots";
        String screenshotPath = screenshotDirPath + File.separator + tr.getName() + ".png";

        // Ensure the ScreenShots directory exists
        File screenshotDir = new File(screenshotDirPath);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        File path = new File(screenshotPath);
        if (path.exists()) {
            try {
                xtest.fail("ScreenShot of failed test is below:" + xtest.addScreenCaptureFromPath(screenshotPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onTestSkipped(ITestResult tr) {
        xtest = extentReports.createTest(tr.getName());
        xtest.log(Status.SKIP, "The Test is Skipped");
        xtest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
        xtest.log(Status.SKIP, tr.getThrowable());
    }
}
