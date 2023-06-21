package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase01;

import java.awt.*;
import java.util.Arrays;
import java.util.Set;

public class C01_Wiederholung extends TestBase01 {

    /**
     // 'https://www.n11.com' adresine gidin
     // arama motoruna 'Oppo' yazıp aratın
     // ilk ürüne tıklayın
     //Ikinci Sayfa title inin Türkiye icerdigini test edin.
     // ilk sayfaya donun ve Title'ını yazdırın
     // ilk sayfaya gidin ve sonuc yazisini ve sonus sayisini yazdirin.
     // ikinci sayfaya gidin ve kapatin.
     */

    @Test
    public void windowHandles() {
        // 'https://www.n11.com' adresine gidin
        driver.navigate().to("https://www.n11.com");

        String sayfa1Title = driver.getTitle();
        System.out.println("SAYFA1TITLE: " + sayfa1Title);

        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLES : " + sayfa1Handle);

        bekle(2);

        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo" + Keys.ENTER);

        bekle(2);

        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
        ilkUrun.click();

        bekle(2);

        /**
        Tikladiktan sonra otomatik olarak kendisi yeni bir sekme acar bu sebeple bizim windowHandles degerlerini
        almamiz ve sayfalar arasinda gecisler yapmaliyiz.
         */
        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println("Tüm Window Handle Degerleri : " + windowHandleSeti);

        String sayfa2Handle="";

        for (String each:windowHandleSeti) {
            if(!each.equals(sayfa1Handle)){
                sayfa2Handle = each;
            }
        }
        System.out.println("SAYFA2HANDLE: " + sayfa2Handle);

        driver.switchTo().window(sayfa2Handle);

        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin
        String ikinciSayfaTitle = driver.getTitle();
        System.out.println("Sayfa 2 Title : " + ikinciSayfaTitle);
        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));

        bekle(2);

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);

        String  ilkSayfaTitle = driver.getTitle();
        System.out.println("İLK SAYFA TİTLE: " + ilkSayfaTitle);


        // ilk sayfaya gidin ve sonuc yazisini ve sonus sayisini yazdirin.
        WebElement resulText = driver.findElement(By.xpath("//div[@class='resultText ']"));
        System.out.println("Sonuc Yazisi : " + resulText.getText());

        String [] resultNumber = resulText.getText().split(" ");
        System.out.println("Sonuc Sayisi : " + resultNumber[2]);


        // ikinci sayfaya gidin ve kapatin.
        driver.switchTo().window(sayfa2Handle);




    }
}
