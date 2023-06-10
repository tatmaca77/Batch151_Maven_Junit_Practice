package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;

public class Task02_for_Junit {

    /**
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    //Before methodunda http://www.google.com adresine gidin
    //Üç farklı test methodu ile;
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
   //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
   //After method'u ile başlıkları yazdırınız
   //AfterClass ile browser'ı kapatınız
     */
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("Google Test hat begonnen...");
        System.out.println("*********************************");
    }

    @Before
    public void setUp() throws Exception {
        driver.navigate().to("http://www.google.com");
    }

    @Test
    public void test01() throws InterruptedException {
        WebElement akzeptieren = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        akzeptieren.click();

        driver.findElement(By.id("APjFqb")).sendKeys("The God Father");

        WebElement suchen = driver.findElement(By.xpath("(//input[@value='Google Suche'])[2]"));
        suchen.click();

        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Sonuc Yazisi : " +result.getText());
        System.out.println("*************************************");

        String sonucSayisi = result.getText().split(" ")[1];
        System.out.println("Sonuc Sayisi : " + sonucSayisi);
        System.out.println("*************************************");

        driver.navigate().back();

        Thread.sleep(2000);
    }

    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.id("APjFqb")).sendKeys("Lord of the Rings");

        WebElement suchen = driver.findElement(By.xpath("(//input[@value='Google Suche'])[2]"));
        suchen.click();

        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Sonuc Yazisi : " +result.getText());
        System.out.println("**************************************");

        String sonucSayisi = result.getText().split(" ")[1];
        System.out.println("Sonuc Sayisi : " + sonucSayisi);
        System.out.println("**************************************");

        driver.navigate().back();

        Thread.sleep(2000);
    }

    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.id("APjFqb")).sendKeys("Kill Bill");

        WebElement suchen = driver.findElement(By.xpath("(//input[@value='Google Suche'])[2]"));
        suchen.click();

        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Sonuc Yazisi : " +result.getText());
        System.out.println("*****************************************");

        String sonucSayisi = result.getText().split(" ")[1];
        System.out.println("Sonuc Sayisi : " + sonucSayisi);
        System.out.println("*****************************************");

        driver.navigate().back();

        Thread.sleep(2000);
    }

    @After
    public void tearDown() throws Exception {
        String actualTitle = driver.getTitle();
        System.out.println("Sayfa Basligi : " + actualTitle);
        System.out.println("******************************************");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }
}
