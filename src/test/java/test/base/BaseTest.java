package test.base;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import qa.grainchain.pages.base.BasePage;
import qa.grainchain.utils.reports.AllureReportManager;
import qa.grainchain.utils.selenium.WebDriverManager;

import java.io.ByteArrayInputStream;

public class BaseTest {

    public static WebDriver getWebDriver(String browserName) {
        return WebDriverManager.getWebDriver(browserName);
    }

    public static void quitDriver(){
        BasePage.quitDriver();
    }

    public static ByteArrayInputStream takeScreenshot(){
        return BasePage.takeScreenshot();
    }


    //Allure
    public static void attachTextToReport(String name, String text){
        AllureReportManager.attachTextToReport(name, text);
    }
    public static void attachScreenshotToReport(String name){
        AllureReportManager.attachScreenshotToReport(name,takeScreenshot());
    }

}
