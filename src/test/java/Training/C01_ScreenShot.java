package Training;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase01;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase01 {

    /**
    1.Techpro education a git ve Sayfanin goruntusunu al
2.-“QA” aramasi yap
3.Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for:
qa
     */
    @Test
    public void test01() throws IOException {
        // 1.Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // Reklami kapatir.


        // 2.-“QA” aramasi yap
        WebElement sucheBox = driver.findElement(By.cssSelector("html>body>div>section>div>div:nth-of-type(2)>div>div>div>form>div>input"));
        sucheBox.sendKeys("QA", Keys.ENTER); // Yazdik ve Arama yaptik


        // 3.Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA

        /** Once yeni acilan sayfadaki metni test ettik */
        WebElement title = driver.findElement(By.xpath("//h1[text()='Search Results for: QA']"));
        System.out.println("Text : " + title.getText()); // Konsola yazdirdik.
        Assert.assertEquals("Search Results for: QA", title.getText()); // Yaziyi test ettik
        bekle(2);


        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // Unique sekilde ayirir.
        String filePath = "target/ekranGoruntusu/screenShot" + date + ".jpeg"; // Dosya yolu ve formatini yazdik
        TakesScreenshot ts = (TakesScreenshot) driver; // Casting islemi yaptik esitledik ve hatayi ortadan kaldirdik.
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(filePath));
        bekle(2);
    }
}
