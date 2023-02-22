package PageObjects;

import BaseClass.GetIOSDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TabBar extends GetIOSDriver {
    public TabBar(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "Today")
    private WebElement todaytab;

    @iOSXCUITFindBy(accessibility = "News+")
    private WebElement newstab;

    @iOSXCUITFindBy(accessibility = "Audio")
    private WebElement audiotab;

    @iOSXCUITFindBy(accessibility = "Following")
    private WebElement followingtab;

    @iOSXCUITFindBy(accessibility = "Search")
    private WebElement searchtab;


    public void tapTodayTab() {
        todaytab.click();
    }

    public void tapNewsTab() {
        newstab.click();
    }

    public void tapAudioTab() {
        audiotab.click();
    }

    public void tapFollowingTab() {
        followingtab.click();
    }

    public void tapSearchTab() {
        searchtab.click();
    }


}
