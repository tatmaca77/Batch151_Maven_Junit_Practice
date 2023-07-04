package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase01;

import java.util.List;
import java.util.Random;

public class Task08_AndereLosung extends TestBase01 {

    Random random = new Random();
    @Test
    public void test01() {

        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım

        numberFormer();

        List<WebElement> operators = driver.findElements(By.xpath("//*[@class='operator btn btn-outline-success']"));
        operators.get(random.nextInt(4)).click();

        numberFormer();

        String operation = driver.findElement(By.xpath("//*[@class='screen']")).getText();
        System.out.println("operation = " + operation);

        WebElement equalSign = driver.findElement(By.xpath("//*[@class='btn btn-outline-warning']"));
        equalSign.click();

        bekle(7);

        //Sonucu konsola yazdırıp
        String result = driver.findElement(By.xpath("//*[@class='screen']")).getText();
        System.out.println("result = " + result);

        //Sonucun doğrulamasını yapalım
        double num1 = Double.valueOf(operation.substring(0,2));
        System.out.println("num1 = " + num1);

        double num2 = Double.valueOf(operation.substring(3));
        System.out.println("num2 = " + num2);

        String operator = operation.substring(2,3);

        double expectedResult = 0;

        if(operator.equals("÷")){
            expectedResult = num1/num2;
        } else if (operator.equals("x")) {
            expectedResult = num1*num2;
        }else if(operator.equals("+")){
            expectedResult = num1+num2;
        }else if(operator.equals("-")) {
            expectedResult = num1-num2;
        }

        System.out.println("Expected Result:"+expectedResult);

        double actualResult = Double.valueOf(result);
        System.out.println("actualResult = " + actualResult);

        Assert.assertTrue(expectedResult==actualResult);

    }

    void numberFormer(){
        List<WebElement> digits = driver.findElements(By.xpath("//*[@class='btn btn-outline-primary']"));
        digits.get(random.nextInt(9)).click();
        digits.get(random.nextInt(10)).click();
        bekle(2);
    }

}
