package utilities;

import driver.DriverManager;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public final class TakeScreenshotImp {

    private TakeScreenshotImp() {
    }

    /**
     * @param testName - Test Name
     * @return - Image Path
     */
    public static String takeScreenshot(String testName) {
        String dest = null;
        try {
            File srcFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            dest = System.getProperty("user.dir") + "/target/screenshots/" + testName + ".png";
            FileHandler.copy(srcFile, new File(dest));
        } catch (Exception e) {
            System.err.println("Exception while taking screenshot " + e.getMessage());
        }
        return dest;
    }

    /**
     * @param testName - Test Name
     * @return - Image Path
     */
    public static String takeScreenshotAsBase64_IO(String testName) {

        String path = null;
        try {
            File srcFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            String dest = System.getProperty("user.dir") + "/target/screenshots/" + testName + ".png";
            FileHandler.copy(srcFile, new File(dest));
            byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(dest));
            path = Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            System.err.println("Exception while taking screenshot " + e.getMessage());
        }
        return path;
    }

    /**
     * @return path
     */
    public static String takeAndSaveScreenshotAsBase64() {

        String path = null;
        try {
            TakesScreenshot newScreen = (TakesScreenshot) DriverManager.getDriver();
            String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
            return "data:image/jpg;base64, " + scnShot;
        } catch (Exception e) {
            System.err.println("Exception while taking screenshot " + e.getMessage());
        }
        return path;
    }

    /**
     * @return String
     */
    public static String takeScreenshotAsBase64() {

        String scnShot = null;
        try {
            scnShot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            System.err.println("Exception while taking screenshot " + e.getMessage());
        }
        return scnShot;
    }
}
