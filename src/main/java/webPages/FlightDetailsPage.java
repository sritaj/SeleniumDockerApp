package webPages;

import org.openqa.selenium.By;

public final class FlightDetailsPage extends BasePage {

    public FlightDetailsPage() {
        super();
    }

    private final By pageHeader = By.xpath("//h1[contains(text(),'Flight Details Page')]");
    private final By passengerCount = By.id("passCount");
    private final By businessClassRadioButton = By.xpath("//input[@name='servClass' and @value = 'Business']");
    private final By economyClassRadioButton = By.xpath("//input[@name='servClass' and @value = 'Coach']");
    private final By firstClassRadioButton = By.xpath("//input[@name='servClass' and @value = 'First']");


    public String getPageTitle() {
        return elementHelper.getElement(pageHeader).getText();
    }

    public void waitForPageHeaderToLoad() {
        waitHelper.waitForElementVisibility(10, elementHelper.getElement(pageHeader));
    }

    public void selectPassengerCount(String count) {
        ddHelper.selectDropDownByValue(elementHelper.getElement(passengerCount), count);
    }

    public void selectServiceClass(String input) throws Exception {
        switch (input) {
            case "Business":
                elementHelper.clickElement(businessClassRadioButton);
                break;
            case "Coach":
                elementHelper.clickElement(economyClassRadioButton);
                break;
            case "First":
                elementHelper.clickElement(firstClassRadioButton);
                break;
            default:
                throw new Exception("Invalid Service Class");
        }
    }

}
