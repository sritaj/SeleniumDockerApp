package webPages;

import org.openqa.selenium.By;

public final class UserRegistrationPage extends BasePage {

    public UserRegistrationPage() {
        super();
    }

    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By phone = By.name("phone");
    private final By userName = By.name("email");
    private final By email = By.name("userName");
    private final By password = By.name("password");
    private final By confirmPassword = By.name("confirmPassword");
    private final By submit = By.name("register");


    public void fillContactInformation(String firstname, String lastname, String phonenumber, String emailid) {
        elementHelper.sendKeysToElement(firstName, firstname);
        elementHelper.sendKeysToElement(lastName, lastname);
        elementHelper.sendKeysToElement(phone, phonenumber);
        elementHelper.sendKeysToElement(email, emailid);
    }

    public void fillUserInformation(String username, String pwd, String confirmPwd) {
        elementHelper.sendKeysToElement(userName, username);
        elementHelper.sendKeysToElement(password, pwd);
        elementHelper.sendKeysToElement(confirmPassword, confirmPwd);
    }

    public void clickSubmit() {
        elementHelper.clickElement(submit);
    }
}
