package qa.grainchain.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.grainchain.pages.base.BasePage;

public class HomePage extends BasePage {
    @FindBy(name = "search")
    WebElement searchField;

    @FindBy(xpath = "//i[text()=\"search\"]/..")
    WebElement searchButton;


    public void enterWordToSearch(String wordToSearch) {
        enter(searchField,wordToSearch);
    }

    public String getSearchFieldText(){
        return getText(searchField);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

}
