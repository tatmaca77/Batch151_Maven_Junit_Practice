package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBy_Test {

    /**
        https://www.bestbuy.com/ sayfasına gidin
        sayfa Title'ini alın "Best" içerdigini test edin
       BestBuy logosunun görüntülendigini test edin
       Canada logosunun görüntülendigini test edin
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Test baslatildi.");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        driver.get(" https://www.bestbuy.com/");

        String bestByTitle = driver.getTitle();
        System.out.println("Actual Title: " + bestByTitle);
        Assert.assertTrue(bestByTitle.contains("Best"));

        WebElement bestByLogo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(bestByLogo.isDisplayed());

        WebElement canadaLogo = driver.findElement(By.xpath("(//img[@alt='Canada'])[1]"));
        Assert.assertTrue(canadaLogo.isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Test sonlandirildi.");
    }
}
