package day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase01;

public class C02_Alert extends TestBase01 {

    /**
    //http://demo.guru99.com/test/delete_customer.php adresine gidin
//customer id kısmına 53920 yazın
//submit butonuna tıklayın
//cıkan alert mesajını yazdırın
//alerti kabul edin
//cıkan 2. alert mesajını yazdırın
//cıkan 2. alerti kabul edin
     */

    @Test
    public void alert() throws InterruptedException {

        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php ");

        Thread.sleep(2000);
                                                /** Anasayfa acildiginda Cerrez karsimiza cikioyr. */
        //cookie iframe code
        WebElement iframe = driver.findElement(By.xpath("//*[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='mat-focus-indicator solo-button mat-button mat-button-base mat-raised-button']")).click();
        driver.switchTo().parentFrame();

        Thread.sleep(2000);

        //customer id kısmına 53920 yazın
        WebElement customerId = driver.findElement(By.xpath("//input[@name='cusid']"));
        customerId.sendKeys("53920");


        Thread.sleep(2000);

        //submit butonuna tıklayın
        WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));
        submit.click();
        Thread.sleep(2000);


        //cıkan alert mesajını yazdırın
        String alertYazisi = driver.switchTo().alert().getText();
        System.out.println("ALERT YAZISI "+alertYazisi);

        Thread.sleep(2000);

        //alerti kabul edin
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        //cıkan 2. alert mesajını yazdırın
        String ikinciAlert = driver.switchTo().alert().getText();
        System.out.println("Ikinci Alert = " + ikinciAlert);
        Thread.sleep(2000);

        //cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        /*
        ALERT YAZISI Do you really want to delete this Customer?
        Ikinci Alert = Customer Successfully Delete!

        Process finished with exit code 0
        */

    }

}

