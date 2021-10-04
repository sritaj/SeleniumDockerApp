package webPages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class RegistrationConfirmationPage extends BasePage {

    public RegistrationConfirmationPage() {
        super();
    }

    private final By flightLink = By.xpath("//a[normalize-space()='Flights']");
    private final By signInLink = By.xpath("//a[@href='login.php']");

    public void clickOnFlights() {
        waitForSignInLink();
        elementHelper.clickElement(flightLink);
    }

    public boolean waitForSignInLink() {
       return waitHelper.performExplicitWait(WaitStrategy.VISIBILITY, signInLink).isDisplayed();
    }
}
