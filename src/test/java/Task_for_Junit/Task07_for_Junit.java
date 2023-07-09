package Task_for_Junit;

import org.bouncycastle.util.io.pem.PemReader;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase01;

public class Task07_for_Junit extends TestBase01 {


    /**
    -https://jqueryui.com/slider/#colorpicker adrese gidiniz
-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
-Sarı olduğunu test edelim
     */

    @Test
    public void test01() {
        //  -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.navigate().to("https://jqueryui.com/slider/#colorpicker");


        // -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız

        /** ( Kutucuklar "iframe" icerisindedir ) */
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        WebElement gelbButton = driver.findElement(By.cssSelector("div#green>span"));
        bekle(2);

        Actions actions = new Actions(driver);  // Mouse hareketleri icin "Action" Classtan Object olusturulmalidir.

        // Önce kirmizi yapiyoruz.
        actions.moveToElement(gelbButton).clickAndHold(gelbButton).sendKeys(Keys.HOME).release().perform();

        // Sonra Sari yapiyoruz.
        actions.moveToElement(gelbButton).clickAndHold(gelbButton).sendKeys(Keys.END).release().perform();


        // -Sarı olduğunu test edelim
        WebElement gelbBox = driver.findElement(By.xpath("//div[@style='background-color: rgb(255, 255, 60);']"));
        Assert.assertTrue(gelbBox.isDisplayed());

        driver.switchTo().defaultContent(); // "iframe" icinde ana sayfasaya cikmis oluruz...!!!

        // Iframe'den ciktiktan sonra Anasayfa üzerinde bir yazi testi yaptik.
        WebElement title = driver.findElement(By.xpath("//h1[text()='Slider']"));
        Assert.assertEquals("Slider", title.getText());


    }
}
