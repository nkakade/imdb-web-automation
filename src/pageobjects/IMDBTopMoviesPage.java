package pageobjects;

import framework.base.BasePage;
import framework.driver.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IMDBTopMoviesPage extends BasePage {

    public IMDBTopMoviesPage(WebDriverUtil webDriverUtil, String host) {
        super(webDriverUtil, host, "/chart/top");
    }

    public void addTopNMoviesToWatchList(int numberOfMoviesToAdd) {

        List<WebElement> listOfRibbons = getWebDriverUtil().findElementsByCssSelector(".lister-list tr .not-inWL");

        for(int i = 0; i < numberOfMoviesToAdd; i++) {
            WebElement element = listOfRibbons.get(i);
            element.click();
        }

    }


    public void removeTopNMoviesToWatchList(int numberOfMoviesToRemove) {

        List<WebElement> listOfRibbons = getWebDriverUtil().findElementsByCssSelector(".lister-list tr .inWL");

        for(int i = 0; i < numberOfMoviesToRemove; i++) {
            WebElement element = listOfRibbons.get(i);
            element.click();
        }

    }

    public void clickOnWatchListInHeader() {
        clickOnElement(".imdb-header__watchlist-button a");
    }

    public List<String> getTopNTitles(int numerOfTitles) {
        List<String> results = new ArrayList<>();

        List<WebElement> webElements = getWebDriverUtil().findElementsByCssSelector(".lister-list .titleColumn a");
        for(int i = 0; i < numerOfTitles; i++) {
            results.add(webElements.get(i).getText());
        }

        return results;
    }

}
