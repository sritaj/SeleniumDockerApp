package constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String RESOURCEPATH = System.getProperty("user.dir");
    private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/src/main/resources/drivers/chromedriver";
    private static final String PROPERTIESFILEPATH = RESOURCEPATH + "/src/main/resources/config/config.properties";

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getPropertiesFilePath() {
        return PROPERTIESFILEPATH;
    }
}
