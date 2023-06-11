package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_GetPageSource {

    /**
    // https://www.amazon.com/ adresine gidin
    // Kaynak Kodlarini konsola yazdiriniz
    // Kaynak Kodlarinda "Gateway" yazdigini test edin.
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Amazon Test hat begonnen....");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test01() {
        String sourceCodes = driver.getPageSource();
        System.out.println("Sayfanin Kaynak Kodlari : " + sourceCodes);
        Assert.assertTrue(sourceCodes.contains("Gateway"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon Test hat schon beendet.");
    }
}
