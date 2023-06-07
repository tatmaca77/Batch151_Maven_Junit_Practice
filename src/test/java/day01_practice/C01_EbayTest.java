package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_EbayTest {

    /**
        // https://ebay.com sayfasına gidiniz
        // electronics bolumune tıklayınız
        // genisligi 225 ve uzunlugu 225 olan resimlerin
        hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Ebay Testi baslatildi.");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://ebay.com");
    }

    @Test
    public void test01() throws InterruptedException {
        WebElement electronics = driver.findElement(By.xpath("(//li[@class='hl-cat-nav__js-tab'])[2]"));
        electronics.click();
        Thread.sleep(2000);
        // genisligi 225 ve uzunlugu 225 olan resimlerin
        // hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız.

        // List<WebElement> bilder = driver.findElements(By.xpath("//img[@width='225'] | //img[@height='225']"));
        /** Eger List'i for döngüsünün disinda olusturursak devamli islem yapamaz. 1.ürünü alir ve kalir.
            Sonraki ürünlerin locate'ini bulamaz cünkü for-lopp döngüsü icinde yoktur.
            For-loop icine alinca locate'lari tanimlar ve islemleri yapar.
         */
        /** Unique olmadigi icin List icine atadik ve findElements ile Locate aldik. */

        List<WebElement> bilder = driver.findElements(By.xpath("//img[@width='225'] | //img[@height='225']"));
        // Veya disarda tanimlayacagiz List<WebElemet> olarak icerde size alacagiz ve locate tekrar yazacagiz.
        // size kullandik dinamik oldu. List disarda olmasaydi size olmazdi. Ve icerde tekrar locate belirttik. !!

        for (int i = 0; i < bilder.size(); i++) {     /** Sirasiyla tiklamasi icin hepsini for-loop icinde bu islemi yaptik */
            bilder = driver.findElements(By.xpath("//img[@width='225'] | //img[@height='225']"));
            bilder.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }

        /** Alttaki gibi bir kod dinamik bir kod degildir ve herkes icin calismayabilir. Üstteki kod daha dinamik iyidir. */
        /*

        // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız



        for (int i = 0; i <24 ; i++) {

            List<WebElement> resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));

            resimler.get(i).click();

            System.out.println(driver.getTitle());

            driver.navigate().back();

        }
         */
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Ebay Test sonlandirildi.");

    }
}
