package PiyushRaj.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class ExtentReportNG {

    public static ExtentReports GetreportObject() {
        String reportPath = System.getProperty("user.dir") + "/report/Piyush.html";
        File reportDir = new File(System.getProperty("user.dir") + "/report");

        // Create the report directory if it doesn't exist
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setDocumentTitle("Piyush_Report");
        reporter.config().setReportName("RajReport");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester Name", "Piyush");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}
