package pageobjects;

import framework.base.BasePage;
import framework.driver.WebDriverUtil;
import org.openqa.selenium.WebElement;

/**
 * Created by namratakakade on 11/19/20.
 */
public class RegisterAccountPage extends BasePage {

    public RegisterAccountPage(WebDriverUtil webDriverUtil, String host) {
        super(webDriverUtil, host, "/ap/register");
    }

    public void enterName(String name) {
        enterTextInField("#ap_customer_name", name);
    }

    public void enterEmail(String email) {
        enterTextInField("#ap_email", email);
    }

    public void enterPassword(String password) {
        enterTextInField("#ap_password", password);
    }

    public void enterPasswordCheck(String passwordCheck) {
        enterTextInField("#ap_password_check", passwordCheck);
    }

    public void clickOnCreateImdbAccountButton() {
        clickOnElement(".a-button-primary #continue");
    }




}
