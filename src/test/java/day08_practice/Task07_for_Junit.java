package day08_practice;

import org.bouncycastle.util.io.pem.PemReader;
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
        WebElement gelbButton = driver.findElement(By.xpath("//div[@id='green']"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(gelbButton).sendKeys(Keys.RIGHT).perform();


    }
}
