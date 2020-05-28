package test.java;

import framework.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.GetStartedPage;
import pageobjects.HowLongSleepProblemPage;
import pageobjects.HowToImproveSleepPage;
import pageobjects.SignUpPage;

public class SignupPageTest extends BaseTest {


    //Happy path
    @Test()
    public void verifySuccessfulSignUpWithValidCredentials() {
        SignUpPage signUpPage = new SignUpPage(getWebDriverUtil(), getHost());
        signUpPage.loadPage();

        signUpPage.enterFirstName("Namrata");
        signUpPage.enterLastName("Kakade");
        signUpPage.enterEmailAddress("kakade.namrata@mailinator.com");
        signUpPage.enterValidPassword("abc##");

    }

    @Test()
    public void verifySuccessfulSignUpWithInvalidFirstName() {

    }

    @Test()
    public void verifySuccessfulSignUpWithInvalidLastName() {

    }

        @Test()
    public void verifySuccessfulSignUpWithInvalidPassword() {
    }

    @Test()
    public void verifySuccessfulSignUpWithInvalidUsernamePassword() {


    }
}