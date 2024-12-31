package Piyush.TestComponents;

import PiyushRaj.ExtentReports.ExtentReportNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.dockerjava.core.util.FilePathUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.IOException;


public class Listeners extends BaseTest implements ITestListener {
    ExtentReports extent;
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        extent = ExtentReportNG.GetreportObject();
       test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = test.log(Status.PASS,"Test Pass");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = test.fail(result.getThrowable());


        String FilePath=null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
            throw new RuntimeException(e1);
        }

        test.addScreenCaptureFromPath(FilePath, ((result.getMethod().getMethodName())));


    }
/*
    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }
*/
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }


}