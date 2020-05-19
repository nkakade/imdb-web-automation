package framework.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverUtil {

    private WebDriver webDriver;

    private static final long DEFAULT_PAGE_TIMEOUT = 30;
    private static final long DEFAULT_IMPLICIT_TIMEOUT = 20;
    private static final long DEFAULT_SCRIPT_TIMEOUT = 20;
    private static final int WAIT_FOR_ELEMENT_TIMEOUT = 20;
    private static final long DEFAULT_AJAX_TIMEOUT = 10;
    private int pageLoadTimeout = 60;
    private static Method currentTestMethod;

    public void setBrowserType(String browserType) {

        this.browserType = browserType;
    }

    private String browserType;

    /**
     * WebDriverUtil Constructors
     */
    protected WebDriverUtil(WebDriver webDriver) {

        this.setWebDriver(webDriver);
    }

    /**
     * Create an instance of WebDriverUtil with default implicit_timeout, page_load_timeout and script_timeout
     * for a WebDriver of type "browser"
     *
     * @param browserType
     * @return
     * @throws Exception
     */
    public static WebDriverUtil getWebDriverUtilWithDefaultDriverSettings(String browserType) throws Exception {
        WebDriverUtil webDriverUtil = WebDriverFactory.getWebDriverUtil(browserType);
        webDriverUtil.setBrowserType(browserType);
        webDriverUtil.setImplicitTimeout(DEFAULT_IMPLICIT_TIMEOUT);
        return webDriverUtil;
    }


    public WebDriver getWebDriver() {

        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void maximize() {
        getWebDriver().manage().window().maximize();
    }

    public void setImplicitTimeout(long timeInSec) {

        getWebDriver().manage().timeouts()
                .implicitlyWait(timeInSec, TimeUnit.SECONDS);
    }

    public void resetImplicitTimeout() {
        getWebDriver().manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }

    public static Method getCurrentTestMethod() {
        return currentTestMethod;
    }

    public static void setCurrentTestMethod(Method currentTestMethod) {
        WebDriverUtil.currentTestMethod = currentTestMethod;
    }


    /**
     * Clicking on an element
     */
    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            try {
                element.click();
            } catch (TimeoutException ex) {
                throw ex;
            } catch (WebDriverException wde) {
                throw e;
            }
        }
    }

    /**
     * Find element by using css selector
     *
     * @param selector
     * @return a webelement
     */
    public WebElement findElementByCssSelector(String selector) {
        return findElementByCssSelector(selector, false);
    }

    public WebElement findElementByCssSelector(String selector, boolean noWait) {
        if (noWait) {
            return findElement(By.cssSelector(selector));
        } else {
            if (waitForElement(selector)) {
                return findElement(By.cssSelector(selector));
            }
            return null;
        }
    }

    /**
     * Find elements by using css selector
     *
     * @param selector
     * @return list of webelement
     */
    public List<WebElement> findElementsByCssSelector(String selector) {
        try {
            return findElements(By.cssSelector(selector));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public WebElement findElement(By by) {
        WebElement element;
        try {
            element = getWebDriver().findElement(by);
        } catch (NoSuchElementException ex) {
            element = null;
        }
        return element;
    }

    public List<WebElement> findElements(By by) {
        List<WebElement> webElements;
        try {
            webElements = getWebDriver().findElements(by);
        } catch (NoSuchElementException ex) {
            webElements = null;
        }
        return webElements;
    }

    public List<WebElement> findElementsByTag(String tag) {
        List<WebElement> webElements;
        try {
            webElements = getWebDriver().findElements(By.tagName(tag));
        } catch (NoSuchElementException ex) {
            webElements = null;
        }
        return webElements;
    }

    public WebElement findElementById(String id) {
        return findElement(By.id(id));
    }

    public WebElement findElementByClassName(String className) {
        return findElement(By.className(className));
    }

    public List<WebElement> findElementsByClassName(String className) {
        return findElements(By.className(className));
    }

    public Boolean waitForElement(String selector) {
        return waitForElement(selector, WAIT_FOR_ELEMENT_TIMEOUT);
    }

    public Boolean waitForElement(String selector, int time) {
        WebDriverWait wait = new WebDriverWait(webDriver, time);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By
                    .cssSelector(selector)));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void get(String url) {
        try {
            webDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
            webDriver.get(url);
            if (isAlertPresent()) {
                acceptAlertDialog();
            }
        } catch (Exception ex) {
            //retrying if failed first time
            webDriver.get(url);
            ex.printStackTrace();
        }
    }

    public boolean isAlertPresent() {
        try {
            webDriver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public void acceptAlertDialog() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {

        }
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

}
