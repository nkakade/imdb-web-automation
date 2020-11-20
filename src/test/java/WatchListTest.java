package test.java;

import framework.base.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageobjects.IMDBTopMoviesPage;
import pageobjects.SignInPage;
import pageobjects.WatchListPage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by namratakakade on 11/19/20.
 */
public class WatchListTest extends BaseTest {

    private static final String TEST_EMAIL = "kakadenamrata88@gmail.com";
    private static final String TEST_PASSWORD = "testacct123";

    private static String[] alphabeticalSortedArray = new String[] {"12 Angry Men", "The Dark Knight", "The Godfather", "The Godfather: Part II", "The Shawshank Redemption" };
    private static final List<String> ALPHABETICAL_SORTED_LIST = Arrays.asList(alphabeticalSortedArray);

    private static String[] releaseDateSortedArray = new String[] {"The Dark Knight", "The Shawshank Redemption", "The Godfather: Part II", "The Godfather", "12 Angry Men" };
    private static final List<String> RELEASE_DATE_SORTED_LIST = Arrays.asList(releaseDateSortedArray);

    @Test
    public void verifySuccessfulSignIn() {
        SignInPage signInPage = new SignInPage(getWebDriverUtil(), getHost());
        signInPage.loadPage();

        //sign in using email
        signInPage.clickOnSignInWithIMDB();

        signInPage.enterEmail(TEST_EMAIL);
        signInPage.enterPassword(TEST_PASSWORD);
        signInPage.clickOnSignInButton();

        //sleep for 5 seconds for home page to load after sign-in
        getWebDriverUtil().sleep(5);

        //verify that we are on homepage
        Assert.assertTrue("Video hero slider is visible", getWebDriverUtil().findElementByClassName("video-hero").isDisplayed());

    }

    @Test(dependsOnMethods = "verifySuccessfulSignIn")
    public void verifyItemsAddedToWatchList() {

        //Go to IMDB top movies list and add items to watchlist
        IMDBTopMoviesPage imdbTopMoviesPage = new IMDBTopMoviesPage(getWebDriverUtil(), getHost());
        imdbTopMoviesPage.loadPage();


        //sleep for 5 seconds for top movies page to load
        getWebDriverUtil().sleep(5);

        imdbTopMoviesPage.addTopNMoviesToWatchList(5);


        imdbTopMoviesPage.clickOnWatchListInHeader();

        WatchListPage watchListPage = new WatchListPage(getWebDriverUtil(), getHost());
        //verify we are on watchlist page

        Assert.assertTrue("Verify we are on watchlist page", getWebDriverUtil().getCurrentUrl().contains(watchListPage.getUrl()));

        Assert.assertTrue("Verify 5 items are added to the list", watchListPage.getAllTitles().size() == 5);
    }


    @Test(dependsOnMethods = "verifyItemsAddedToWatchList")
    public void verifyAlphabeticalOrder() {
        WatchListPage watchListPage = new WatchListPage(getWebDriverUtil(), getHost());
        watchListPage.sortTitlesByAlphabeticalOrder();

        List<String> titles = watchListPage.getAllTitles();

        Assert.assertEquals("Verify alphabetical date sorted list", ALPHABETICAL_SORTED_LIST, titles);
    }


    @Test(dependsOnMethods = "verifyItemsAddedToWatchList")
    public void verifyReleaseDateOrder() {
        WatchListPage watchListPage = new WatchListPage(getWebDriverUtil(), getHost());
        watchListPage.sortTitlesByReleaseDate();

        List<String> titles = watchListPage.getAllTitles();
        Assert.assertEquals("Verify release date sorted list", RELEASE_DATE_SORTED_LIST, titles);
    }

    // similar test methods for other types of sorting on the page

    @AfterClass
    public void removeAllItemsFromWatchList() {
        IMDBTopMoviesPage imdbTopMoviesPage = new IMDBTopMoviesPage(getWebDriverUtil(), getHost());
        imdbTopMoviesPage.loadPage();


        //sleep for 5 seconds for top movies page to load
        getWebDriverUtil().sleep(5);

        imdbTopMoviesPage.removeTopNMoviesToWatchList(5);

    }


    }
