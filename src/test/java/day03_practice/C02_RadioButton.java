package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButton {

    /**
      Radio Button ==> Birden fazla secim yapmamiza izin vermez. Birden fazla tik atamayiz.-> ( Cinsiyet secimi gibi...)
     */

    /**
      // https://demo.guru99.com/test/radio.html adresine gidin
    // radiobutton elementlerini locate edin
    // option2'yi secin
    // option2 elementlerinin secili oldugunu Test edin
    // option1 elementlerinin secili olmadıgını test edin
    // option3 elementlerinin secili olmadıgını test edin
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Guru99 Testi hat begonnen....");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.guru99.com/test/radio.html");
    }

    @Test
    public void test01() {
        // radiobutton elementlerini locate edin
        WebElement option1 = driver.findElement(By.cssSelector("input[id='vfb-7-1']"));
        WebElement option2 = driver.findElement(By.xpath("//input[@id='vfb-7-2']"));
        WebElement option3 = driver.findElement(By.id("vfb-7-3"));

        // option2'yi secin
        option2.click();

        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(option2.isSelected());

        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(option1.isSelected());

        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(option3.isSelected());
    }

    @Test @Ignore
    public void ignore() {
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Guru99 Test hat schon beendet...");
    }
}
