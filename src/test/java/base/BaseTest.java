package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ExtentReportsImp;
import utilities.PropertiesFile;
import utilities.TakeScreenshot;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        // Extent Report Initialization
        ExtentReportsImp.initializeReport();

    }

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        //BROWSER VARIABLE
        //HUB_HOST

        String host = "localhost";
        DesiredCapabilities dc = new DesiredCapabilities();

        // Extent Report Initialization
        String testName = method.getName();
        String testDescription = method.getAnnotation(Test.class).testName();
        ExtentReportsImp.startTestExecution(testName, testDescription);

        //Getting Local Run status
        String runMode = PropertiesFile.getDataFromPropertyFile("localrun");

        if (runMode.equalsIgnoreCase("No")) {
            if (System.getProperty("BROWSER") != null) {
                if (System.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
                    dc.setBrowserName(BrowserType.CHROME);
                } else if (System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
                    dc.setBrowserName(BrowserType.FIREFOX);
                }
            } else {
                dc.setBrowserName(BrowserType.CHROME);
            }

            if (System.getProperty("HUB_HOST") != null) {
                host = System.getProperty("HUB_HOST");
            }

            String completeURL = "http://" + host + ":4444/wd/hub";
            this.driver = new RemoteWebDriver(new URL(completeURL), dc);

            driver.manage().window().maximize();
            driver.get("http://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");

        } else if (runMode.equalsIgnoreCase("Yes")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            String testName = result.getName();
            String screenshot = TakeScreenshot.takeScreenshotAsBase64(driver);
            ExtentReportsImp.failTest(testName, screenshot);
            ExtentReportsImp.failTestException(result.getThrowable());

        } else if (ITestResult.SUCCESS == result.getStatus()) {
            String testName = result.getName();
            String screenshot = TakeScreenshot.takeScreenshotAsBase64(driver);
            ExtentReportsImp.passTest(testName, screenshot);
//            String testName = result.getName().toString();
//            ExtentReportsImp.passTest(testName);

        } else if (ITestResult.SKIP == result.getStatus()) {
            String testName = result.getName();
            String screenshot = TakeScreenshot.takeScreenshotAsBase64(driver);
            ExtentReportsImp.skipTest(testName, screenshot);
//            String testName = result.getName().toString();
//            ExtentReportsImp.skipTest(testName);
        }
        driver.close();
        driver.quit();
    }

    @AfterSuite()
    public void afterSuite() {
        ExtentReportsImp.closeReport();
    }
}
