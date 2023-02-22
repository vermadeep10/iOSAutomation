package PageObjects;

import BaseClass.GetIOSDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Alert extends GetIOSDriver {
    public Alert(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Story Unavailable\"`]")
    private WebElement alerttext;

    @iOSXCUITFindBy(accessibility = "This story isn’t currently available in your region.")
    private WebElement alertdesctext;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement okbutton;

    public String getAlertText() {
        return alerttext.getText();
    }

    public String getAlertDescText() {
        return alertdesctext.getText();
    }

    public void tapOkButton() {
        okbutton.click();
    }


}
