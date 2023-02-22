package BaseClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class GetIOSDriver {

    public static IOSDriver driver;

    @BeforeClass
    public void getIOSDriver() throws MalformedURLException {

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14");
        options.setCapability("appium:appWaitForLaunch", true);
        options.setPlatformVersion("16.2");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        Map<String, String> params = new HashMap<String, String>();
        params.put("bundleId", "com.apple.news");
        driver.executeScript("mobile:launchApp", params);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
