package framework.base;

import framework.driver.WebDriverUtil;

public abstract class BaseTest {

    private String host;
    private WebDriverUtil webDriverUtil;

    public BaseTest() {
        try {
            WebDriverUtil wd = WebDriverUtil.getWebDriverUtilWithDefaultDriverSettings("chrome");
            this.setWebDriverUtil(wd);
            this.setHost("https://onboarding.sleepio.com/sleepio/big-health");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHost(String host) {

        this.host = host;
    }

    public void setWebDriverUtil(WebDriverUtil webDriverUtil) {

        this.webDriverUtil = webDriverUtil;
    }

    public String getHost() {

        return host;
    }

    public WebDriverUtil getWebDriverUtil() {
        return webDriverUtil;
    }



}

