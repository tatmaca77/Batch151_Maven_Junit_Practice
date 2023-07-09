package Task_for_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task01_for_Junit {

    /**
    - Before methodu ile drive'i olusturup ayarlamalari yapiniz
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
    - After methodu ile sayfayı kapatalım
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        System.out.println("Ebay Test hat begonnen.");
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.ebay.com/");
    }

    @Test
    public void test01() throws InterruptedException {
        WebElement electronics = driver.findElement(By.xpath("(//a[@_sp='p2481888.m1380.l3250'])[1]"));
        electronics.click();

        Thread.sleep(2000);

        List<WebElement> bilder = driver.findElements(By.xpath("//img[@width='225'] | //img[@height='225']"));
        for (int i = 0; i < bilder.size(); i++) {
            bilder = driver.findElements(By.xpath("//img[@width='225'] | //img[@height='225']"));
            bilder.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Ebay Test hat beendet.");
    }
}
