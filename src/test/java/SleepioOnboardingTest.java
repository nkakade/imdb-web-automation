package test.java;

import framework.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.GetStartedPage;
import pageobjects.HowLongSleepProblemPage;
import pageobjects.HowToImproveSleepPage;

public class SleepioOnboardingTest extends BaseTest {

    public static String HOW_TO_IMPROVE_SLEEP_PAGE_MESSAGE = "How would you like to improve your sleep?";
    public static String GET_STARTED_PAGE_MESSAGE = "Discover your Sleep Score and how to improve it";
    public static String GENERAL_ERROR_MESSAGE = "Please answer all the questions before continuing.";
    public static String RADIO_OPTIONS_ERROR_MESSAGE = "You must select at least 1 answer";
    public static String DROPDOWN_OPTION_3_6_MONTHS = "3-6 months";

    @Test(groups = "first_question")
    public void testOnboarding_clickOnGetStarted_CanSeeFirstQuestion() {
        GetStartedPage getStartedPage = new GetStartedPage(getWebDriverUtil(), getHost());
        getStartedPage.loadPage();

        //verify that we are on Get Started page
        Assert.assertEquals(getStartedPage.getPageMessage(), GET_STARTED_PAGE_MESSAGE,
                "verify correct message is shown to the user on get started page");

        //click on Get Started Button
        getStartedPage.clickOnGetStartedButton();

        //wait for 2 seconds for the next question to load
        getWebDriverUtil().sleep(2000);

        HowToImproveSleepPage howToImproveSleepPage = new HowToImproveSleepPage(getWebDriverUtil(), getHost());

        //verify that we are on How would you like to Improve Sleep question
        Assert.assertEquals(howToImproveSleepPage.getPageMessage(), HOW_TO_IMPROVE_SLEEP_PAGE_MESSAGE,
                "verify correct question is shown after user clicks on Continue button");
    }


    @Test(dependsOnMethods = "testOnboarding_clickOnGetStarted_CanSeeFirstQuestion", groups = "first_question")
    public void testOnboarding_clickOnContinueWithoutMakingASelection_canSeeAGenericErrorMessage() {
        HowToImproveSleepPage howToImproveSleepPage = new HowToImproveSleepPage(getWebDriverUtil(), getHost());
        howToImproveSleepPage.clickOnContinueButton();

        //verify radio option error message is present
        Assert.assertEquals(howToImproveSleepPage.getRadioOptionsErrorMessage(), RADIO_OPTIONS_ERROR_MESSAGE,
                "verify correct error message is shown to the user");

        //verify general error message is present
        Assert.assertEquals(howToImproveSleepPage.getGeneralErrorMessage(), GENERAL_ERROR_MESSAGE,
                "verify correct error message is shown to the user");
    }

    @Test(dependsOnMethods = "testOnboarding_clickOnGetStarted_CanSeeFirstQuestion", groups = "first_question")
    public void testOnboarding_clickOnMultipleOptionsOnMultiSelectQuestion_multipleOptionsAreSelected() {
        HowToImproveSleepPage howToImproveSleepPage = new HowToImproveSleepPage(getWebDriverUtil(), getHost());

        //select multiple options
        howToImproveSleepPage.clickOnOptionWithId("0");
        howToImproveSleepPage.clickOnOptionWithId("1");
        howToImproveSleepPage.clickOnOptionWithId("2");
        howToImproveSleepPage.clickOnOptionWithId("3");

        //verify 4 options are selected
        Assert.assertEquals(howToImproveSleepPage.getNumberOfOptionsSelected(), 4,
                "verify 4 options are selected");
    }

    @Test(dependsOnMethods = "testOnboarding_clickOnGetStarted_CanSeeFirstQuestion", groups = "first_question")
    public void testOnboarding_clickOnNoneOfTheAbove_allAboveSelectionsAreCleared() {
        HowToImproveSleepPage howToImproveSleepPage = new HowToImproveSleepPage(getWebDriverUtil(), getHost());

        //select multiple options
        howToImproveSleepPage.clickOnOptionWithId("0");
        howToImproveSleepPage.clickOnOptionWithId("1");
        howToImproveSleepPage.clickOnOptionWithId("2");
        howToImproveSleepPage.clickOnOptionWithId("3");

        //After selecting none of the above option, all above selections should be cleared
        howToImproveSleepPage.clickOnOptionWithId("none-of-the-above");

        //verify 4 options are selected
        Assert.assertEquals(howToImproveSleepPage.getNumberOfOptionsSelected(), 1,
                "verify only 1 option is selected");
    }

    @Test(groups = "second_question", dependsOnGroups = "first_question")
    public void testOnboarding_selectOptionFromDropdown_anOptionIsSelected() {

        HowToImproveSleepPage howToImproveSleepPage = new HowToImproveSleepPage(getWebDriverUtil(), getHost());
        howToImproveSleepPage.clickOnOptionWithId("1");
        howToImproveSleepPage.clickOnContinueButton();

        // We should be on second question with drop down now
        HowLongSleepProblemPage howLongSleepProblemPage = new HowLongSleepProblemPage(getWebDriverUtil(), getHost());
        howLongSleepProblemPage.selectDropdownOptionByValue("4");

        //verify that an option is selected
        Assert.assertEquals(howLongSleepProblemPage.getSelectedOptionText(), DROPDOWN_OPTION_3_6_MONTHS,
                "verify 3 to 6 months is selected");

        howLongSleepProblemPage.clickOnContinueButton();
    }

}
