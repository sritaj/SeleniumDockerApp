package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

    private WebDriver driver;
    public WebDriverWait wait;

    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Flights")
    private WebElement flights;

    @FindBy(xpath = "//a[@href='login.php']")
    private WebElement signInLink;

    public void clickOnFligts() {
        this.flights.click();
    }

    public void waitForPageToLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(signInLink));
    }

    public boolean checkSignInLink() {
        return this.signInLink.isDisplayed();
    }
}
