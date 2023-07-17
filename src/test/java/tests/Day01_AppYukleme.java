package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Day01_AppYukleme {

    AndroidDriver<AndroidElement> driver;

    @Test
    public void test() throws MalformedURLException {
        // kullanici gerekli kurulumlari yapar
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // eğer kullandığımız 6 veya üstüyse Uiautomator2 kullanılır
        capabilities.setCapability(MobileCapabilityType.APP, "D:\\TEAM113\\APPIUM-T113.git\\Apps\\Kiwi.com - Book Cheap Flights_2023.14.0_Apkpure (1).apk");
        //uygulamayyı yüklemek iöçin kullanırız. eğer uygulama yklü ise açılır.

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
