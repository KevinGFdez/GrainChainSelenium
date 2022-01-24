package qa.grainchain.utils.reports;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class AllureReportManager {


    public static void attachTextToReport(String name, String text){
        Allure.addAttachment(name,text);
    }
    public static void attachScreenshotToReport(String name,ByteArrayInputStream screenshot){
        Allure.addAttachment(name,screenshot);
    }
}
