package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase01;

public class C01_DropDownMenu extends TestBase01 {


    /**
        // https://www.amazon.com/ sayfasina gidin
       // dropdown'dan "Books" secenegini secin
       // arama cubuguna "Java" aratın
       // arama sonuclarinin Java icerdigini test edin
     */

    @Test
    public void amazon() {
        // https://www.amazon.com/ sayfasina gidin
       driver.navigate().to("https://www.amazon.com/");

        // dropdown'dan "Books" secenegini secin
        /**
           DropDown 3 Adim'da Handle edilir:
         */
        /** 1- DropDown Locate edilmelidir.    Tag genelde "select"dir. */
        WebElement ddm =driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        /** 2- Select Objesi olusturulur. */
        //Select select = new Select(ddm);
        /** 3- Option'lardan bir tanesi secilir. */
        //select.selectByVisibleText("Bücher");
        //select.selectByIndex(5);
        //select.selectByValue("Bücher");
        selectVisibleText(ddm,"Bücher");  // TestBase icinde bu methodlar oldugu vardir.
        bekle(2);

        // arama cubuguna "Java" aratın
        WebElement suchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        suchBox.sendKeys("Java" + Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        WebElement result = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String expectedText = "Java";
        System.out.println("Sonuc Yazisi : " + result.getText());
        Assert.assertTrue(result.getText().contains(expectedText));
    }
}
