package webPages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class FacebookHomePage extends BasePage {

    private final By homeIcon = By.xpath("//*[name()='path' and contains(@class,'p361ku9c')]");
    private final By friendsIcon = By.xpath("//span[contains(text(),'Friends')]");
    private final By statusBox = By.xpath("//span[contains(.,\"What's on your mind\")]");
    private final By closeStatusBox = By.xpath("//div[@aria-label='Close']//i[@class='hu5pjgll m6k467ps']");
    private final By createPostLabel = By.xpath("//span[contains(text(),'Create post')]");
    private final By createPostTextBox = By.xpath("//div[@class='_1mf _1mj']");
    private final By postButton = By.xpath("//div[@aria-label='Post']");
    private final By createPostTextBoxStyleOption = By.xpath("//span[@class='hop8lmos rl04r1d5']//img");

    public FacebookHomePage() {
        super();
    }

    public void clickOnHomeIcon() {
        elementHelper.clickElement(homeIcon);
        waitHelper.performExplicitWait(WaitStrategy.VISIBILITY, friendsIcon);
        waitHelper.performExplicitWait(WaitStrategy.CLICKABLE, statusBox);
    }

    public String getUserDetailFromStatusBox() {
        return elementHelper.getElement(statusBox).getText();
    }

    public String clickOnStatusBox() {
        elementHelper.clickElement(statusBox);
        waitHelper.performExplicitWait(WaitStrategy.VISIBILITY, createPostLabel);
        waitHelper.performExplicitWait(WaitStrategy.VISIBILITY, createPostTextBoxStyleOption);
        waitHelper.performExplicitWait(WaitStrategy.CLICKABLE, createPostTextBox);
        return elementHelper.getElement(statusBox).getText();
    }

    public void postStatus(String status) {
        elementHelper.sendKeysToElement(createPostTextBox, status);
        elementHelper.clickElement(postButton);
        waitHelper.performExplicitWaitAndGetState(WaitStrategy.INVISIBILITY, createPostTextBoxStyleOption);
    }

    public void closeStatusBox() {
        elementHelper.clickElement(closeStatusBox);
    }

    public void clickOnUserAccountOptionInRibbonBar(String username) {
        String userAccountRibbonMenuPath = String.format("//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'][normalize-space()='%s']", username);
        By userAccountRibbonMenu = By.xpath(userAccountRibbonMenuPath);
        elementHelper.clickElement(userAccountRibbonMenu);
    }

}
