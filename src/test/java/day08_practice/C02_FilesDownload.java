package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase01;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDownload extends TestBase01 {

    /**
    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
// some-file.txt dosyasini indirelim
// dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
     */

    @Test
    public void filesDownload() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");


        File silinecekDosya = new File("C:\\Users\\User\\Downloads\\some-file.txt");
        silinecekDosya.delete();
        /**
        Böylelikle Test her calisitiginda dosya tekrar tekrar ayni sekilde indirilmesin indirsin sonra tekrar
        calisitiralim silsin ki yenisini ayri bir sekilde kayit etmesin. !!!!
         */


        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();


        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        /**             "C:\Users\User\Downloads\some-file.txt" */
        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\User\\Downloads\\some-file.txt")));


        /** Dinamik hale getirelim.

        /**           "C:\Users\User                       \Downloads\some-file.txt" */

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
