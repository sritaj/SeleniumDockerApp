package constants;

import enums.ConfigProperties;
import utilities.PropertiesFileImp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String RESOURCEPATH = System.getProperty("user.dir");
    private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/src/main/resources/drivers/chromedriver";
    private static final String PROPERTIESFILEPATH = RESOURCEPATH + "/src/main/resources/config/config.properties";
    private static final String EXTENTREPORTSPATH = RESOURCEPATH + "/target/reports/";
    private static final int EXPLICITWAIT_TIMEOUT = 10;
    private static final int RETRYCOUNTS = 1;

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getPropertiesFilePath() {
        return PROPERTIESFILEPATH;
    }

    public static int getExplicitWaitTimeOut() {
        return EXPLICITWAIT_TIMEOUT;
    }

    public static String getExtentReportPath() {
        if (PropertiesFileImp.getDataFromPropertyFile(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
            return EXTENTREPORTSPATH;
        }
        return EXTENTREPORTSPATH + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "/";
    }

    public static int getRetryCounts() {
        return RETRYCOUNTS;
    }
}
