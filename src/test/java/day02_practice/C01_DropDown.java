package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {

    /**
           // https://www.amazon.com/ sayfasina gidin
           // dropdown'dan "Books" secenegini secin
           // arama cubuguna "Java" aratın
           // arama sonuclarinin Java icerdigini test edin
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Amazon Testi baslatildi.");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.com/");
    }
          /** Drop Down degince akla hemen select tag'i gelmelidir. */
    @Test
    public void test01() throws InterruptedException {
        WebElement kategorieDdm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Thread.sleep(2000);

        Select select = new Select(kategorieDdm);

        select.selectByIndex(3);             // Eger selectByValue() kullanmak istersem. Bu degerin HTML kodlarina bakmaliyim.
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Secilen secenek : " + selectedOption.getText());

        Thread.sleep(2000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(result.getText().contains("Java"));
    }

    @Test @Ignore
    public void ignore() {
        System.out.println("Bu Test Calismayacaktir.");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon Test hat schon beendet.");
    }
}
