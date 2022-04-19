package webPagesTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import webPages.FacebookHomePage;
import webPages.FacebookLoginPage;
import webPages.FacebookProfilePage;

public class FacebookHomeTest extends BaseTest {

    @Test(enabled = false)
    public void postStatus() {
        FacebookLoginPage fbLogin = new FacebookLoginPage();
        FacebookHomePage homePg = new FacebookHomePage();
        FacebookProfilePage profilePg = new FacebookProfilePage();
        fbLogin.login("", "");
        homePg.clickOnHomeIcon();
        String retrieveUserName = homePg.getUserDetailFromStatusBox();
        String[] userNamePortion = retrieveUserName.split(",");
        String[] userName = userNamePortion[1].trim().split("[?]");
        homePg.clickOnStatusBox();
        String postMsg = "case Study 1" + Math.random();
        homePg.postStatus(postMsg);
        homePg.clickOnUserAccountOptionInRibbonBar(userName[0]);
        profilePg.waitForProfilePageToLoad();
        boolean postPresence = profilePg.verifyPostPresence(postMsg);
        Assert.assertTrue(postPresence, "Verify user is able to post status in Facebook");
    }
}
