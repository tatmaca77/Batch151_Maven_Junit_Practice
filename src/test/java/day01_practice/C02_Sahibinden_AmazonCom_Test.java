package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Sahibinden_AmazonCom_Test {

    /**
           // https://www.sahibinden.com/ sayfasina gidin
           // Title ve Url'ini alın ve yazdırın
           // Title'in "Online" kelimesini içerip içermedigini test edin
           // Url'in "sahibinden" kelimesini içerip içermedigini test edin
           // https://www.amazon.com/ sayfasına gidin
           // Title'ini alın ve yazdırın
           // Title'in "more" kelimesini içerip içermedigini test edin
           // sahibinden.com'a geri dönün
          // sayfayı yenileyin
          // amazon.com'a tekrar gelin
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.sahibinden.com/");

        String sahibindenTitle = driver.getTitle();
        System.out.println("Sahibinden Title : " + sahibindenTitle);

        String sahibindenUrl = driver.getCurrentUrl();
        System.out.println("Sahibinden URL : " + sahibindenUrl);

        Assert.assertFalse(sahibindenTitle.contains("Online"));
        Assert.assertTrue(sahibindenUrl.contains("sahibinden"));

        driver.get("https://www.amazon.com/");

        String amazonTitle = driver.getTitle();
        System.out.println("Amazon Title : " + amazonTitle);

        String amazonUrl = driver.getCurrentUrl();
        System.out.println("Amazon URL : " + amazonUrl);

        Assert.assertTrue(amazonTitle.contains("more"));
        Assert.assertFalse(amazonUrl.contains("online"));
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().forward();
    }

    @Test @Ignore
    public void ignore() {
        System.out.println("Hazirda bir Test islemi olursa bu method kullanilacak.");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Test sona erdi.");
    }
}
