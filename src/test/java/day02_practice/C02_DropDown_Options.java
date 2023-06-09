package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown_Options {

    /**
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Amazon Test hat begonnen...");
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
    public void test01() throws InterruptedException {
        WebElement kategorieDdm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Thread.sleep(2000);

        Select select = new Select(kategorieDdm);
        select.selectByIndex(2);

        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Selected Option : " + selectedOption.getText());

        //Assert.assertEquals(28,select.getOptions().size());

        //select.getOptions().forEach(t-> System.out.println(t.getText()));

        /**2.YOL */

        // // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> options = select.getOptions();

        int expectedOptionsNumber = 28;
        int actualOptionsNumber = options.size();

        Assert.assertEquals(expectedOptionsNumber,actualOptionsNumber);

        // // dropdown'daki optionların tamamını yazdırın
        int count = 1 ;

        for (WebElement w : options) {
            System.out.println(count + ". option " + w.getText());

            count++;
        }
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon Test hat schon beendet...");
    }
}
