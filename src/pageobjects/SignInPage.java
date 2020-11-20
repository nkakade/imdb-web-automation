package pageobjects;

import framework.base.BasePage;
import framework.driver.WebDriverUtil;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage {

    public SignInPage(WebDriverUtil webDriverUtil, String host) {
        super(webDriverUtil, host, "/registration/signin");
    }

    public void clickOnCreateNewAccount() {
        clickOnElement(".create-account");
    }

    public void clickOnSignInWithIMDB() {
        clickOnElement(".list-group .imdb-logo");
    }

    public void enterEmail(String email) {
        enterTextInField("#ap_email", email);
    }

    public void enterPassword(String password) {
        enterTextInField("#ap_password", password);
    }


    public void clickOnSignInButton() {
        clickOnElement("#signInSubmit");
    }

}
