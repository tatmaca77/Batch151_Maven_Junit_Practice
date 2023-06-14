package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase01 {   // abstract yaptik ve bunun icinde obje olusturulmasini önleriz.
                                   // abstract zorunda degiliz; ancak buirasi bir depodur.

    /**
       Bu Class'a "extends" ettigimiz Test Classlarindan ulasabiliriz.
       TestBase Class'indan object olusturulmasinin önüne gecilmesi icin "abstract" yapilabilir.
     */

    protected static WebDriver driver;    // Mutlaka access modifier "protected" veya "public" olmalidir.
    @Before                               // Bulundugu tüm package'larda görünmesi icin.
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        bekle(2);
        driver.quit();
    }

    /** HARD WAIT ( Bekleme Methodu ) */
    public static void bekle (int saniye) {
        try {                                    //try-catch ile exception yaptik. Method Signature
            Thread.sleep(saniye*1000);      // yapsaydik her yere yine exception atmaliydik.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /** AcceptAlert */
    public static void acceptAlert () {
        driver.switchTo().alert().accept();
    }

    /** DissmissAlert */
    public static void dismissAlert () {
        driver.switchTo().alert().dismiss();
    }

    /** getTextAlert */
    public static String getTextAlert () {
        return driver.switchTo().alert().getText();  // Sonuc olarak verilen Texti String olarak aldik.
    }

    /** sendKeysAlert */
    public static void sendKeysAlert (String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    /** DropDown VisibleText */
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    /** DropDown Index */
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    /** DropDown Value */
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

}
