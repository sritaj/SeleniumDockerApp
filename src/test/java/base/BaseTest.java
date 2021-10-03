package base;

import driver.Driver;
import driver.DriverManager;
import enums.ConfigProperties;
import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ExtentReportsImp;
import utilities.PropertiesFileImp;
import utilities.TakeScreenshotImp;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class BaseTest {

    protected WebDriver driver;

    protected BaseTest() {
    }

    @BeforeSuite
    public void beforeSuite() {
        // Extent Report Initialization
        ExtentReportsImp.initializeReport();

    }

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        //BROWSER VARIABLE
        //HUB_HOST

        DesiredCapabilities dc = new DesiredCapabilities();

        // Extent Report Initialization
        String testName = method.getName();
        String testDescription = method.getAnnotation(Test.class).testName();
        ExtentReportsImp.startTestExecution(testName, testDescription);

        //Getting Local Run status
        String runMode = PropertiesFileImp.getDataFromPropertyFile(ConfigProperties.LOCALRUN);
        if (runMode.equalsIgnoreCase("No")) {
            Driver.gridInit();

        } else if (runMode.equalsIgnoreCase("Yes")) {
            Driver.init();
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            String testName = result.getName();
            String screenshot = TakeScreenshotImp.takeScreenshotAsBase64(DriverManager.getDriver());
            ExtentReportsImp.failTest(testName, screenshot);
            ExtentReportsImp.failTestException(result.getThrowable());

        } else if (ITestResult.SUCCESS == result.getStatus()) {
            String testName = result.getName();
            String screenshot = TakeScreenshotImp.takeScreenshotAsBase64(DriverManager.getDriver());
            ExtentReportsImp.passTest(testName, screenshot);
//            String testName = result.getName().toString();
//            ExtentReportsImp.passTest(testName);

        } else if (ITestResult.SKIP == result.getStatus()) {
            String testName = result.getName();
            String screenshot = TakeScreenshotImp.takeScreenshotAsBase64(DriverManager.getDriver());
            ExtentReportsImp.skipTest(testName, screenshot);
//            String testName = result.getName().toString();
//            ExtentReportsImp.skipTest(testName);
        }

        Driver.quit();
    }

    @AfterSuite()
    public void afterSuite() {
        ExtentReportsImp.closeReport();
    }
}
