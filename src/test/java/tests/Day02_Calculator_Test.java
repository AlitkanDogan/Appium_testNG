package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Day02_Calculator_Test {

    AndroidDriver<AndroidElement> driver;

    @Test
    public void test() throws MalformedURLException {
        // kullanici gerekli kurulumlari yapar
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // eğer kullandığımız 6 veya üstüyse Uiautomator2 kullanılır
        //capabilities.setCapability(MobileCapabilityType.APP, "D:\\TEAM113\\APPIUM-T113.git\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");
        //capabilities.setCapability("appPackage","com.google.android.calculator");
        //uygulamayyı yüklemek iöçin kullanırız. eğer uygulama yklü ise açılır.

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //driver.sendSMS("5555555555","selam t113");

        driver.activateApp("com.google.android.calculator");


        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

        // uygulamanin acildigini dogrular
        AndroidElement acButton=driver.findElementByAccessibilityId("clear");
        Assert.assertTrue(acButton.isDisplayed());
        // carpma,bolme,toplama,cikarma islemleri yaparak sonuclari dogrular

        driver.findElementByAccessibilityId("8").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("equals").click();

        String expectedString=driver.findElementById("com.google.android.calculator:id/result_final").getText();
        int expectedResult=Integer.parseInt(expectedString);
        int actualResult= 1600;

        Assert.assertEquals(expectedResult,actualResult);

        // AC butonuna tiklayarak ana ekrani temizler


    }


}
