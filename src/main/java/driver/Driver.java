package driver;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.PropertiesFileImp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public final class Driver {

    protected Driver() {
    }

    public static void init() {

        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup();
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertiesFileImp.getDataFromPropertyFile(ConfigProperties.URL));
        }
    }

    public static void gridInit() {
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup();
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(BrowserType.CHROME);
            try{
                DriverManager.setDriver(new RemoteWebDriver(
                        new URL("http://localhost:4444/wd/hub"), dc));
            }catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(PropertiesFileImp.getDataFromPropertyFile(ConfigProperties.URL
        ));

//        if (System.getProperty("BROWSER") != null) {
//            if (System.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
//                dc.setBrowserName(BrowserType.CHROME);
//            } else if (System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
//                dc.setBrowserName(BrowserType.FIREFOX);
//            }
//        } else {
//            dc.setBrowserName(BrowserType.CHROME);
//        }
//
//        String completeURL = null;
//        if (System.getProperty("HUB_HOST") != null) {
//            //completeURL = "http://" + System.getProperty("HUB_HOST") + ":4444/wd/hub";
//            completeURL = "http://hub:4444/wd/hub";
//        }
//
//        DriverManager.setDriver(new RemoteWebDriver(new URL(completeURL), dc));

//        DriverManager.getDriver().manage().window().maximize();
//        DriverManager.getDriver().get(PropertiesFileImp.getDataFromPropertyFile(ConfigProperties.URL
//        ));
    }

    public static void quit() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().close();
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }

    }
}
