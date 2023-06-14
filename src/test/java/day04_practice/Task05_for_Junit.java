package day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase01;

public class Task05_for_Junit extends TestBase01 {

    /**
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
// ikinci emojiye tıklayın
// İkinci emoji öğelerini yazdırınız
// Parent iframe e geri donun
// Formu doldurun,(Formu istediğiniz metinlerle doldurun)
// Apply button a basiniz
     */

    @Test
    public void iframe() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.navigate().to("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        WebElement emoji2 = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        emoji2.click();

        // İkinci emoji öğelerini yazdırınız
        String actualTitle = driver.getTitle();
        System.out.println("Sayfa Basligi : " + actualTitle);

        String actualUrl = driver.getCurrentUrl();
        System.out.println("Sayfa'nin URL : " + actualUrl);

        // Parent iframe e geri donun
        driver.switchTo().defaultContent();

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        WebElement text = driver.findElement(By.xpath("(//div[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded'])[1]"));
        text.sendKeys("Aktivite");

        WebElement nameOfSmile = driver.findElement(By.xpath("(//div[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded'])[2]"));
        nameOfSmile.sendKeys("Maho");

        WebElement nameOfNatur = driver.findElement(By.xpath("(//div[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded'])[3]"));
        nameOfNatur.sendKeys("Orman");

        WebElement applyButton = driver.findElement(By.xpath("//button[text()='Apply']"));
        applyButton.click();







    }
}
