package PageObjects;

import BaseClass.GetIOSDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TodayPage extends GetIOSDriver {
    public TodayPage(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @iOSXCUITFindBy(accessibility = "Top Stories")
    private WebElement topstories;


}
