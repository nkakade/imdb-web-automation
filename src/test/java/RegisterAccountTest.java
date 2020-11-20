package test.java;

import framework.base.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;
import pageobjects.RegisterAccountPage;
import pageobjects.SignInPage;

public class RegisterAccountTest extends BaseTest {

    private static final String TEST_NAME = "John Smith " + System.currentTimeMillis();
    private static final String TEST_EMAIL = "J.S" + System.currentTimeMillis() + "@abcxyz.com";
    private static final String TEST_PASSWORD = "imdbwebaut123";

    @Test
    public void verifySuccessfulSignUpWithValidCredentials() {

        SignInPage signInPage = new SignInPage(getWebDriverUtil(), getHost());
        signInPage.loadPage();

        signInPage.clickOnCreateNewAccount();
        RegisterAccountPage registerAccountPage = new RegisterAccountPage(getWebDriverUtil(), getHost());

        //verify we are on register account page
        Assert.assertTrue("Verify we are on register account page", getWebDriverUtil().getCurrentUrl().contains(registerAccountPage.getUrl()));

        registerAccountPage.enterName(TEST_NAME);
        registerAccountPage.enterEmail(TEST_EMAIL);
        registerAccountPage.enterPassword(TEST_PASSWORD);
        registerAccountPage.enterPasswordCheck(TEST_PASSWORD);

        registerAccountPage.clickOnCreateImdbAccountButton();
        //I got Captcha and One Time Password prompts when trying to create account

    }

    @Test
    public void verifyErrorMessageWhenNameFieldIsEmpty() {
        //enter test logic here
    }

    @Test
    public void verifyErrorMessageWhenEmailFieldIsEmpty() {
        //enter test logic here
    }

    @Test
    public void verifyErrorMessageWhenInvalidEmailIsEntered() {
        //enter test logic here
    }

    @Test
    public void verifyErrorMessageWhenInvalidPasswordIsEntered() {
        //enter test logic here
    }

    @Test
    public void verifyErrorMessageWhenPasswordFieldsDontMatch() {
        //enter test logic here
    }

}