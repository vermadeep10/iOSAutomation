package TestCases;

import BaseClass.GetIOSDriver;
import PageObjects.AudioPage;
import PageObjects.TabBar;
import Utilities.Scrolling;
import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AudioTest extends GetIOSDriver {
    AudioPage audio;
    Scrolling scroll;
    TabBar tab;

    @BeforeMethod
    public void setup() {
        audio = new AudioPage(driver);
        scroll = new Scrolling(driver);
        tab = new TabBar(driver);
        tab.tapAudioTab();
    }


    @Test(priority = 1)
    public void goToSportsNews() throws InterruptedException {
        Assert.assertEquals(audio.getNewsHeader(), "\uF8FFNews+\n" +
                "Audio");
        scroll.scrollTillWebView("//XCUIElementTypeStaticText[@name=\"Sports\"]", "down");
        Assert.assertEquals(audio.getSportsText(), "Sports");
        audio.tapSports();


    }

    @Test(priority = 2)
    public static WebElement getLawText() {
        List<WebElement> el = driver.findElements(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"Section\"]"));
        for (WebElement element : el) {
            if (element.getText().contains("Law")) {
                System.out.println(el);
                return (WebElement) el;
            } else {
                System.out.println("Text Not Found");
            }
        }
        return (WebElement) el;
    }
}