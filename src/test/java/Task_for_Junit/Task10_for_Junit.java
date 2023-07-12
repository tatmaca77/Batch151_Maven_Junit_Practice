package Task_for_Junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase01;

import java.util.List;

public class Task10_for_Junit extends TestBase01 {

    /**
    //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
//Demo Table altındaki tablodaki otel bilgilerini yazdırınız
//Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
//Bütün Height bilgilerini yazdırınız
//Otel uzunluklarının hepsini toplayınız
//Bir method ile satır ve sutun bilgilerini çağıralım
     */

    @Test
    public void test01() {
        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.navigate().to("https://www.techlistic.com/p/demo-selenium-practice.html");


        //Demo Table2 altındaki tablodaki otel bilgilerini yazdırınız
        List<WebElement> demoTableHotelList = driver.findElements(By.xpath("(//table)[2]"));

        demoTableHotelList.forEach(t-> System.out.println("Tüm Otel Bilgileri : " + t.getText()));

        System.out.println("***************************************");


        //Demo Table2 altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        List<WebElement> cellTitleList = driver.findElements(By.xpath("(//table)[2]//thead//tr//th"));

        System.out.println("***************************************");

        System.out.println("Table2 Tüm Sütun saysisi : " + cellTitleList.size()); // Sütun sayisini bulduk

        cellTitleList.stream().forEach(t-> System.out.println(t.getText())); // Sütun isimlerini tek tek yazdirdik

        System.out.println("****************************************");
        
        WebElement height = driver.findElement(By.xpath("((//table)[2]//thead/tr//th)[4]"));
        System.out.println("height= " + height.getText());

        System.out.println("***************************************");


        List<WebElement> allRow = driver.findElements(By.xpath("(//table)[2]//tbody//tr"));
        System.out.println("Table2 Tüm Satir Sayisi : " + allRow.size());

        System.out.println("***************************************");

        allRow.stream().forEach(t-> System.out.println(t.getText())); // Satirlari yazdirdik

        System.out.println("***************************************");

        WebElement row2Elements = driver.findElement(By.xpath("((//table)[2]//tbody//tr)[2]"));

        System.out.println("row2Elements" + row2Elements.getText());

        Assert.assertTrue(row2Elements.getText().contains("601m"));








        //Bütün Height bilgilerini yazdırınız










    }
}
