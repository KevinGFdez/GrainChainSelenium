package qa.grainchain.pages.serachresults;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.grainchain.pages.base.BasePage;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//div[@class=\"card light-blue darken-1\"]")
    List<WebElement> searchResultsCards;
    By urlButtonCardLocator = By.xpath(".//a[text()=\"URL\"]");
    WebElement urlLink;
    By titleCardLocator = By.xpath(".//span[@class=\"card-title\"]");
    By contentCardLocator = By.xpath(".//div[@class= \"card-content white-text\"]");

    @FindBy(xpath = "//i[text()=\"keyboard_arrow_left\"]/..")
    WebElement backButton;


    public void clickUrlLinkCardByPosition(int position){
        this.urlLink = findElement(searchResultsCards.get(position), urlButtonCardLocator);
        click(urlLink);
    }

    public WebElement moveToCardByTitleName(String title){
        String cardTitle;
        for(WebElement card: searchResultsCards){
             cardTitle = getText(card, titleCardLocator);
             if (cardTitle.equals(title)){
                 moveToElement(card);
                 return card;
             }
        }
        return null;
    }

    public void changeCardContentBackgroundColorByTitle(String titleCard,String color){
        WebElement contentCard =findElement(moveToCardByTitleName(titleCard), contentCardLocator);
        changeBackgroundColor(contentCard,color);
    }

    public void clickBackButton(){
        click(backButton);
    }
}
