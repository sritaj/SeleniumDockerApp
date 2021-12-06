package helper;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import reports.ExtentReportsImp;

public final class ElementHelper {

    private WebDriver driver;
    private Actions act;

    public ElementHelper() {
        this.driver = DriverManager.getDriver();
        act = new Actions(driver);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void clickElement(By locator) {
        getElement(locator).click();
        ExtentReportsImp.logSteps(getElement(locator).getAttribute("name"));
    }

    public void sendKeysToElement(By locator, String input) {
        getElement(locator).sendKeys(input);
    }

    public void scrollToSpecifiedElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", getElement(locator));
    }

    public void hoverOnElement(By locator) {
        WebElement ele = getElement(locator);
        act.moveToElement(ele);
    }

    public void performClick(By locator) {
        WebElement ele = getElement(locator);
        act.moveToElement(ele).perform();
    }
}
