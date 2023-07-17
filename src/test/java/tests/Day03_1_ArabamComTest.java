package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Day03_1_ArabamComTest {

    // Arabam kac para bolumune tiklayalim
    // Aracimin fiyatini merak ediyorum bolumunetiklayalim
    // Wolkswagen markasini secelim
    // yil secimi yapalim
    // model secimi yapalim
    // govde tipini secelim
    // yakit tipini secelim
    // vites tipini secelim
    // Versiyon secimi yapalim
    // aracin km bilgilerini girelim
    // aracin rengini secelim
    // opsiyel donanim (varsa) seecelim
    // degisen bilgisi ekleyerek tramer kaydi belirtelim
    // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
    // uygulamayi kapatalim

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // eğer kullandığımız 6 veya üstüyse Uiautomator2 kullanılır
        // capabilities.setCapability(MobileCapabilityType.APP, "D:\\TEAM113\\APPIUM-T113.git\\Apps\\arabam.com_4.8.0_Apkpure.apk");
        //uygulamayyı yüklemek iöçin kullanırız. eğer uygulama yklü ise açılır.
        capabilities.setCapability("appPackage", "com.dogan.arabam");
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest() throws InterruptedException {
        // uygulamanın başarılı bir şekilde yüklendiği doğrulanır.
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        // uygulamanın başarılı bir şekilde açıldığı doğrulanır.;
        AndroidElement arabamLogo = driver.findElementById("com.dogan.arabam:id/ivArabamLogo");
        Assert.assertTrue(arabamLogo.isDisplayed());

        // Arabam kac para bolumune tiklayalim
        AndroidElement arabamKacPara = driver.findElementByXPath("//*[@text='Arabam kaç para?']");
        arabamKacPara.click();
        // Aracimin fiyatini merak ediyorum bolumune tiklayalim
        AndroidElement araciminFiyatiniMerakEdiyorum = driver.findElement(By.xpath("//*[@text='Aracımın fiyatını merak ediyorum']"));
        araciminFiyatiniMerakEdiyorum.click();
        // Wolkswagen markasini secelim

        TouchAction touchAction = new TouchAction<>(driver);
        touchAction
                .press(PointOption.point(500, 1700))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(500, 400))
                .release().perform();

        Thread.sleep(1000);

        driver.findElementByXPath("//*[@text='Volkswagen']").click();


        // yil secimi yapalim
        driver.findElementByXPath("//*[@text='2018']").click();
        // model secimi yapalim
        driver.findElementByXPath("//*[@text='Jetta']").click();
        // govde tipini secelim
        driver.findElementByXPath("//*[@text='Sedan']").click();
        // yakit tipini secelim
        driver.findElementByXPath("//*[@text='Benzin']").click();
        // vites tipini secelim
        driver.findElementByXPath("//*[@text='Yarı Otomatik']").click();
        // Versiyon secimi yapalim


        Thread.sleep(1000);
        driver.findElementByXPath("//*[@bounds='[97,592][796,643]']").click();
        Thread.sleep(1000);

        // aracin km bilgilerini girelim
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("50000");
        } else {
            driver.findElementById("com.dogan.arabam:id/et_km").sendKeys("100000");
        }

        driver.findElementById("com.dogan.arabam:id/btn_price_prediction_submit").click();

        // aracin rengini secelim
        driver.findElementByXPath("//*[@text='Beyaz']").click();

        // opsiyel donanim (varsa) seecelim
        driver.findElementByXPath("//*[@text='Elektrikli Cam Tavan']").click();
        driver.findElementByXPath("//*[@text='Devam']").click();

        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        driver.findElementById("com.dogan.arabam:id/iv_B01201").click();
        driver.findElementByXPath("//*[@text='Değişmiş']").click();
        driver.findElementByXPath("//*[@text='Devam']").click();
        driver.findElementByXPath("//*[@text='Tramer kaydı yok']").click();
        driver.findElementByXPath("//*[@text='Devam']").click();

        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        String expectedResult = "500000";
       String actualResult = driver.findElementByXPath("//android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.TextView[2]").getText();
       actualResult=actualResult.replaceAll("\\D","");
        System.out.println(actualResult);
        Assert.assertTrue(Integer.parseInt(actualResult)>Integer.parseInt(expectedResult));

        // uygulamayi kapatalim
        driver.closeApp();


    }
}
