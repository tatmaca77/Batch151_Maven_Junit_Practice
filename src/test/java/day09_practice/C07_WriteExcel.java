package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C07_WriteExcel {

    /**
    // Ülkeler dosyasindaki 0.satir index'in 4.hücre index'ine yeni bir cell olusturalim.
    // Olusturdugumuz hücreye "Nufus" yazdiralim.
     */

    @Test
    public void test01() throws IOException {

        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath); // ulkeler dosyasini bizim sistemimize getirdik.
        Workbook workbook = WorkbookFactory.create(fis); // dosyayi workbook'a attik.

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        /**
        1.satir index'in 4.hücre index'ine yeni bir cell olusturun ve 10.satir index'in 4.hücre index'ine 20000 yazalim
         ve 2.satir, 4.hücre'ye 20000 yazalim.  Olusturdugunuz hücreye 15000 yazdirin.
         */
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("15000");
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("25000");
        workbook.getSheet("Sayfa1").getRow(10).createCell(4).setCellValue("20000");


        FileOutputStream fos = new FileOutputStream(filePath);
        // datalari bizim class'imizdan ülkeler dosyasina gönderecegiz. !!!!!

        workbook.write(fos); //workbook'taki degisikleri fos icine yani dosya icine yaz dedik !!!!!!


    }
}
