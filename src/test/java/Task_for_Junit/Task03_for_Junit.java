package Task_for_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task03_for_Junit {

    /**
    -Amazon sayfasına gidelim
    -Arama Kutusundaki Dropdown menuyu yazdıralım
    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
     başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
     Not: Select Class'ı kullanalım
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
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test01() throws InterruptedException {
        WebElement kategorieDdm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        kategorieDdm.click();
        Select select = new Select(kategorieDdm);

        Thread.sleep(2000);

            select.selectByIndex(0);
            String selectedOption = select.getFirstSelectedOption().getText();
            System.out.println("Seçili Başlık: " + selectedOption);

            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.clear();
            searchBox.sendKeys(selectedOption);
            searchBox.submit();

            String pageTitle = driver.getTitle();
            System.out.println("Sayfa Başlığı: " + pageTitle);
            driver.navigate().back();

    }

    @Test
    public void test02() throws InterruptedException {
        WebElement kategorieDdm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        kategorieDdm.click();
        Select select = new Select(kategorieDdm);

        Thread.sleep(2000);

        select.selectByIndex(1);
        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("Seçili Başlık: " + selectedOption);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys(selectedOption);
        searchBox.submit();

        String pageTitle = driver.getTitle();
        System.out.println("Sayfa Başlığı: " + pageTitle);
        driver.navigate().back();

    }

    @Test
    public void test03() throws InterruptedException {
        WebElement kategorieDdm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        kategorieDdm.click();
        Select select = new Select(kategorieDdm);

        Thread.sleep(2000);

        select.selectByIndex(2);
        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("Seçili Başlık: " + selectedOption);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys(selectedOption);
        searchBox.submit();

        String pageTitle = driver.getTitle();
        System.out.println("Sayfa Başlığı: " + pageTitle);
        driver.navigate().back();

    }

    @Test
    public void test04() throws InterruptedException {
        WebElement kategorieDdm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        kategorieDdm.click();
        Select select = new Select(kategorieDdm);

        Thread.sleep(2000);

        select.selectByIndex(3);
        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("Seçili Başlık: " + selectedOption);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys(selectedOption);
        searchBox.submit();

        String pageTitle = driver.getTitle();
        System.out.println("Sayfa Başlığı: " + pageTitle);
        driver.navigate().back();

    }

    @Test
    public void test05() throws InterruptedException {
        WebElement kategorieDdm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        kategorieDdm.click();
        Select select = new Select(kategorieDdm);

        Thread.sleep(2000);

        select.selectByIndex(4);
        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("Seçili Başlık: " + selectedOption);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys(selectedOption);
        searchBox.submit();

        String pageTitle = driver.getTitle();
        System.out.println("Sayfa Başlığı: " + pageTitle);
        driver.navigate().back();

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon Test hat schon beendet.");
    }
}
