package framework.base;

import framework.driver.WebDriverUtil;

public class BaseTest {

    private WebDriverUtil webDriverUtil;
    private String host;

    public BaseTest() {
        try {
            WebDriverUtil wd = WebDriverUtil.getWebDriverUtilWithDefaultDriverSettings("chrome");
            this.setWebDriverUtil(wd);
            this.setHost("https://www.imdb.com");
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
