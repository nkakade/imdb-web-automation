package pageobjects;

import framework.base.BasePage;
import framework.driver.WebDriverUtil;
import org.openqa.selenium.WebElement;

public class GetStartedPage extends BasePage {

    public GetStartedPage(WebDriverUtil webDriverUtil, String host) {
        super(webDriverUtil, host, "");
    }

    public String getPageMessage() {
        WebElement webElement = getWebDriverUtil().findElementByCssSelector(".landing-page h1");
        if(webElement != null) {
            return webElement.getText();
        }

        return "";
    }

    public void clickOnGetStartedButton() {
        WebElement webElement = getWebDriverUtil().findElementByCssSelector(".landing-page input.sl-button");
        webElement.click();

    }
}
