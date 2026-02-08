import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class AppTest {

    static AppiumDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        itemsRenderinFeed();
    }


    public static void itemsRenderinFeed() throws MalformedURLException, InterruptedException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appium:autoGrantPermissions", true);
        cap.setCapability("appium:platformName", "Android");
        cap.setCapability("appium:automationName", "UiAutomator2");
        cap.setCapability("appium:deviceName", "Galaxy S23");
        cap.setCapability("appium:udid", "RFCW8070RZK");
        cap.setCapability("appium:platformVersion", "16");
        cap.setCapability("appium:appPackage", "com.vitahealth.com");
        cap.setCapability("appium:appActivity", "com.vitahealth.com.MainActivity");


        // Initialize the Appium driver and launch the app
        URL url = new URL("http://127.0.0.1:4723");
        driver = new AppiumDriver(url, cap);
        Thread.sleep(500);

        //login steps into the app
        //email field
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)\n"))
                .click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)\n"))
                .sendKeys(TEST_EMAIL);
        //password field
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)\n"))
                .click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)\n"))
                .sendKeys(TEST_PASSWORD);
        //login button
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"LOGIN\")\n"))
                .click();
        Thread.sleep(5000);
        //Open feed → verify items render
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"Feed\")\n"))
                .click();
        Thread.sleep(500);
        boolean isFeedItemDisplayed = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(0)\n"))
                .isDisplayed();
        if (isFeedItemDisplayed) {
            System.out.println("Feed items are displayed successfully.");
        } else {
            System.out.println("Feed items are not displayed.");
        }



    }


}