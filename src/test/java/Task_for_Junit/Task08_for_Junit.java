package Task_for_Junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase01;

public class Task08_for_Junit extends TestBase01 {


    /**
    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim

    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım

    //Sonucu konsola yazdırıp

    //Sonucun doğrulamasını yapalım
     */

    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");


        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        WebElement nummer2 = driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[8]"));
        WebElement nummer5 = driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[5]"));
        nummer2.click();
        nummer5.click();

        // Toplama islemini seciyoruz.
        driver.findElement(By.xpath("(//span[@class='operator btn btn-outline-success'])[1]")).click();

        WebElement nummer1 = driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[7]"));
        WebElement nummer0 = driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[10]"));
        nummer1.click();
        nummer0.click();

        // Sonuc icin esittire butonuna basicaz.
        driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']")).click();
        bekle(5);


        //Sonucu konsola yazdırıniz.
        WebElement result = driver.findElement(By.xpath("//div[@class='screen']"));
        System.out.println("Result : " + result.getText());


        //Sonucun doğrulamasını yapalım
        Assert.assertEquals("35",result.getText());
    }
}
