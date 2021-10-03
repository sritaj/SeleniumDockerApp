package webPagesTest;

import base.BaseTest;
import org.testng.annotations.Test;
import webPages.RegistrationConfirmationPage;
import webPages.UserRegistrationPage;

public class UserRegistrationPageTest extends BaseTest {

    @Test
    public void fillNewUserDetails() {

        UserRegistrationPage registration = new UserRegistrationPage();
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
    }

    @Test
    public void fillNewUserDetailsAndClickOnFlights() {

        UserRegistrationPage registration = new UserRegistrationPage();
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage();
        confirmation.clickOnFlights();
    }

}
