package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {

    /**
     // Ulkeler dosyasındaki "Başkent (Türkce)" sutununu yazdırınız. ( Sütunun tamamini- for loop kullan !!!! )
     */

    @Test
    public void excelReadTest01() throws IOException {

        /**
        Bu soruda banaDataGetir methodu kullandik !!!
         */

        /** 1. WAY */

        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        int lastRowNumIdx = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("lastRowNumIdx = " + (lastRowNumIdx+1));

        for (int i = 0; i < lastRowNumIdx; i++) {

            String satirdakiData = C01_ReadExcel.banaDataGetir(i,3);
            System.out.println("satirdakiData = " + satirdakiData);

        }

    }

    @Test
    public void excelReadTest02() throws IOException {

        /**
         Bu soruda banaDataGetir methodu kullanmak zorunda degiliz. !!!
         */

        /** 2. WAY */

        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        int lastRowNumIdx = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("lastRowNumIdx = " + (lastRowNumIdx+1));

        for (int i = 0; i < lastRowNumIdx; i++) {
            String satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println("satirdakiData = " + satirdakiData);
        }

    }
}
