package webPagesTest;

import base.BaseTest;
import listeners.CustomAnnotations;
import org.testng.Assert;
import org.testng.annotations.Test;
import webPages.RegistrationConfirmationPage;
import webPages.UserRegistrationPage;

public class RegistrationConfirmationPageTest extends BaseTest {

    @CustomAnnotations(testCaseType = "")
    @Test
    public void fillNewUserDetailsAndClickOnFlights() {
        UserRegistrationPage registration = new UserRegistrationPage();
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage();
        confirmation.waitForSignInLink();
        confirmation.clickOnFlights();
    }

    @Test
    public void checkSignInLink() {
        UserRegistrationPage registration = new UserRegistrationPage();
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage();
        Assert.assertTrue(confirmation.waitForSignInLink(), "Validate");
    }

}
