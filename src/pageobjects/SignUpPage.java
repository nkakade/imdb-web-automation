package pageobjects;

import framework.base.BasePage;
import framework.driver.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage {


    public SignUpPage(WebDriverUtil webDriverUtil, String host) {
        super(webDriverUtil, host, "#2/16");
    }

    public void enterFirstName(String firstName) {
        WebElement webElement = getWebDriverUtil().findElement(By.id("first_name"));
        webElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement webElement = getWebDriverUtil().findElement(By.id("last_name"));
        webElement.sendKeys(lastName);
    }

    public void enterEmailAddress(String emailAddress){
        WebElement webElement = getWebDriverUtil().findElement(By.id("email"));
        webElement.sendKeys(emailAddress);
    }

    public void enterValidPassword(String validPassword){
        WebElement webElement = getWebDriverUtil().findElement(By.id(""));
        webElement.sendKeys(validPassword);
    }

}
