package webPagesTest;

import base.BaseTest;
import listeners.CustomAnnotations;
import org.testng.Assert;
import org.testng.annotations.Test;
import webPages.FlightDetailsPage;
import webPages.RegistrationConfirmationPage;
import webPages.UserRegistrationPage;

public class FlightDetailsPageTest extends BaseTest {

    @CustomAnnotations(testCaseType = {})
    @Test(groups = "Regression")
    public void setPassengersCount() {
        UserRegistrationPage registration = new UserRegistrationPage();
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage();
        confirmation.clickOnFlights();
        FlightDetailsPage flightDetails = new FlightDetailsPage();
        flightDetails.waitForPageHeaderToLoad();
        flightDetails.selectPassengerCount("2");
    }

    @CustomAnnotations(testCaseType = {"Client Feedback", "Enhancement Request"})
    @Test(groups = "Smoke", suiteName = "FlightDetails")
    public void validatePageTitle() {
        UserRegistrationPage registration = new UserRegistrationPage();
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage();
        confirmation.clickOnFlights();
        FlightDetailsPage flightDetails = new FlightDetailsPage();
        flightDetails.waitForPageHeaderToLoad();
        String expectedPageTitle = "Flight Details Page";
        String actualPageTitle = flightDetails.getPageTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Validated");
    }

    @Test(groups = "Regression")
    public void selectSeatingClass() throws Exception {
        UserRegistrationPage registration = new UserRegistrationPage();
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage();
        confirmation.clickOnFlights();
        FlightDetailsPage flightDetails = new FlightDetailsPage();
        flightDetails.waitForPageHeaderToLoad();
        flightDetails.selectServiceClass("Business");
    }

    @CustomAnnotations()
    @Test(testName = "Verify Invalid Seating Seat", groups = "Regression")
    public void selectInvalidSeatingClass() throws Exception {
        UserRegistrationPage registration = new UserRegistrationPage();
        registration.fillContactInformation("Sritaj", "Kumar", "90393", "sritajp@gmail.com");
        registration.fillUserInformation("sritaj", "Hello", "Hello");
        registration.clickSubmit();
        RegistrationConfirmationPage confirmation = new RegistrationConfirmationPage();
        confirmation.clickOnFlights();
        FlightDetailsPage flightDetails = new FlightDetailsPage();
        flightDetails.waitForPageHeaderToLoad();
        String expectedErrorMsg = "Invalid Service Class";
        try {
            flightDetails.selectServiceClass("Test");
        } catch (Exception e) {
            String actualMsg = e.getMessage();
            Assert.assertEquals(actualMsg, expectedErrorMsg, "Validated");
        }
    }
}
