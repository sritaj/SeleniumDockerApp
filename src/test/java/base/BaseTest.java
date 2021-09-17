package base;

import genericMethods.PropertiesFile;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        //BROWSER VARIABLE
        //HUB_HOST

        String host = "localhost";
        DesiredCapabilities dc = new DesiredCapabilities();

        String runMode = PropertiesFile.getDataFromPropertyFile("localrun");
        System.out.println(runMode);

        if(runMode.equalsIgnoreCase("No")){
            if(System.getProperty("BROWSER")!=null){
                if(System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
                    dc.setBrowserName(BrowserType.CHROME);
                }else if (System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
                    dc.setBrowserName(BrowserType.FIREFOX);
                }
            }else{
                dc.setBrowserName(BrowserType.CHROME);
            }

            if(System.getProperty("HUB_HOST")!=null){
                host = System.getProperty("HUB_HOST");
            }

            String completeURL = "http://" + host + ":4444/wd/hub";
            this.driver = new RemoteWebDriver(new URL(completeURL), dc);

            driver.manage().window().maximize();
            driver.get("http://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        }else if(runMode.equalsIgnoreCase("Yes")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
