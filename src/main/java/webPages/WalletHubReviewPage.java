package webPages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class WalletHubReviewPage extends BasePage {

    private final By ratingBox = By.xpath("//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg']");
    private final By getQuoteButton = By.xpath("//button[@class='btn btn-w-126']");

    public WalletHubReviewPage() {
        super();
    }

    public void scrollToRatingBox() {
        elementHelper.scrollToSpecifiedElement(ratingBox);
    }

    public void wbHoverOnStars(int rating) {
        String starSelection = String.format("//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg'][%s]", rating);
        By selectedStar = By.xpath(starSelection);
        elementHelper.hoverOnElement(selectedStar);
    }

    public void selectARating(int rating) {
        String ratingSelection = String.format("//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg'][%s]", rating);
        By selectedRating = By.xpath(ratingSelection);
        elementHelper.hoverOnElement(selectedRating);
        elementHelper.getElement(selectedRating).click();
    }

    public void waitForPageToLoad() {
        waitHelper.performExplicitWait(WaitStrategy.PRESENCE, getQuoteButton);
    }

    public String verifyUserComment(String username, String comment) {
        String actualText = "";
        String userPath = String.format("//span[normalize-space()='@%s']", username);
        String userComment = String.format("//span[normalize-space()='@sritajpatel']/following::div[starts-with(text(),'%s')]", comment);
        By userToCheck = By.xpath(userPath);
        By commentToCheck = By.xpath(userComment);
        if (elementHelper.getElement(userToCheck).isDisplayed()) {
            actualText = elementHelper.getElement(commentToCheck).getText();
        }
        return actualText;

    }

}
