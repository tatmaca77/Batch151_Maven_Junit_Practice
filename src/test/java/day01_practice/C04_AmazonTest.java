package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AmazonTest {

    /**
    // https://www.amazon.com/ adresine gidin
   // arama motorunda nutella yazip aratınız
   // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Test Baslatildi.");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);
        Thread.sleep(2000);

        // Ürünlerin Linklerine tiklariz.
        List <WebElement> produkte = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        // Ürünlerin Resimlerine tiklariz.
        //List<WebElement> produkte = driver.findElements(By.xpath("//img[@class='s-image']"));

        for (int i = 0; i < produkte.size(); i++) {
            produkte = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
            produkte.get(i).click();
            System.out.println((i+1)  + ".URUN TITLE : " + driver.getTitle());
            driver.navigate().back();
        }
    }

    @Test @Ignore
    public void ignore() {
        System.out.println("Bu test calismayacaktir.");
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
