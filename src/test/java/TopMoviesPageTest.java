package test.java;

import framework.base.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;
import pageobjects.IMDBTopMoviesPage;
import pageobjects.SignInPage;
import pageobjects.WatchListPage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by namratakakade on 11/19/20.
 */
public class TopMoviesPageTest extends BaseTest {


    private static final String TEST_EMAIL = "kakadenamrata88@gmail.com";
    private static final String TEST_PASSWORD = "testacct123";

    private static String[] top5Movies = new String[] {"The Shawshank Redemption", "The Godfather", "The Godfather: Part II", "The Dark Knight", "12 Angry Men" };

    private static final List<String> TOP_5_MOVIES_LIST = Arrays.asList(top5Movies);

    @Test
    public void signedOutUser_verifyTopMoviesPageLoadsverifySuccessfulSignIn() {

        //Use method to logout
        IMDBTopMoviesPage topMoviesPage = new IMDBTopMoviesPage(getWebDriverUtil(), getHost());
        topMoviesPage.loadPage();

        //verify that we are on top movies page
        Assert.assertTrue("250 items are present in the list", getWebDriverUtil().findElementsByCssSelector(".lister-list tr").size() == 250);

    }

    @Test
    public void signedInUser_verifyTopMoviesPageLoadsverifySuccessfulSignIn() {
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

        IMDBTopMoviesPage topMoviesPage = new IMDBTopMoviesPage(getWebDriverUtil(), getHost());
        topMoviesPage.loadPage();

        //verify that we are on top movies page
        Assert.assertTrue("250 items are present in the list", getWebDriverUtil().findElementsByCssSelector(".lister-list tr").size() == 250);

    }

    @Test()
    public void verifyTop5MoviesInTop250List() {
        IMDBTopMoviesPage topMoviesPage = new IMDBTopMoviesPage(getWebDriverUtil(), getHost());
        topMoviesPage.loadPage();

        List<String> titles = topMoviesPage.getTopNTitles(5);
        Assert.assertTrue("Verify top 5 movies", TOP_5_MOVIES_LIST.equals(titles));
    }


}
