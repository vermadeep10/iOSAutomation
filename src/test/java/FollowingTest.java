import BaseClass.GetIOSDriver;
import PageObjects.Alert;
import PageObjects.FollowingPage;
import PageObjects.TabBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class FollowingTest extends GetIOSDriver {
    TabBar tab;
    FollowingPage follow;
    Alert alert;

    @BeforeMethod
    public void setup() {
        tab = new TabBar(driver);
        follow = new FollowingPage(driver);
        alert = new Alert(driver);
        tab.tapFollowingTab();
    }

    @Test
    public void goToFollowingTab() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertEquals(follow.getFollowingText(), "Following");
        Assert.assertEquals(follow.getSpecialCoveragSectionText(), "Special Coverage");
        follow.tapBlackHistoryMonth();
        Assert.assertEquals(alert.getAlertText(), "Story Unavailable");
        Assert.assertEquals(alert.getAlertDescText(), "This story isn’t currently available in your region.");
        alert.tapOkButton();
        Assert.assertEquals(follow.getFollowingText(), "Following");
    }

}
