package helper;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reports.ExtentReportsImp;

public final class ElementHelper {

    private WebDriver driver;

    public ElementHelper() {
        this.driver = DriverManager.getDriver();
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void clickElement(By locator) {
        getElement(locator).click();
        if(getElement(locator).getAttribute("name")!=null){
            ExtentReportsImp.logSteps("Clicked on '"+getElement(locator).getAttribute("name")+ "'");
        }

    }

    public void sendKeysToElement(By locator, String input) {
        getElement(locator).sendKeys(input);
    }
}
