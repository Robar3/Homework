package ru.Robar3;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static ru.Robar3.Processing.*;

public class TestProcesing {
    @AfterMethod
    private void numberThread() {
        System.out.println((Thread.currentThread().getId()));
    }

    @DataProvider(name = "tenToTwo")
    public Object[][] m1() {
        return new Object[][]{
                {51, "110011"}, {72, "1001000"}, {95, "1011111"}
        };
    }

    @DataProvider(name = "tenToSixteen")
    public Object[][] m2() {
        return new Object[][]{
                {51, "33"}, {72, "48"}, {95, "5f"}
        };
    }

    @DataProvider(name = "twoToEight")
    public Object[][] m3() {
        return new Object[][]{
                {"110011", "63"}, {"1001000", "110"}, {"1011111", "137"}
        };
    }

    @DataProvider(name = "validate")
    public Object[][] m4() {
        return new Object[][]{
                {"6"}, {"1001000"}, {"137"}
        };
    } @DataProvider(name = "exeptionValidate")
    public Object[][] m5() {
        return new Object[][]{
                {"Hello"}, {"Hi"}, {"GoodMorning"}
        };
    }

    @Test(description = "Десятичные числа в двоичные", dataProvider = "tenToTwo")
    public void testTenToTwo(int a, String result) {
        Assert.assertEquals(tenToTwo(a), result);
    }

    @Test(description = "Десятичные числа в шестнадцатеричные", dataProvider = "tenToSixteen")
    public void testTenToSixteen(int a, String result) {
        Assert.assertEquals(tenToSixteen(a), result);
    }

    @Test(description = "Двоичные числа в восьмиричные", dataProvider = "twoToEight")
    public void testTwoToEight(String a, String result) {
        Assert.assertEquals(twoToEight(a), result);
    }

    @Test(description = "проверка является ли числом", dataProvider = "validate")
    public void testCorrectIn(String a) {
        Assert.assertTrue(correctIn(a));
    }
    @Test(description = "Ожидание ошибки метода correctIn",dataProvider = "exeptionValidate",expectedExceptions = NumberFormatException.class)
    public void valueExeption(String a) {
        twoToEight(a);
    }

}
