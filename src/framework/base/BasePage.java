package framework.base;

import framework.driver.WebDriverUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.security.InvalidParameterException;

public class BasePage {

    protected WebDriverUtil webDriverUtil = null;
    protected String host = null;
    protected String url = null;


    /**
     * Default constructor for base page
     *
     * @param webDriverUtil
     * @param host
     * @param url
     */
    public BasePage(WebDriverUtil webDriverUtil, String host, String url) {
        this.setWebDriverUtil(webDriverUtil);
        this.setHost(host);
        this.setUrl(url);
    }

    /**
     * Load the page
     *
     * @throws java.security.InvalidParameterException
     */
    public void loadPage() {
        if (getUrl() == null) {
            throw new InvalidParameterException(
                    "Url was set as null, please set url for this page if you want to navigate to it.");
        }

        getWebDriverUtil().get(getHost() + getUrl());
    }


    public String getGeneralErrorMessage() {
        WebElement webElement = getWebDriverUtil().findElementByCssSelector(".sl-general-error");
        if(webElement != null) {
            return webElement.getText();
        }

        return "";
    }

    public String getRadioOptionsErrorMessage() {
        WebElement webElement = getWebDriverUtil().findElementByCssSelector(".sl-container-radio-options--error");
        if(webElement != null) {
            return webElement.getText();
        }

        return "";
    }

    public void clickOnContinueButton() {
        //continue button is disabled when the question loads.
        // disabling the disabled attribute so we can simulate user behavior of clicking it without selecting any option
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriverUtil().getWebDriver();
        jse.executeScript("document.getElementsByClassName('sl-button--wide')[0].disabled=false");

        WebElement webElement = getWebDriverUtil().findElementByCssSelector(".sl-button-wrapper .sl-button");
        webElement.click();
    }

    public WebDriverUtil getWebDriverUtil() {
        return webDriverUtil;
    }

    public void setWebDriverUtil(WebDriverUtil webDriverUtil) {
        this.webDriverUtil = webDriverUtil;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {

        this.host = host;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }
}
