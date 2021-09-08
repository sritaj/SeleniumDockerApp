package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Flight Details Page')]")
    private WebElement pageHeader;

    @FindBy(id = "passCount")
    private WebElement passengerCount;

    @FindBy(xpath = "//input[@name='servClass' and @value = 'Business']")
    private WebElement businessClassRadioButton;

    @FindBy(xpath = "//input[@name='servClass' and @value = 'Coach']")
    private WebElement economyClassRadioButton;

    @FindBy(xpath = "//input[@name='servClass' and @value = 'First']")
    private WebElement firstClassRadioButton;

    public String getPageTitle(){
        return this.pageHeader.getText();
    }

    public void waitForPageToLoad(){
        this.wait.until(ExpectedConditions.visibilityOf(pageHeader));
    }

    public void selectPassengerCount(String count){
        Select sel = new Select(this.passengerCount);
        sel.selectByValue(count);
    }

    public void selectServiceClass(String input) throws Exception {
        switch(input){
            case "Business":
                this.businessClassRadioButton.click();
                break;
            case "Coach":
                this.economyClassRadioButton.click();
                break;
            case "First":
                this.firstClassRadioButton.click();
                break;
            default:
                throw new Exception("Invalid Service Class");
        }
    }

}
