package helper;

import org.openqa.selenium.By;

public class LocatorHelper {

    protected LocatorHelper() {
    }

    //TO DO
    public static By initializeLocator(String locatorType, String value) {
        switch (locatorType) {
            case "id":
                return By.id(value);
            case "linkTest":
                return By.linkText(value);
            default:
                return null;
        }
    }
}
