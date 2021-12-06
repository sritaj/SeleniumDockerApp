package webPages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class WalletHubSignInPage extends BasePage {

    private final By loginTab = By.xpath("//a[normalize-space()='Login']");
    private final By emailAddress = By.xpath("//input[@id='em-ipt']");
    private final By password = By.xpath("//input[@id='pw1-ipt']");
    private final By confirmPassword = By.xpath("//input[@id='pw2-ipt']");
    private final By checkbox = By.xpath("//em[@class='track bf-icon-ok']");
    private final By joinButton = By.xpath("//button[@type='button']");
    private final By editButton = By.xpath("//button[@class=\"btn\"]");

    public WalletHubSignInPage() {
        super();
    }

    public void login(String emailID, String pwd) {
        elementHelper.clickElement(loginTab);
        elementHelper.sendKeysToElement(emailAddress, emailID);
        elementHelper.sendKeysToElement(password, pwd);
        elementHelper.clickElement(joinButton);
    }

    public void waitForPageLoad() {
        waitHelper.performExplicitWait(WaitStrategy.PRESENCE, loginTab);
    }
}
