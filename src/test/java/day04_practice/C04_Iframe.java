package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase01;


public class C04_Iframe extends TestBase01 {

    /**
    // https://html.com/tags/iframe sayfasına gidiniz
// Videoyu görecek kadar asagiya ininiz
// Videoyu izlemek icin Play tusuna basiniz
// Videoyu calistirdiginizi test ediniz
// 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
     */

    @Test
    public void iframe() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);    /** Sayfayi asagiya veya yukariya kaydirmak icin Actions gereklidir. */
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        // iframe handle etmeliyiz.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);  /** Iframe handle etmeliyiz cünkü video baska bir ic ice web sitesinde */

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement spielButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        spielButton.click();
        bekle(2);

        /**
          Play'i dogru locate edip click yapmamiza ragmen video calismadi. Bunun üzerine biz HTML kodlarini
          inceleyince Play'in aslinda "iframe" icinde oldugunu gördük.
          Bu durumda önce iframe'i locate edip switchTo() ile iframe'e gecmeliyiz.
         */

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed()); //play gözükmüyorsa calismaya baslamis demektir

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame(); /** Distaki Web Sayfasina gecis yapmis oluruz. */
        WebElement poweredYazisi = driver.findElement(By.xpath("//span[text()='Powerful, but easy to misuse']"));
        Assert.assertTrue(poweredYazisi.isDisplayed());

    }
}
