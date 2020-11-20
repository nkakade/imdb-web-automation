package pageobjects;

import framework.base.BasePage;
import framework.driver.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by namratakakade on 11/19/20.
 */
public class WatchListPage extends BasePage {

    public WatchListPage(WebDriverUtil webDriverUtil, String host) {
        super(webDriverUtil, host, "/watchlist");
    }

    public void sortTitlesByAlphabeticalOrder() {
        Select dropdown = new Select(getWebDriverUtil().findElementByCssSelector("#lister-sort-by-options"));
        dropdown.selectByValue("ALPHA");

        //wait till data is sorted
        getWebDriverUtil().sleep(5000);
    }

    public void sortTitlesByReleaseDate() {
        Select dropdown = new Select(getWebDriverUtil().findElementByCssSelector("#lister-sort-by-options"));
        dropdown.selectByValue("RELEASE_DATE");

        //wait till data is sorted
        getWebDriverUtil().sleep(5000);
    }

    public List<String> getAllTitles() {
        ArrayList<String> results = new ArrayList<>();

        List<WebElement> webElements = getWebDriverUtil().findElementsByCssSelector(".lister-item .lister-item-header");
        for(WebElement element : webElements) {
            results.add(element.getText());
        }

        return results;
    }

}
