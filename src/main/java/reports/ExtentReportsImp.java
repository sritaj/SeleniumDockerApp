package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;


public final class ExtentReportsImp {

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private static ExtentTest test;

    private ExtentReportsImp() {
    }


    public static void initializeReport() {
        if(Objects.isNull(extent)){
            extent = new ExtentReports();
            spark = new ExtentSparkReporter("target/reports/AutomationReport.html");
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("AutomationReport");
            spark.config().setReportName("Selenium Docker App");
            extent.attachReporter(spark);
        }
    }

    public static void startTestExecution(String testName, String description) {
         ExtentReportManager.setTest(extent.createTest(testName, description));
    }

    public static void passTest(String testName) {
        ExtentReportManager.getTest().log(Status.PASS, testName + " Test Case is PASSED");
    }

    public static void passTest(String testName, String screenshot) {
        ExtentReportManager.getTest().log(Status.PASS, testName + " Test Case is PASSED").addScreenCaptureFromBase64String(screenshot);
        // test.pass(testName + " Test Case is PASSED", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
    }

    public static void skipTest(String testName) {
        ExtentReportManager.getTest().log(Status.SKIP, testName + " Test Case is SKIPPED");
    }

    public static void skipTest(String testName, String screenshot) {
        ExtentReportManager.getTest().log(Status.SKIP, testName + " Test Case is SKIPPED").addScreenCaptureFromPath(screenshot);
    }

    public static void failTest(String testName) {
        ExtentReportManager.getTest().log(Status.FAIL, testName + " Test Case is FAILED");
    }

    public static void failTest(String testName, String screenshot) {
        test.log(Status.FAIL, testName + " Test Case is FAILED").addScreenCaptureFromPath(screenshot);
    }

    public static void failTestException(Throwable throwable) {
        test.fail(throwable);
    }

    public static void flushReports() {
        if(Objects.nonNull(extent)){
            extent.flush();
        }
    }
}
