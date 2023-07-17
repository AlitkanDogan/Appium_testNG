package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class KiwiPage {

    TouchAction touchAction=new TouchAction<>(Driver.getAndroidDriver());
    public KiwiPage(){
        PageFactory.initElements((WebDriver)Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafir;

    public void adimGecme(int adimSayisi,int x,int y) throws InterruptedException {
        for (int i = 0; i < adimSayisi; i++) {
            touchAction.press(PointOption.point(x,y)).release().perform();;
            Thread.sleep(1000);
        }
    }
    public void kordinatTikla(int x,int y) throws InterruptedException {

            touchAction.press(PointOption.point(x,y)).release().perform();;
            Thread.sleep(1000);

    }

}
