package pageobjects;
import framework.base.BasePage;
import framework.driver.WebDriverUtil;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HowToImproveSleepPage extends BasePage {

    public HowToImproveSleepPage(WebDriverUtil webDriverUtil, String host) {
        super(webDriverUtil, host, "#2/1");
    }

    public String getPageMessage() {
        WebElement webElement = getWebDriverUtil().findElementByCssSelector(".sl-page-title");
        if(webElement != null) {
            return webElement.getText();
        }

        return "";
    }

    public void clickOnOptionWithId(String id) {
        //Click on option number that is passed in
        WebElement webElement = getWebDriverUtil().findElementById("options-id-" + id);
        webElement.click();
    }

    public int getNumberOfOptionsSelected() {
        //return the number of options selected in multi select question
        List<WebElement> webElements = getWebDriverUtil().findElementsByClassName("sl-option-row--checked");
        if(webElements != null) {
            return webElements.size();
        }

        return 0;
    }
}
