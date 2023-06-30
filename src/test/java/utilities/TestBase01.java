package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase01 {   // abstract yaptik ve bunun icinde obje olusturulmasini önleriz.
                                   // abstract zorunda degiliz; ancak buirasi bir depodur.

    // protected yaptik cünkü bunlari farkli Package'larda kullanabilmek icin. extends yaptiktan sonra.
    protected static ExtentReports extentReports; //-->Raporlamayı başlatmak için kullanılan class
    protected static ExtentHtmlReporter extentHtmlReporter;//-->Raporu HTML formatında düzenler
    //protected static ExtentTest extentTest;//--> Test adımlarına eklemek istediğimiz bilgileri bu class ile oluştururuz

    /**
       Bu Class'a "extends" ettigimiz Test Classlarindan ulasabiliriz.
       TestBase Class'indan object olusturulmasinin önüne gecilmesi icin "abstract" yapilabilir.
     */

    protected static WebDriver driver;    // Mutlaka access modifier "protected" veya "public" olmalidir.
    @Before                               // Bulundugu tüm package'larda görünmesi icin.
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        bekle(2);
        driver.quit();
    }

    /** HARD WAIT ( Bekleme Methodu ) */
    public static void bekle (int saniye) {
        try {                                    //try-catch ile exception yaptik. Method Signature
            Thread.sleep(saniye*1000);      // yapsaydik her yere yine exception atmaliydik.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /** AlertWait methodu */
    public void alertWait(int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /** FluentWait visible Methodu */
    public void visibleFluentWait(WebElement element, int saniye, int milisaniye) {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(milisaniye)).
                until(ExpectedConditions.visibilityOf(element));
    }

    /** AcceptAlert */
    public static void acceptAlert () {
        driver.switchTo().alert().accept();
    }

    /** DissmissAlert */
    public static void dismissAlert () {
        driver.switchTo().alert().dismiss();
    }

    /** getTextAlert */
    public static String getTextAlert () {
        return driver.switchTo().alert().getText();  // Sonuc olarak verilen Texti String olarak aldik.
    }

    /** sendKeysAlert */
    public static void sendKeysAlert (String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    /** DropDown VisibleText */
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    /** DropDown Index */
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    /** DropDown Value */
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    /** Explicit Wait */
    public void visibleWait1(WebElement locate, int seconds ){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(locate));

    }

    /** SwitchTo Window-1 */
    public void switchToWindow(int index){
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }

    /** SwitchTo Window-2 */
    public void switchWindow(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    /** Tüm Sayfa Resmi (ScreenShot) */
    public void tumSayfaResmi() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
            //Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /** Method olustururken mutlaka try-catch icinde Exception Handle etmelisin. !!!!!
         Eger Method icinde Signature'a atarsak bu sefer her methodu cagirdigimizda bizden exception ister
         Bu sebeple "try-catch" kullandik.
         */
    }

    /** Web Element Resmi (WebElement ScreenShot) */
    public void webElementResmi (WebElement element){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot" + tarih + ".jpeg";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /**
         Her bu methodu cagirdigimda Exception ile ugrasmamak icin "try-catch" blogu kullaniriz. !!!!!
         */
    }

    /** UploadFile Robot Class */

    public void uploadFilePath(String filePath) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    /** Extent Report Methodu */

    public void extentReport(String browser, String reportName, String testerName){
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // Her raporu ayri ayri olusturur.
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html"; // DOSYA YOLU belirttik.
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//-->HTML formatında raporlamayı başlatacak

        //Raporda gözükmesini isteğimiz bilgiler için
        extentReports.setSystemInfo("Browser",browser);
        extentReports.setSystemInfo("Tester",testerName);
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName(reportName);

        /**
         Extent Report alabilmek icin yaptigim ayarlamalarin methodu. Class isimlerini de Class seviyesinde en üstte
         yazdik.
         */

    }

}
