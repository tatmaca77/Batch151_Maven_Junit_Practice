package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    /**
     // Ulkeler dosyasındaki 64.satır indexin, 1.sutunundaki indexinin
     // "Avusturya" oldugunu test eden "method" olusturunuz.
     */

    @Test
    public void excelReadTest01() throws IOException {

        int rowNumIdx = 64;
        int cellNumIdx = 1;

        String actualData = banaDataGetir(rowNumIdx, cellNumIdx);
        String expectedData = "Berlin";

        Assert.assertEquals(expectedData, actualData);

    }

    public static String banaDataGetir(int rowNumIdx, int cellNumIdx) throws IOException {

        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        String istenenData = workbook.getSheet("Sayfa1").getRow(rowNumIdx).getCell(cellNumIdx).toString();

        return istenenData;

    }
}
