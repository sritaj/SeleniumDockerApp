package webPages;

import driver.DriverManager;
import helper.DropDownHelper;
import helper.ElementHelper;
import helper.WaitHelper;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected ElementHelper elementHelper;
    protected WaitHelper waitHelper;
    protected DropDownHelper ddHelper;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
        this.elementHelper = new ElementHelper();
        this.waitHelper = new WaitHelper();
        this.ddHelper = new DropDownHelper();
    }
}
