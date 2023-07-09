package day11_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.TestBase01;

import java.util.List;

public class C01_WebTables extends TestBase01 {

    @Test
    public void test01() {

        girisYap();

        // Email baslıgındaki tüm elementleri(sutun) yazdırın.

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));

        int emailSutunNo = 0;

        for (int i = 0; i <basliklarListesi.size() ; i++) {

            if(basliklarListesi.get(i).getText().equals("Email")){

                emailSutunNo=i;
            }

        }

        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//tr//td["+(emailSutunNo+1)+"]"));

        for (WebElement each:emailSutunListesi) {
            System.out.println(each.getText());
        }

    }

    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click(); // GELİSMİS
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click(); // GÜVENLİ DEGİL

        driver.findElement(By.xpath("//a[text()='Log in']")).click(); // LOG IN

        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));

        actions.
                click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

    }

}
