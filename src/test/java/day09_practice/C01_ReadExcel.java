package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    /**
     // Ulkeler dosyasındaki 3.satır indexin, 3.sutunundaki indexinin
     // "Cezayir" oldugunu test eden "method" olusturunuz.
     */

    @Test
    public void excelReadTest01() throws IOException {

        /**
         Excel gördügümde aklima 3 adim gelecek.

         1-) Dosya Yolu nu String'e ata.
         2-) FileInputStream objesi olustur.
         3-) Workbook- WorkbookFactory.create olustur.
         */

        int rowNumIdx = 3;
        int cellNumIdx = 3;

        String actualData = banaDataGetir(rowNumIdx, cellNumIdx);
        String expectedData = "Cezayir";

        Assert.assertEquals(expectedData, actualData);

    }

    public static String banaDataGetir(int rowNumIdx, int cellNumIdx) throws IOException {

        String filePath = "src/resources/ulkeler.xlsx"; // ContentRoot 'dan DosyaYolunu aldim.
        FileInputStream fis = new FileInputStream(filePath); // Ülkeler dosyasini bizim sistemimize getiriyor.
        Workbook workbook = WorkbookFactory.create(fis); // Dosyayi "workbook"a atadik.

        String istenenData = workbook.getSheet("Sayfa1").getRow(rowNumIdx).getCell(cellNumIdx).toString();

        return istenenData;

    }

    /**
    Methodu "static" yaptik cünkü diger class'larda kullanmak istersek sadece "class ismi(.)" ile call yapabilmke icin. !!!!!

     Bu konu JAVA'da --> ( static method --- non-static method )
     */


}