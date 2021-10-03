package helper;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public final class DropDownHelper {

    private WebDriver driver;
    private Select select;

    public DropDownHelper() {
        this.driver = DriverManager.getDriver();
    }

    public void selectDropDownByValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }
}
