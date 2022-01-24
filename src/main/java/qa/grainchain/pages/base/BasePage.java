package qa.grainchain.pages.base;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BasePage {
    static WebDriver driver;

    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    public static void  setDriver(WebDriver webDriver){
        driver = webDriver;
    }


    protected WebElement findElement(WebElement element, By locator){
        return element.findElement(locator);
    }
    protected void enter(WebElement element, String text) {
        waitToBeClickable(element);
        element.click();
        element.sendKeys(text);
    }

    protected boolean isEnabled(WebElement element){
        return element.isEnabled();
    }

    public void back(){
        driver.navigate().back();
    }

    public void goTo(String url){
        driver.get(url);
    }

    protected void changeBackgroundColor(WebElement element, String color){
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.background = '"+color+"'",element);
    }

    protected void click(WebElement element) {
        waitToBeClickable(element);
        element.click();
    }

    protected String getText(WebElement element) {
        waitToBeVisibility(element);
        return element.getText();
    }

    protected String getText(WebElement element,By locator) {
        waitToBeVisibility(element);
        return element.findElement(locator).getText();
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.release().perform();

    }

    //Waits
    protected Wait getWait(){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    protected void waitToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitToBeVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }


    public static ByteArrayInputStream takeScreenshot(){
        return new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
    public static void quitDriver(){
        driver.quit();
    }
}
