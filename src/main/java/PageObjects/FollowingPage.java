package PageObjects;

import BaseClass.GetIOSDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FollowingPage extends GetIOSDriver {
    public FollowingPage(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Following\"`]")
    private WebElement followingtext;

    @iOSXCUITFindBy(accessibility = "Special Coverage")
    private WebElement specialcoveragsection;

    @iOSXCUITFindBy(accessibility = "Channels & Topics")
    private WebElement channelsandtopicssection;

    @iOSXCUITFindBy(accessibility = "Suggested by Siri")
    private WebElement suggestedbysirisection;

    @iOSXCUITFindBy(accessibility = "Manage")
    private WebElement managesection;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Notifications & Email\"`]")
    private WebElement notificationandemail;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Subscriptions\"`]")
    private WebElement subscriptions;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Discover Channels\"`]")
    private WebElement discoverChannels;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Black History Month\"`][2]")
    private WebElement blackhistorymonth;

    public String getFollowingText() {

        return followingtext.getText();

    }

    public String getSpecialCoveragSectionText() {
        return specialcoveragsection.getText();
    }

    public String getChannelsAndTopicsSectionText() {
        return channelsandtopicssection.getText();
    }

    public String getSuggestedBySiriSectionText() {
        return suggestedbysirisection.getText();
    }

    public void tapSpecialCoverage() {
        specialcoveragsection.click();
    }

    public void tapBlackHistoryMonth() {
        blackhistorymonth.click();
    }




}
