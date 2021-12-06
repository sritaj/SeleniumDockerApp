package webPages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class WalletHubSubmitReviewPage extends BasePage {

    private final By selectInsuranceType = By.xpath("//span[normalize-space()='Select...']");
    private final By selectHealthInsurance = By.xpath("//ul/li[text()='Health Insurance']");
    private final By reviewSection = By.xpath("//textarea[@placeholder='Write your review...']");
    private final By submitButton = By.xpath("//div[@class='sbn-action semi-bold-font btn fixed-w-c tall']");
    private final By progressIndicator = By.xpath("//div[@class='progress-indicator visible']//i"); //visible
    private final By confirmationMsg = By.xpath("//h1[contains(text(),'Before we publish your review we need you to verif')]");

    public WalletHubSubmitReviewPage() {
        super();
    }

    public void clickOnInsuranceType() {
        ddHelper.clickSpanDropDown(elementHelper.getElement(selectInsuranceType));
    }

    public void setSelectHealthInsurance() {
        elementHelper.clickElement(selectHealthInsurance);
    }

    public void writeReview(String review) {
        elementHelper.getElement(reviewSection).sendKeys(review);
    }

    public void clickSubmitButton() {
        elementHelper.clickElement(submitButton);
    }

    public void waitForProgressIndicatorToVanish() {
        waitHelper.performExplicitWaitAndGetState(WaitStrategy.INVISIBILITY, progressIndicator);
    }

    public String getConfirmationMsg() {
        return elementHelper.getElement(confirmationMsg).getText();
    }

}
