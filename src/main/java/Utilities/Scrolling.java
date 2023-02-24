package Utilities;

import com.google.common.collect.ImmutableMap;
import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.List;

public class Scrolling {

    private final IOSDriver driver;

    public Scrolling(IOSDriver driver) {
        this.driver = driver;
    }

    public void scrollTillElementFound(String direction) {

        switch (direction) {
            case "up":

                ((JavascriptExecutor) driver).executeScript("mobile: scroll", ImmutableMap.of(
                        "left", 540, "top", 1104, "width", 50, "height", 600,
                        "direction", "up",
                        "percent", 0.5,
                        "speed", 50000
                ));
                break;

            case "down":
                ((JavascriptExecutor) driver).executeScript("mobile: scroll", ImmutableMap.of(
                        "left", 540, "top", 1104, "width", 50, "height", 600,
                        "direction", "down",
                        "percent", 0.5,
                        "speed", 5000
                ));
                break;

            case "left":
                ((JavascriptExecutor) driver).executeScript("mobile: scroll", ImmutableMap.of(
                        "left", 540, "top", 1104, "width", 50, "height", 600,
                        "direction", "left",
                        "percent", 0.5,
                        "speed", 500
                ));
                break;

            case "right":
                ((JavascriptExecutor) driver).executeScript("mobile: scroll", ImmutableMap.of(
                        "left", 540, "top", 107, "width", 50, "height", 600,
                        "direction", "right",
                        "percent", 0.5,
                        "speed", 500
                ));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }

    }

    public List<WebElement> getItemWebView(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public void scrollTillWebView(String xpath, String direction) throws InterruptedException {
        while (getItemWebView(xpath).size() == 0) {
            scrollTillElementFound(direction);

        }
        if (getItemWebView(xpath).size() > 0) {
            getItemWebView(xpath).get(0);
        }
        Thread.sleep(4000);
    }


    public void mobileScrollElementIOS(WebElement ele, Direction dir) {
        System.out.println("mobileScrollElementIOS(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms
        final HashMap<String, String> scrollObject = new HashMap<String, String>();

        switch (dir) {
            case DOWN: // from down to up (! differs from mobile:swipe)
            case UP: // from up to down (! differs from mobile:swipe)
            case LEFT: // from left to right (! differs from mobile:swipe)
            case RIGHT: // from right to left (! differs from mobile:swipe)
                scrollObject.put("direction", dir.name().toLowerCase());
                break;
            default:
                throw new IllegalArgumentException("mobileScrollElementIOS(): dir: '" + dir + "' NOT supported");
        }
        scrollObject.put("element", ((RemoteWebElement)ele).getId());
        try {
            driver.executeScript("mobile:scroll", scrollObject); // swipe faster then scroll
            Thread.sleep(ANIMATION_TIME); // always allow swipe action to complete
        } catch (Exception e) {
            System.err.println("mobileScrollElementIOS(): FAILED\n" + e.getMessage());
            return;
        }
    }


}


