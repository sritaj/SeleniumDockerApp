package webPages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class FacebookProfilePage extends BasePage {

    private final By statusBox = By.xpath("//span[contains(.,\"What's on your mind\")]");

    public FacebookProfilePage() {
        super();
    }

    public void waitForProfilePageToLoad() {
        waitHelper.performExplicitWait(WaitStrategy.VISIBILITY, statusBox);
    }

    public boolean verifyPostPresence(String postMsg) {
        String postPath = String.format("//div[contains(text(),'%s')]", postMsg);
        By postPathInProfileDetailsPage = By.xpath(postPath);
        return elementHelper.getElement(postPathInProfileDetailsPage).isDisplayed();
    }
}
