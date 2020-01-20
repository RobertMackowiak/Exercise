package pl.b2b.bankIng.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import pl.b2b.SingletonWebdriver;
import pl.b2b.bankIng.pages.*;
import pl.b2b.bankIng.utils.ExcelData;
import pl.b2b.bankIng.utils.ExcelRaport;

import java.util.Iterator;
import java.util.List;

public class BankIngTest {

    MainPage mainPage;
    ExecuteTranstactionPage executeTranstactionPage;
    NormalTransactionPage normalTransactionPage;
    HistoryOfTransactionPage historyOfTransactionPage;
    //    ExcelData excelData;
    String name;
    String lastName;
    String adres;
    String amount;
    String title;

    @DataProvider
    public Iterator<Object[]> dataProvider() {

        List<Object[]> list = ExcelData.getAllDataExcel("C:\\Users\\B2B021\\Desktop\\TestData.xlsx", "Sheet1");

        return list.iterator();
    }

    @BeforeTest
    public void beforeTest() {
        mainPage = new MainPage();
        executeTranstactionPage = new ExecuteTranstactionPage();
        normalTransactionPage = new NormalTransactionPage();
        historyOfTransactionPage = new HistoryOfTransactionPage();
//        ExcelData.openExcel("C:\\Users\\B2B021\\Desktop\\TestData.xlsx", "Sheet1");
//        name = ExcelData.getCellData(1, 0);
//        lastName = ExcelData.getCellData(1, 1);
//        adres = ExcelData.getCellData(1, 2);
//        amount = ExcelData.getNumericCellData(1, 3);
//        title = ExcelData.getCellData(1, 4);
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");

    }

    @AfterMethod
    public void afterTest(){
        ExcelData.closeFile();
        SingletonWebdriver.quitDriver();

    }

    @Test(dataProvider = "dataProvider")
    public void bankTest(String name, String lastName, String adres, String amount, String title) {
        try {
            mainPage.clickExecuteTransactionButton();
            executeTranstactionPage.clickHolidayButton();
            executeTranstactionPage.copyAccountNumber();
            executeTranstactionPage.clickNormalTransaction();
            normalTransactionPage.putInTextInLabels(name + " " + lastName + " " + adres, amount, title);
            Assert.assertEquals("47 1050 0028 2100 0023 0315 0001", executeTranstactionPage.getAccNumber());
            normalTransactionPage.clickConfirmButton();
            normalTransactionPage.checkTitle();
//            Assert.assertEquals(normalTransactionPage.getConfirmMessage(), "Przelew został wykonany");
            ExcelRaport.writeToExcel("C:\\Users\\B2B021\\Desktop\\TestReport.xlsx", "Sheet1", name, lastName, adres, amount, title, true);
        } catch (AssertionError | Exception e) {
            ExcelRaport.writeToExcel("C:\\Users\\B2B021\\Desktop\\TestReport.xlsx", "Sheet1", name, lastName, adres, amount, title, false);
            throw e;

        }
    }

//    @Test(dependsOnMethods = "bankTest")
//    public void bankTest2() {
//        normalTransactionPage.clickHistoryButton();
//        historyOfTransactionPage.clickLastTransaction();
////        historyOfTransactionPage.checkAccountAgain();
////        Assert.assertEquals("47 1050 0028 2100 0023 0315 0001", historyOfTransactionPage.getLastAssertion());
//
//    }


}


