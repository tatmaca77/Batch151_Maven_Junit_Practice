package Task_for_Junit;

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
        List<WebElement> demoTableHotelList = driver.findElements(By.xpath("(//tbody)[2]//th"));

        demoTableHotelList.forEach(t-> System.out.println(t.getText()));


        //Demo Table2 altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız





        //Bütün Height bilgilerini yazdırınız










    }
}
