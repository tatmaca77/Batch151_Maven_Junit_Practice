package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel_TumVeriler {

    /**
    //Ulkeler dosyasindaki tum datalari yazdiriniz.
     */

    @Test
    public void test01() throws IOException {

        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        int lastRowNumIdx = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("(lastRowNumIdx+1) = " + (lastRowNumIdx+1));

        Map<String,String> countryMaps = new HashMap<>();

        for (int i = 0; i < lastRowNumIdx; i++) {

            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            countryMaps.put(key,value);
        }

        System.out.println("Ulkeler Map : " + countryMaps);
    }
    /**
     Genellikle bir Excel'deki tüm veriler istenirse bizim icin en güzel olani Map kullanmaktir. Cünkü Map
     key-value iliskisine sahiptir. Ama bazen 2 den fazla sütun olabilir. Bu durumda :
     key bulunduktan sonra , value icin kac tane sütun varsa + diyerek yanina ekleme yapabiliriz. !!!!!!
     */
}
