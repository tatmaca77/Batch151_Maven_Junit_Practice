package Task_for_Junit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
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

    ExtentReports extentReports; //-->Raporlamayı başlatmak için kullanılan class
    ExtentHtmlReporter extentHtmlReporter; //-->Raporu HTML formatında düzenler
    ExtentTest extentTest; //--> Test adımlarına eklemek istediğimiz bilgileri bu class ile oluştururuz

    @Test
    public void test01() {

        extentReport("Chrome", "Selenium Dev Testi", "Tolgahan");
        extentTest = extentReports.createTest("ExtentReport","Test Raporu"); // Test islemlerini baslatir.


        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.navigate().to("https://www.selenium.dev/downloads/");
        extentTest.info("Selenium Dev sayfasina gidildi.");


        //Sayfanın resmini alalım
        tumSayfaResmi();
        extentTest.info("Tum Sayfanin ekran görüntüsü alindi.");


        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement browser = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-dark')])[1]"));
        actions.scrollToElement(browser);
        extentTest.info("Browser WebElemntine kadar safya asagiya kaydirildi.");



        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        WebElement documentationChrome = driver.findElement(By.xpath("//a[@href='https://chromedriver.chromium.org/']"));
        actions.scrollToElement(documentationChrome);
        documentationChrome.click();
        extentTest.info("Browser WE tiklandi, DocumentationChrome'a kadar Scroll yapildi ve tiklandi.");



        //Documentation webelementinin resmini alalım
        WebElement documentation = driver.findElement(By.xpath("(//a[text()='Documentation'])[2]"));
        webElementResmi(documentation);
        extentTest.info("Documentation WebElemnti'nin ekran resmi alindi.");



        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//a[@data-url='/downloads'])[2]")).click();  //
        driver.findElement(By.xpath("//span[text()='Version Selection']")).click();
        driver.findElement(By.xpath("//a[text()='https://chromedriver.storage.googleapis.com/LATEST_RELEASE']")).click();































    }
}
