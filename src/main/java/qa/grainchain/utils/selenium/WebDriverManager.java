package qa.grainchain.utils.selenium;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    public static WebDriver getWebDriver(String browserName) {
        return DriverFactory.getWebDriver(browserName);
    }
}
