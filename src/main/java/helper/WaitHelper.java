package helper;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitHelper {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public WaitHelper() {
        this.driver = DriverManager.getDriver();
        this.elementHelper = new ElementHelper();
    }

    public WebElement performExplicitWait(WaitStrategy waitType, By locator) {
        WebElement element = null;
        if(waitType == WaitStrategy.VISIBILITY){
            element = new WebDriverWait(driver, FrameworkConstants.getExplicitWaitTimeOut()).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }else if(waitType == WaitStrategy.PRESENCE){
            element = new WebDriverWait(driver, FrameworkConstants.getExplicitWaitTimeOut()).until(ExpectedConditions.presenceOfElementLocated(locator));
        }else if(waitType == WaitStrategy.CLICKABLE){
            element = new WebDriverWait(driver, FrameworkConstants.getExplicitWaitTimeOut()).until(ExpectedConditions.elementToBeClickable(locator));
        }else if(waitType == WaitStrategy.NONE){
            return elementHelper.getElement(locator);
        }
        return element;
    }
}
