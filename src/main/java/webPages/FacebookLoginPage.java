package webPages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class FacebookLoginPage extends BasePage {

    private final By emailAddress = By.xpath("//input[@id='email']");
    private final By password = By.xpath("//input[@id='pass']");
    private final By logIn = By.xpath("//button[@name='login']");
    private final By homeIcon = By.xpath("//*[name()='path' and contains(@class,'p361ku9c')]");

    public FacebookLoginPage() {
        super();
    }

    public void login(String userPhoneNumber, String pwd) {
        elementHelper.sendKeysToElement(emailAddress, userPhoneNumber);
        elementHelper.sendKeysToElement(password, pwd);
        elementHelper.clickElement(logIn);
        waitHelper.performExplicitWait(WaitStrategy.PRESENCE, homeIcon);
    }
}
