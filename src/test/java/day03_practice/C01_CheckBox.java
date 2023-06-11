package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CheckBox {


    /**
       CheckBox ==> Birden fazla haneye tik atilabilir. ( Multiple Choice )
     */

    /**
     // https://demo.guru99.com/test/radio.html adresine gidin
     // checkbox elementlerini locate edin
     // checkbox1 ve checkbox3  secili degil ise secin
     // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
     // checkbox2 elementinin secili olmadıgını test edin
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Guru99 Testi baslatildi.");
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
    public void test01() throws InterruptedException {
        /*WebElement checkBox1 = driver.findElement(By.id("vfb-6-0"));
        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected());

        WebElement checkBox2 = driver.findElement(By.id("vfb-6-1"));
        Assert.assertFalse(checkBox2.isSelected());

        WebElement checkBox3 = driver.findElement(By.id("vfb-6-2"));
        checkBox3.click();
        Assert.assertTrue(checkBox3.isSelected());*/

        // checkbox elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox3 = driver.findElement(By.id("vfb-6-2"));

        // checkbox1 ve checkbox3  secili degil ise secin
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        Thread.sleep(2000);

        if (!checkBox3.isSelected()) {
            checkBox3.click();
        }

        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox3.isSelected());

        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkBox2.isSelected());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Guru99 Test hat schon beendet.");
    }
}
