package helper;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitHelper {

    private WebDriver driver;

    public WaitHelper() {
        this.driver = DriverManager.getDriver();
    }

    public void waitForElementVisibility(int waitTime, WebElement element) {
        new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOf(element));
    }
}
