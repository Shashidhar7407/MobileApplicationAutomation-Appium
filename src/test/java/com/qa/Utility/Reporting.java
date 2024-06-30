package com.qa.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {
    private ExtentHtmlReporter htmlReport;
    private ExtentReports extentReports;
    private ExtentTest xtest;
    private String reportDirPath;
    private String commonReportsDirPath;

    @Override
    public void onStart(ITestContext testContext) {
        String projectName = "MobileAutomationReport- Bervistay"; // Replace with your actual project name
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String folderName = projectName + "_" + timestamp;

        // Directory path for reports
        commonReportsDirPath = System.getProperty("user.dir") + File.separator + "common-reports";
        File commonReportsDir = new File(commonReportsDirPath);
        if (!commonReportsDir.exists()) {
            commonReportsDir.mkdirs();
        }

        reportDirPath = commonReportsDirPath + File.separator + folderName + File.separator + "Reporter";
        File reportDir = new File(reportDirPath);

        // Ensure the directory exists
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // HTML Report setup
        String reportName = "TestAutomationMobileReport-" + timestamp + ".html";
        htmlReport = new ExtentHtmlReporter(reportDirPath + File.separator + reportName);
        htmlReport.config().setDocumentTitle("Test Automation Execution Summary");
        htmlReport.config().setReportName("Bervistay UI functional Testing");
        htmlReport.config().setTheme(Theme.STANDARD);
        htmlReport.config().setAutoCreateRelativePathMedia(true);

        // ExtentReports setup
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReport);
        extentReports.setSystemInfo("QA Name", "Shashidhar");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("OS", "Windows 11");
        extentReports.setSystemInfo("hostname", "localhost");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        xtest = extentReports.createTest(tr.getName());
        xtest.log(Status.PASS, "The Test is Passed Successfully");
        xtest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        xtest = extentReports.createTest(tr.getName());
        xtest.log(Status.FAIL, "The Test is Failed");
        xtest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
        xtest.log(Status.FAIL, tr.getThrowable());

        String screenshotDirPath = reportDirPath + File.separator + "Screenshots";
        String screenshotPath = screenshotDirPath + File.separator + tr.getName() + ".png";

        // Ensure the Screenshots directory exists
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

    @Override
    public void onTestSkipped(ITestResult tr) {
        xtest = extentReports.createTest(tr.getName());
        xtest.log(Status.SKIP, "The Test is Skipped");
        xtest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
        xtest.log(Status.SKIP, tr.getThrowable());
    }
}
