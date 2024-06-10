package tests.ArabamComTestleri;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AracFiyatFiltreTesti {
    AndroidDriver<AndroidElement> driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.dogan.arabam");
        // Calisacak oldugumuz uygulamayi baslatabilmek icin kullandigimiz capability. Buraya uygulamanin kimlik bilgisini girerek uzerinde
        // calisacak oldugumuz uygulamayi baslatabiliriz
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
        // appPackage i belirledikten sonra uzerinde calisacak oldugumuz uygulamanin hangi sayfasindan baslayacagimizi belirlemis oldugumuz
        // capatiliy degeri
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void arabamTest() throws InterruptedException {

      /*
        driver.activateApp("com.dogan.arabam");
        bu method uygulamanin ilk acilir penceresinden baslar
       */
        // 1. yol olarak uygulamanin kimlik bilgisi uzerinden uygulama driver methoduyla aktif hale getirilebilir.
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementByAccessibilityId("İlan Ver").isDisplayed());
        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();
        // kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();
        Thread.sleep(3000);
        // arac olarak Audi secilir
        driver.findElementByXPath("//*[@text='Audi']").click();
        // arac markasi olarak A6 secilir
        driver.findElementByXPath("//*[@text='A6']").click();
        // Tümü seçeneği secilir
        driver.findElementByXPath("//*[@text='A6 Sedan']").click();
        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Tümü']").click();
        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementById("com.dogan.arabam:id/textViewSorting").click();
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        // Gelen en ucuz aracin 200.000 tl den buyuk oldugu dogrulanir
        String enUcuzAracFiyati = driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]").getText();
        System.out.println(enUcuzAracFiyati); // 250000
        enUcuzAracFiyati = enUcuzAracFiyati.replaceAll("\\D", "");
        System.out.println(enUcuzAracFiyati); // 250000
        Assert.assertTrue(Integer.parseInt(enUcuzAracFiyati) > 200000);
    }
}

