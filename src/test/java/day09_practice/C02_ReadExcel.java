package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {

    /**
    // Ulkeler dosyasındaki 10.satır indexin, 2.sutunundaki indexinin
     // "Avusturya" oldugunu test eden "method" olusturunuz.
     */

    @Test
    public void excelReadTest01() throws IOException {

        int rowNumIdx = 10;
        int cellNumIdx = 2;

        String actualData = banaDataGetir(rowNumIdx, cellNumIdx);
        String expectedData = "Avusturya";

        Assert.assertEquals(expectedData, actualData);
    }

    public String banaDataGetir(int rowNumIdx, int cellNumIdx) throws IOException {

        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        String istenenData = workbook.getSheet("Sayfa1").getRow(rowNumIdx).getCell(cellNumIdx).toString();

        return istenenData;

    }
}
