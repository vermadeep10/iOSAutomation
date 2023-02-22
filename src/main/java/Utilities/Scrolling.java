package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
                        "left", 540, "top", 1104, "width", 50, "height", 600,
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

}


