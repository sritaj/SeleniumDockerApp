package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegistrationPage {

    private WebDriver driver;

    @FindBy(name="firstName")
    private WebElement firstName;

    @FindBy(name="lastName")
    private WebElement lastName;

    @FindBy(name="phone")
    private WebElement phone;

    @FindBy(name="userName")
    private WebElement email;

    @FindBy(name="email")
    private WebElement userName;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name="register")
    private WebElement submit;

    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillContactInformation(String firstName, String lastName, String phone, String email){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.phone.sendKeys(phone);
        this.email.sendKeys(email);
    }

    public void fillUserInformation(String username, String password, String confirmPassword){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
    }

    public void clickSubmit(){
        this.submit.click();
    }
}
