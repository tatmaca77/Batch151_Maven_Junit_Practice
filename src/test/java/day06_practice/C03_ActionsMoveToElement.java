package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase01;

import java.util.Set;

public class C03_ActionsMoveToElement extends TestBase01 {

    /**
    // https://amazon.com adresine gidiniz
// sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
// Change country/region butonuna basiniz
// United States dropdown'undan 'Turkey (Türkiye)' seciniz
// Go to website butonuna tiklayiniz
// acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
     */

    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");

        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE: " + sayfa1Handle);

        Actions actions = new Actions(driver);

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement languages = driver.findElement(By.xpath("//a[@id='icp-nav-flyout']"));
        actions.moveToElement(languages).perform();

        // Change country/region butonuna basiniz
        WebElement regionÄndern = driver.findElement(By.xpath("(//div[text()='Land/Region ändern'])[1]"));
        regionÄndern.click();
        bekle(3);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz DDM 3 adimda Handle edilir Unutma: ddm-select-option
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Türkei (Türkiye)"); // sectikten sonra ddm kapanmadi goto website görünmedi !!!!!
        bekle(3);
        /** selectVisibleText(ddm,"Türkei (Türkiye)"); Resable method kullanilabilir, ama DDM nasil handle edilir ögrenmek icin uzun yol al */


        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//span[text()='Länder-/Region-Website ändern']")).click();
        /**
          DropDown opsiyon listesi "Go to website" butonuna basmamiza engel oldugu icin; herhangi bir yere click()
           yapip ddm listesinin toparlanmasini saglariz.
         */
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        bekle(2);

        /** Auf Website tikladiktan sonra yeni bir sayfa acilir, bu yüzden windowhandles islemi yapmaliyim. */
        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println("Tüm Handle Degerler : " + windowHandleSeti);

        String sayfa2Handle = "";

        for (String w : windowHandleSeti) {
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle = w;
            }
        }
        System.out.println("SAYFA2HANDLE : " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        String zweiteSeiteTitle = driver.getTitle();
        System.out.println("SAYFA2TITLE: " + zweiteSeiteTitle);
        Assert.assertTrue(zweiteSeiteTitle.contains("Elektronik"));

        driver.switchTo().window(sayfa1Handle);
        String ersteSeiteUrl = driver.getCurrentUrl();
        System.out.println("Ilk Sayfa URL : " + ersteSeiteUrl);
    }
}
