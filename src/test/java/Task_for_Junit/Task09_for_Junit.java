package Task_for_Junit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase01;

public class Task09_for_Junit extends TestBase01 {
    /**
    //https://www.selenium.dev/downloads/ adresine gidelim
//Sayfanın resmini alalım
//Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
//Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
//Documentation webelementinin resmini alalım
//All versions available in Downloads altında Latest stable release olan linki tıklayalım
//Açılan pencerede chromedriver'i indirelim
//Driver'in indiğini doğrulayalım
//İndirmiş olduğumuz dosyayı silelim
//Silindiğini doğrulayalım
//Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

     */

    /**
    ExtentReports extentReports; //-->Raporlamayı başlatmak için kullanılan class
    ExtentHtmlReporter extentHtmlReporter; //-->Raporu HTML formatında düzenler
    ExtentTest extentTest; //--> Test adımlarına eklemek istediğimiz bilgileri bu class ile oluştururuz

     */
    ExtentTest extentTest;

    @Test
    public void test01() {

        extentReport("Chrome", "Selenium Dev Testi", "Tolgahan");
        extentTest = extentReports.createTest("ExtentReport","Test Raporu"); // Test islemlerini baslatir.


        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.navigate().to("https://www.selenium.dev/downloads/");
        extentTest.info("Selenium Dev sayfasina gidildi.");

        bekle(1);


        //Sayfanın resmini alalım
        tumSayfaResmi();
        extentTest.info("Tum Sayfanin ekran görüntüsü alindi.");

        bekle(1);


        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement browsers = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-dark')])[1]"));
        actions.scrollToElement(browsers).perform();
        extentTest.info("Browser WebElemntine kadar safya asagiya kaydirildi.");

        bekle(3);



        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        WebElement documentationChrome = driver.findElement(By.xpath("//a[@href='https://chromedriver.chromium.org/']"));
        actions.scrollToElement(documentationChrome).click(documentationChrome).perform();
        extentTest.info("Browser WE tiklandi, DocumentationChrome'a kadar Scroll yapildi ve tiklandi.");

        bekle(2);



        //Documentation webelementinin resmini alalım
        WebElement documentation = driver.findElement(By.xpath("(//a[text()='Documentation'])[2]"));
        webElementResmi(documentation);
        extentTest.info("Documentation WebElemnti'nin ekran resmi alindi.");

        bekle(1);



        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//a[@data-url='/downloads'])[2]")).click();  // Downloads tikla
        driver.findElement(By.xpath("//span[text()='Version Selection']")).click(); // Version selection tikla
        driver.findElement(By.xpath("//a[text()='https://chromedriver.storage.googleapis.com/LATEST_RELEASE']")).click(); // Linke Tikla
        extentTest.info("Latest stable release linkine tiklandi.");

        bekle(2);



        //Açılan pencerede chromedriver'in version numarasini görelim
        WebElement versionNo = driver.findElement(By.xpath("//pre[text()='114.0.5735.90']"));
        extentTest.info("Acilan Pencerede Version Numarasi görüldü.");

        bekle(1);



        //Açılan pencerede chromedriver'in version numarasi "114.0.5735.90" oldugunu dogrula
        String expectedVersionNo = "114.0.5735.90";
        Assert.assertEquals(expectedVersionNo,versionNo.getText());
        extentTest.info("Version numarali karsilastirildi.");

        bekle(1);


    }
}
