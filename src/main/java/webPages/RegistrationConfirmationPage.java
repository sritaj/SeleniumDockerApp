package webPages;

import org.openqa.selenium.By;

public final class RegistrationConfirmationPage extends BasePage {

    public RegistrationConfirmationPage() {
        super();
    }

    private final By flightLink = By.linkText("Flights");
    private final By signInLink = By.xpath("//a[@href='login.php']");

    public void clickOnFlights() {
        elementHelper.clickElement(flightLink);
    }

    public boolean checkSignInLink() {
        waitHelper.waitForElementVisibility(10, elementHelper.getElement(signInLink));
        return elementHelper.getElement(signInLink).isDisplayed();
    }
}
