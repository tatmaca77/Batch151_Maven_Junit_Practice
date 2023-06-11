package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hausaufgabe {

    /**
     // https://www.google.com/ adresine gidin
     // sayfa baslıgının "Google" kelimesini icerdigini test edin
     // arama cubuguna "Nutella" yazıp aratın
     // bulunan sonuc sayısını yazdırın
     // bulunan sonuc yazisinida yazdirin
     // sonuc sayısının 100.000.000  fazla oldugunu test edin
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Google Testi hat begonnen....");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com/");
    }

    @Test
    public void test01() {
        WebElement akzeptieren = driver.findElement(By.xpath("//div[text()='Alle akzeptieren']"));
        akzeptieren.click();
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Google"));
        WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        WebElement suchen = driver.findElement(By.xpath("(//input[@value='Google Suche'])[2]"));
        suchen.click();
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucYazisi.getText());
        String sonucSayisi = sonucYazisi.getText().split(" ")[1];
        System.out.println("Sonuc Sayisi: " + sonucSayisi);
        String beklenen = "100000000";
        Assert.assertFalse(sonucSayisi.equals(beklenen));
    }

    @Test @Ignore
    public void ignore() {
        System.out.println("Bu Test calismayacak.");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Test hat beendet.");
    }
}
