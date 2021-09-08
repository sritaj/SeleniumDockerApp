package webPagesTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import webPages.FlightDetailsPage;
import webPages.RegistrationConfirmationPage;
import webPages.UserRegistrationPage;

public class FlightDetailsPageTest extends BaseTest {

    @Test()
    public void setPassengersCount(){
        UserRegistrationPage registration = new UserRegistrationPage(driver);
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage(driver);
        confirmation.waitForPageToLoad();
        confirmation.clickOnFligts();
        FlightDetailsPage flightDetails = new FlightDetailsPage(driver);
        flightDetails.waitForPageToLoad();
        flightDetails.selectPassengerCount("2");
    }

    @Test()
    public void validatePageTitle(){
        UserRegistrationPage registration = new UserRegistrationPage(driver);
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage(driver);
        confirmation.waitForPageToLoad();
        confirmation.clickOnFligts();
        FlightDetailsPage flightDetails = new FlightDetailsPage(driver);
        flightDetails.waitForPageToLoad();
        String expectedPageTitle = "Flight Details Page";
        String actualPageTitle = flightDetails.getPageTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Validated");
    }

    @Test()
    public void selectSeatingClass() throws Exception {
        UserRegistrationPage registration = new UserRegistrationPage(driver);
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage(driver);
        confirmation.waitForPageToLoad();
        confirmation.clickOnFligts();
        FlightDetailsPage flightDetails = new FlightDetailsPage(driver);
        flightDetails.waitForPageToLoad();
        flightDetails.selectServiceClass("Business");
    }

    @Test()
    public void selectInvalidSeatingClass() throws Exception {
        UserRegistrationPage registration = new UserRegistrationPage(driver);
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage(driver);
        confirmation.waitForPageToLoad();
        confirmation.clickOnFligts();
        FlightDetailsPage flightDetails = new FlightDetailsPage(driver);
        flightDetails.waitForPageToLoad();
        String expectedErrorMsg = "Invalid Service Class";
        try{
            flightDetails.selectServiceClass("Test");
        }catch (Exception e){
            String actualMsg = e.getMessage();
            Assert.assertEquals(actualMsg, expectedErrorMsg, "Validated");
        }
    }
}
