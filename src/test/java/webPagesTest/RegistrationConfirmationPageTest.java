package webPagesTest;

import base.BaseTest;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import webPages.RegistrationConfirmationPage;
import webPages.UserRegistrationPage;

public class RegistrationConfirmationPageTest extends BaseTest {

    @Test
    public void fillNewUserDetailsAndClickOnFlights() {
        UserRegistrationPage registration = new UserRegistrationPage();
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage();
        confirmation.waitForPageToLoad();
        confirmation.clickOnFligts();
    }

    @Test
    public void checkSignInLink() {
        UserRegistrationPage registration = new UserRegistrationPage();
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage();
        Assert.assertTrue(confirmation.checkSignInLink(), "Validate");
    }

}
