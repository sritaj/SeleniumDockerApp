package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utilities.TakeScreenshotImp;

import java.util.Objects;


public final class ExtentReportsImp {

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;

    private ExtentReportsImp() {
    }


    public static void initializeReport() {
        if (Objects.isNull(extent)) {
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

    public static void passTest(String testName, String screenshotIsRequired) {
        if (screenshotIsRequired.equalsIgnoreCase("yes")) {
            ExtentReportManager.getTest().log(Status.PASS, testName + " Test Case is PASSED").addScreenCaptureFromBase64String(TakeScreenshotImp.takeScreenshotAsBase64());
            // test.pass(testName + " Test Case is PASSED", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
        }
        ExtentReportManager.getTest().log(Status.PASS, testName + " Test Case is PASSED");
    }

    public static void skipTest(String testName, String screenshotIsRequired) {
        if (screenshotIsRequired.equalsIgnoreCase("yes")) {
            ExtentReportManager.getTest().log(Status.SKIP, testName + " Test Case is SKIPPED").addScreenCaptureFromBase64String(TakeScreenshotImp.takeScreenshotAsBase64());

        }
        ExtentReportManager.getTest().log(Status.SKIP, testName + " Test Case is SKIPPED");
    }

    public static void failTest(String testName, String screenshotIsRequired) {
        if (screenshotIsRequired.equalsIgnoreCase("yes")) {
            ExtentReportManager.getTest().log(Status.FAIL, testName + " Test Case is FAILED").addScreenCaptureFromBase64String(TakeScreenshotImp.takeScreenshotAsBase64());

        }
        ExtentReportManager.getTest().log(Status.FAIL, testName + " Test Case is FAILED");
    }

    public static void failTestException(Throwable throwable) {
        ExtentReportManager.getTest().fail(throwable);
    }

    public static void logSteps(String record) {
        ExtentReportManager.getTest().info(record);
    }

    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
    }
}
