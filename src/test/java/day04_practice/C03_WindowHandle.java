package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase01;

public class C03_WindowHandle extends TestBase01 {

    /**
    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim
     */

    @Test
    public void windowHandle() {
        //https://www.amazon.com
        driver.get("https://www.amazon.com");

        // windowhandle aliyoruz.
        String amazonHanldle = driver.getWindowHandle();

        //url'in 'amazon' icerdigini test edelim
        String amazonUrl = driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));

        // yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        // bestbuy sayfasinin handle degerini al.
        String beytBuyHandle = driver.getWindowHandle();

        // title'in 'Best Buy' icerdigini test edelim
        String bestByTitle = driver.getTitle();
        Assert.assertTrue(bestByTitle.contains("Best Buy"));

        // ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHanldle);
        WebElement suchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        suchBox.sendKeys("Java" + Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        WebElement result = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String expectedText = "Java";
        System.out.println("Sonuc Yazisi : " + result.getText());
        Assert.assertTrue(result.getText().contains(expectedText));

        // ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(beytBuyHandle);

        // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());


    }
}
