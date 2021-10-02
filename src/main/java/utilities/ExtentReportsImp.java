package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;

public class ExtentReportsImp {

    static ExtentReports extent;
    static ExtentSparkReporter spark;
    static ExtentTest test;

    private ExtentReportsImp() {
    }

    ;

    public static void initializeReport() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/reports/AutomationReport.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("AutomationReport");
        extent.attachReporter(spark);
    }

    public static void startTestExecution(String testName, String description) {
        test = extent.createTest(testName, description);
    }

    public static void passTest(String testName) {
        test.log(Status.PASS, testName + " Test Case is PASSED");
    }

    public static void passTest(String testName, String screenshot) {
        test.log(Status.PASS, testName + " Test Case is PASSED").addScreenCaptureFromBase64String(screenshot);
        // test.pass(testName + " Test Case is PASSED", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
    }

    public static void skipTest(String testName) {
        test.log(Status.SKIP, testName + " Test Case is SKIPPED");
    }

    public static void skipTest(String testName, String screenshot) {
        test.log(Status.SKIP, testName + " Test Case is SKIPPED").addScreenCaptureFromPath(screenshot);
    }

    public static void failTest(String testName) throws IOException {
        test.log(Status.FAIL, testName + " Test Case is FAILED");
    }

    public static void failTest(String testName, String screenshot) throws IOException {
        test.log(Status.FAIL, testName + " Test Case is FAILED").addScreenCaptureFromPath(screenshot);
    }

    public static void failTestException(Throwable throwable) {
        test.fail(throwable);
    }

    public static void closeReport() {
        extent.flush();
    }
}
