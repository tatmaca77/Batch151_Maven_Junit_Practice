package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase01;

public class C02_ActionsDragAndDrop extends TestBase01 {

    /**
    // https://demoqa.com/droppable adresine gidiniz
// 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
// 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
     */

    @Test
    public void test01() {
        // https://demoqa.com/droppable adresine gidiniz
        driver.navigate().to("https://demoqa.com/droppable");

        Actions actions = new Actions(driver);  /** Mouse islemi yapacagimiz icin sürükle birak, Actions gereklidir. */

        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(drag,drop).perform();

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        WebElement text = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String actualText = text.getText();
        String expectedText = "Dropped!";
        Assert.assertEquals(expectedText,actualText );

        /**
           dragAndDrop() ==> sürükle birak.
         */
    }
}
