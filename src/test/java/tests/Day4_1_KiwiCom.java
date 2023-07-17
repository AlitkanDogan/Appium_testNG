package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;

public class Day4_1_KiwiCom {// uygulamanin yuklendigi dogrulanir

    AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();
    KiwiPage kiwiPage=new KiwiPage();
    TouchAction touchAction=new TouchAction<>(Driver.getAndroidDriver());

// uygulamanin basariyla acildigi dogrulanir
// misafir olarak devam et e tiklanir
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
// Trip type,one way olarak secilir
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
// gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
// search butonuna tiklanir
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir


    @Test
    public void tests() throws InterruptedException {
// uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));//uygulamanın yüklendiği
        Assert.assertTrue(kiwiPage.misafir.isDisplayed());
// misafir olarak devam et e tiklanir
        kiwiPage.misafir.click();
        Thread.sleep(2000);
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir

        kiwiPage.adimGecme(3,538,1686);

// Trip type,one way olarak secilir
        kiwiPage.kordinatTikla(290,627);
        kiwiPage.kordinatTikla(592,1448);

// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
// gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
// search butonuna tiklanir
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir


    }

}
