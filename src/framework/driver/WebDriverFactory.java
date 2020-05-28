package framework.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public static WebDriverUtil getWebDriverUtil(String browserType) throws Exception {
        WebDriver webDriver = null;
        WebDriverUtil webDriverUtil = null;

        switch (browserType) {
            case "chrome":
                webDriver = WebDriverFactory.createChrome();
                break;
            default:
                throw new Exception(browserType + " is an invalid browser type");
        }

        webDriverUtil = new WebDriverUtil(webDriver);
        webDriverUtil.maximize();

        return webDriverUtil;
    }

    public static WebDriver createChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platform", Platform.MAC);
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");
        return new ChromeDriver(chromeOptions);
    }

}
