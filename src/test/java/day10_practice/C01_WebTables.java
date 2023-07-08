package day10_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase01;

import java.util.List;

public class C01_WebTables extends TestBase01 {

    /**
    // girisYap methodu olusturun
// https://www.hotelmycamp.com adresine gidin
// Log in butonuna tıklayın
// Username: manager
// Password: Manager1!

// sutun sayısını yazdırın
// tum body'i yazdirin
// body'de bulunan satır sayısını yazdırın
// body'de bulunan satırları yazdırın
// 4.satırdaki elementleri yazdırın
     */

    @Test
    public void test01() {
        // girisYap methodu olusturun
        girisYap();


    }

    public void girisYap() {
        // https://www.hotelmycamp.com adresine gidin
        driver.get("https://www.hotelmycamp.com");
        bekle(1);
        driver.findElement(By.xpath("//button[@id='details-button']")).click(); // Erweitern click
        bekle(1);
        driver.findElement(By.xpath("//a[text()='Weiter zu www.hotelmycamp.com (unsicher)']")).click(); // Link
        bekle(1);

        // Log in butonuna tıklayın
        driver.findElement(By.xpath("//a[@href='/Account/Logon']")).click(); // Log In
        bekle(1);


        // Username: manager  --> Action Class ile de yapabiliriz.
        /**
         WebElement username = driver.findElement(By.id("UserName"));
         username.sendKeys("manager");
         bekle(1);
         */
        // Password: Manager1!  --> Action Class ile de yapabiliriz.
        /**
         WebElement password = driver.findElement(By.id("Password"));
         password.sendKeys("Manager1!");
         bekle(1);
         */

        Actions action = new Actions(driver);

        WebElement username = driver.findElement(By.id("UserName"));
                action.
                        click(username).
                sendKeys("manager").
                        sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                        sendKeys(Keys.ENTER).
                        perform();


        // sutun sayısını yazdırın
        List<WebElement> cellTitlesList = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun Sayisi : " + cellTitlesList.size());

        System.out.println("*************************************");


        // tum body'i yazdirin  --> tek bir element seklinde yazdirdik.
        WebElement fullBody = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum Body : " + fullBody.getText());

        System.out.println("**************************************");


        // body'de bulunan satır sayısını yazdırın
        List<WebElement> allRowNum = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tum Satir Sayisi : " + allRowNum.size());

        System.out.println("***************************************");


        // body'de bulunan satırları yazdırın  -- > For-each veya Lambda kullan  --> Tek tek yazdirmis olduk aslinda ayni.

        /** FOR-EACH */
        for (WebElement w : allRowNum) {
            System.out.println(w.getText());
        }

        System.out.println("******************************************");

        /** LAMBDA */
        allRowNum.forEach(t-> System.out.println(t.getText()));


        System.out.println("*******************************************");


        // 4.satırdaki elementleri yazdırın
        List<WebElement> row4Elements = driver.findElements(By.xpath("//tbody//tr[4]//td"));

        row4Elements.forEach(t-> System.out.print(t.getText())); /** FOR-EACH ile de yazdirabilirim */


    }
}
