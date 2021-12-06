package webPagesTest;

import base.BaseTest;
import constants.FrameworkConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import webPages.WalletHubReviewPage;
import webPages.WalletHubSignInPage;
import webPages.WalletHubSubmitReviewPage;

public class WalletHubTest extends BaseTest {

    String email = "sritajpatel@outlook.com";
    String password = "Sritaj1990#";
    String[] userName = email.split("@");
    String reviewComment = Math.random() + " and Health insurance policy is an agreement whereby an insurance company agrees to undertake a guarantee to compensate the insured for medical expenses in case of a medical emergency. A health insurance policy protects the insured for several surgical expenses, critical illnesses, and daycare expenses, for a policy term, for up to the sum insured limit.";
    String[] reviewCommentBreakup = reviewComment.split(" ");

    @Test(enabled = false)
    public void submitReviewOnHealthPolicy() {
        WalletHubSignInPage whSingIn = new WalletHubSignInPage();
        WalletHubReviewPage whReview = new WalletHubReviewPage();
        WalletHubSubmitReviewPage whSubmitReview = new WalletHubSubmitReviewPage();
        whReview.scrollToRatingBox();
        whReview.selectARating(5);
        whSubmitReview.clickOnInsuranceType();
        whSubmitReview.setSelectHealthInsurance();
        whSubmitReview.writeReview(reviewComment);
        whSubmitReview.clickSubmitButton();
        whSubmitReview.waitForProgressIndicatorToVanish();
        whSingIn.waitForPageLoad();
        whSingIn.login(email, password);
        whReview.waitForPageToLoad();
        String actualComment = whReview.verifyUserComment(userName[0], reviewCommentBreakup[0]);
        Assert.assertEquals(actualComment, reviewComment, "Verify user comment");
    }

}
