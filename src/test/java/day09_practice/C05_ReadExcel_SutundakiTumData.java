package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel_SutundakiTumData {

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

    /**
          NOTE:

    -->  Um eine statische Methode in einer anderen Klasse zu verwenden, verwenden wir den Klassennamen und den Punkt.
     Wenn wir eine nicht-statische Methode in einer anderen Klasse verwenden möchten, erstellen wir ein neues Objekt mit
     dem Namen der Klasse, in der sich die Methode befindet, in der wir verwenden möchten, und können später problemlos
     darauf zugreifen.

     --> nicht statische Methode ==> instance Methode    --> non-static method

     */

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
