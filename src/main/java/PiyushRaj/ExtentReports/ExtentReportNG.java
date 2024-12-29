package PiyushRaj.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    public static ExtentReports GetreportObject() {

        String Path = System.getProperty("user.dir" + "//reports//Piyush.html");
        ExtentSparkReporter Reporters = new ExtentSparkReporter(Path);
        Reporters.config().setDocumentTitle("Piyush_Report");
        Reporters.config().setReportName("RajReport");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(Reporters);
        extent.setSystemInfo("name","Piyush");
        extent.createTest("SubmitOrderErrorValidation");
        return extent;

    }

}
