package test.search;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.grainchain.pages.base.BasePage;
import qa.grainchain.pages.home.HomePage;
import qa.grainchain.pages.serachresults.SearchResultsPage;
import test.base.BaseTest;

public class SearchTest extends BaseTest {
    @BeforeTest
    @Parameters({"browserName"})
    public void setUp(String browserName) {
        BasePage.setDriver(getWebDriver(browserName));
    }
    @Test
    @Description("TCSEARC001 Validate search flow")
    public void searchTest() throws InterruptedException {
        String textToSearch = "batman";
        String titleOfCardToChangeBackgroundColor = "Batman Unlimited";
        String newBackgroundColor = "#4a148c";

        HomePage homePage = new HomePage();
        homePage.goTo("http://localhost:3000/shows");
        homePage.enterWordToSearch(textToSearch);
        attachTextToReport("Text to search",textToSearch);
        homePage.clickSearchButton();

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickUrlLinkCardByPosition(1);
        searchResultsPage.back();
        searchResultsPage.moveToCardByTitleName(titleOfCardToChangeBackgroundColor);
        attachScreenshotToReport("Card before change color: "+titleOfCardToChangeBackgroundColor);
        searchResultsPage.changeCardContentBackgroundColorByTitle(titleOfCardToChangeBackgroundColor,newBackgroundColor);
        attachScreenshotToReport("Card after change color: "+titleOfCardToChangeBackgroundColor);
        searchResultsPage.clickBackButton();

        String textFoundOnTheSearchInput = homePage.getSearchFieldText();
        attachScreenshotToReport("Text found on the search field");
        Assert.assertEquals(textFoundOnTheSearchInput,"");
    }

    @AfterTest
    public void tearDown(){
        quitDriver();
    }
}
