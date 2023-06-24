package day08_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {


    /**
    //masaustunde bir text dosyasi olusturunuz
    // masaustuntxt dosyasinin olup olmadigini test ediniz.
     */

    @Test
    public void files() {
        //masaustunde bir text dosyasi olusturunuz


        // masaustuntxt dosyasinin olup olmadigini test ediniz.

        //   "C:\Users\User\Desktop\Batch151.txt"  ==> Yol
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\User\\Desktop\\Batch151.txt")));

        // Bu sekilde Dinamik halde bir kod blogu degildir.

        /** Daha Dinamik hale getirelim */
        String farkliKisim = System.getProperty("user.home"); // Herkesin bilgisayarinda farkli olan kisimdir.
        String ortakKisim = "\\Desktop\\Batch151.txt"; // Herkesin bilgisayarinda ortak olan kisimdir.

        String dosyaYolu = farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /**
        SELENIUM bizim bilgisayarima müdahale edemez ve Test edemez. Bu yüzden JAVA kullanarak bilgisayarimizda
        bulunan dosyayi Test edebiliriz.
         */









    }
}
