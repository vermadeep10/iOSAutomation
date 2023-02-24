package PageObjects;

import BaseClass.GetIOSDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AudioPage extends GetIOSDriver {
    public AudioPage(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "\uF8FFNews+\n" +
            "Audio")
    private WebElement newsheader;

    @iOSXCUITFindBy(accessibility = "Sports")
    private WebElement sportstext;


    public String getNewsHeader() {
        return newsheader.getText();
    }

    public String getSportsText() {
        return sportstext.getText();
    }

    public void tapSports() {
        sportstext.click();
    }
}
