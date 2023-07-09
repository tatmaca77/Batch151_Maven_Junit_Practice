package Task_for_Junit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase01;

public class Task06_for_Junit extends TestBase01 {

    /**
    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
- Çizimden sonra clear butonuna basınız
- Sayfayi kapatiniz
     */

    @Test
    public void test01() {
        // - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        Actions actions = new Actions(driver);

        // - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement ekran = driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
        actions.moveToElement(ekran).perform();
        actions.clickAndHold().
                moveByOffset(15,50).
                moveByOffset(65,85).
                moveByOffset(70,28).
                release().perform();

        // - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//button[@class='button clear']")).click();

        // - Sayfayi kapatiniz
        /**TestBase01 den Automatik kapaniyor. */


    }
}
