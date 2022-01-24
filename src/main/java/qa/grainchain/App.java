package qa.grainchain;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/shows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement searchField = driver.findElement(By.name("search"));
        searchField.sendKeys("batman");
        WebElement searchButton = driver.findElement(By.xpath("//i[text()=\"search\"]/.."));
        searchButton.click();
        /*List<WebElement> searchResultCards = driver.findElements(By.xpath("//div[@class=\"card light-blue darken-1\"]"));
        By urlButtonLocator = By.xpath(".//a[text()=\"URL\"]");
        By titleLabelLocator = By.xpath(".//span[@class=\"card-title\"]");
        WebElement url2Button = searchResultCards.get(1).findElement(urlButtonLocator);
        url2Button.click();
        driver.navigate().back();*/
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        List<WebElement> searchResultCards = driver.findElements(By.xpath("//div[@class=\"card light-blue darken-1\"]"));
        By titleLabelLocator = By.xpath(".//span[@class=\"card-title\"]");
        for(WebElement card: searchResultCards){
            actions.moveToElement(card);
            actions.release().perform();
            String cardTitle = card.findElement(titleLabelLocator).getText();
            System.out.println(cardTitle);
            if (cardTitle.equals("Batman Unlimited") ){
                System.out.println(card.getCssValue("color"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '3px solid red'", card);
                ((JavascriptExecutor) driver).executeScript("document.body.style.background = '#4a148c'");
//                ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute'",card);
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.background = '#4a148c'",card.findElement(By.xpath(".//div[@class= \"card-content white-text\"]")));
                System.out.println(card.getCssValue("color"));
                break;
            }
        }






        Thread.sleep(10000);
        driver.quit();

    }
}
