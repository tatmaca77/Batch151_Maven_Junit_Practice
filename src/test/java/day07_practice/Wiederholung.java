package day07_practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase01;

public class Wiederholung extends TestBase01 {

    /**
     // 'https://www.facebook.com' sayfasina gidiniz
    // yeni hesap olustur butonuna basin
    // isim kutusunu locate ediniz
    // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
     */

    @Test
    public void faker() {
        // 'https://www.facebook.com' sayfasina gidiniz
        driver.navigate().to("https://www.facebook.com");
        bekle(2);
        driver.findElement(By.xpath("//button[@title='Alle Cookies erlauben']")).click();


        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();


        // isim kutusunu locate ediniz
        WebElement vornameBox = driver.findElement(By.xpath("//input[@name='firstname']"));


        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        System.out.println("Email: " + email);

        Actions actions = new Actions(driver);
        actions.click(vornameBox).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("28").
                sendKeys(Keys.TAB).
                sendKeys("04").
                sendKeys(Keys.TAB).
                sendKeys("1995").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT).  // En Sagdaki kutuya ok koyduk.
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();










    }
}
