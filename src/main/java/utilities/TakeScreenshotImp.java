package utilities;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public class TakeScreenshotImp {

    /**
     * @param driver   - Webdriver instance
     * @param testName - Test Name
     * @return - Image Path
     */
    public static String takeScreenshot(WebDriver driver, String testName) {
        String dest = null;
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            dest = System.getProperty("user.dir") + "/target/screenshots/" + testName + ".png";
            FileHandler.copy(srcFile, new File(dest));
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return dest;
    }

    /**
     * @param driver   - Webdriver instance
     * @param testName - Test Name
     * @return - Image Path
     */
    public static String takeScreenshotAsBase64_IO(WebDriver driver, String testName) {

        String path = null;
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dest = System.getProperty("user.dir") + "/target/screenshots/" + testName + ".png";
            FileHandler.copy(srcFile, new File(dest));
            byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(dest));
            path = Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return path;
    }

    /**
     * @param driver - Webdriver instance
     * @return path
     */
    public static String takeScreenshotAsBase64(WebDriver driver) {

        String path = null;
        try {
            TakesScreenshot newScreen = (TakesScreenshot) driver;
            String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
            return "data:image/jpg;base64, " + scnShot;
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return path;
    }
}
