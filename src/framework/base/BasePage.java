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

    public void enterTextInField(String selector, String value) {

        WebElement webElement = getWebDriverUtil().findElementByCssSelector(selector);

        //If I had a logger in this project, I would use it to log messages this these
        System.out.println("Trying to enter " + value + " in field with selector: " + selector);

        webElement.sendKeys(value);
    }

    public void clickOnElement(String selector) {

        WebElement webElement = getWebDriverUtil().findElementByCssSelector(selector);

        //If I had a logger in this project, I would use it to log messages this these
        System.out.println("Clicking element with selector: " + selector);

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
