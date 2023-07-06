package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {

    /**
    // Ulkeler dosyasındaki "Başkent (İngilizce)" sutununu yazdırınız. ( Sütunun tamamini- for loop kullan !!!! )
     */

    @Test
    public void excelReadTest01() throws IOException {

        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        int lastRowIdx = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Son Satir Numarasi : " + (lastRowIdx+1));
        //getLastRowNum(); --> son satir numarasini index olarak verir. Bu yüzden yazdirirken +1 ekledim tam olarak versin diye.

        for (int i = 0; i < lastRowIdx; i++) {
            String satirdakiData = C01_ReadExcel.banaDataGetir(i,1);//Baskent (Ingilizce) sütunu 1.indexteki sütunda yer alir.
            System.out.println("satirdakiData = " + satirdakiData);

            /**
             banaDataGetir methodunu C01 Classindan alicaz ve onu "static" yaptik. Bu sekilde de islemi yapabiliriz.
             Class ismi (.) ile direkt methodu cagirabiliriz. !!!!!
             */
        }
    }

    @Test
    public void excelReadTest02() throws IOException {

        /**
        banaDataGetir methodunu C02 Classindan alicaz ve onu "static" yapmadik . Bu sekilde de islemi yapabiliriz.
        Class ismi ile cagiramayiz, non-static olan methodlari kullanamak icin "Object" olusturmaliyiz. !!!!
         --> non-static method ==> instance method
         */
        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        int lastRowIdx = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Son Satir Numarasi : " + (lastRowIdx+1));

        for (int i = 0; i < lastRowIdx; i++) {

            C02_ReadExcel obj = new C02_ReadExcel();  // Class isminden obje olusturduk !!!! JAVA yaptik.

            String satridakiData = obj.banaDataGetir(i,1);
            System.out.println("satridakiData = " + satridakiData);
        }
    }
}
