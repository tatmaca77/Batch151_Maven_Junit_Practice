package Task_for_Junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase01;

public class Task04_for_Junit extends TestBase01 {

    /**
    -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
-Çıkan alert'te iptal butonuna basınız
-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
-Çıkan mesajı konsola yazdırınız
-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
     */

    @Test
    public void alert() {
        // -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");

        //Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        button.click();

        bekle(2);

        // -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Alert Mesaji : " + alertMessage);
        acceptAlert();

        bekle(2);

        // -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        WebElement okCancel = driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
        okCancel.click();

        bekle(2);

        WebElement button2 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button2.click();

        bekle(2);

        // -Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert();
        dismissAlert();

        bekle(2);

        // Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        WebElement withTextBox = driver.findElement(By.xpath("(//a[@class='analystic'])[3]"));
        withTextBox.click();

        bekle(2);

        WebElement button3 = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        button3.click();

        bekle(2);

        // -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert();
        sendKeysAlert("Tolgahan");
        bekle(2);
        acceptAlert();

        bekle(2);

        // -Çıkan mesajı konsola yazdırınız
        WebElement actualMessage = driver.findElement(By.xpath("//p[@id='demo1']"));
        System.out.println("Cikan Mesaj Yazisi : " + actualMessage.getText());

        // -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        String expectedMesaage = "Hello Tolgahan How are you today";
        Assert.assertEquals(expectedMesaage,actualMessage.getText());
    }
}
