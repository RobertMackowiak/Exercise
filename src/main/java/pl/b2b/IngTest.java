package pl.b2b;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.b2b.ingTest.MainPage;
import pl.b2b.ingTest.MakeTransactionPage;
import pl.b2b.ingTest.NormalTransactionSummaryPage;
import pl.b2b.utils.ExcelData;
import pl.b2b.utils.ExcelRaport;
import pl.b2b.utils.MySqlData;
import pl.b2b.utils.WebPageMethods;

import java.util.Iterator;
import java.util.List;

public class IngTest {

    MainPage mainPage;
    MakeTransactionPage makeTransactionPage;
    NormalTransactionSummaryPage normalTransactionSummaryPage;
    ExcelRaport excelRaport;


    @DataProvider
    public Iterator<Object[]> getDataFromExcel() {
        List<Object[]> list = ExcelData.dataProviderFromExcel("C:/Users/B2B/Desktop/TestData.xlsx");
        return list.iterator();
    }

    @BeforeTest
    public void before() {
        mainPage = new MainPage();
        makeTransactionPage = new MakeTransactionPage();
        normalTransactionSummaryPage = new NormalTransactionSummaryPage();
        excelRaport = new ExcelRaport();
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @AfterTest
    public void after() {
        SingletonWebdriver.quitDriver();
        ExcelData.closeFiles();
    }

    @Test(dataProvider = "getDataFromExcel")
    public void test(String name, String surname, String adres, String cashAmount, String title) {
        try {
//            SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
            mainPage.waitForCookies();
            mainPage.clickOnWykonaj();
            makeTransactionPage.clickVacationAccount();
            makeTransactionPage.getTextFromAccountNumber();
            makeTransactionPage.clickNormalTransaction();
            makeTransactionPage.fillNameAndAdress(name, surname, adres);
            makeTransactionPage.fillCashAmount(cashAmount);
            makeTransactionPage.fillTitle(title);
//            makeTransactionPage.clickForwardButton();
//            Assert.assertTrue(normalTransactionSummaryPage.checkAccountNumber());
            normalTransactionSummaryPage.clickConfirmButton();
            Assert.assertEquals(normalTransactionSummaryPage.getConfirmMessage(), "Przelew został wykonany", "udalo sie");
            excelRaport.writeToExcelPositive(name, surname, adres, cashAmount, title, true);
            MySqlData.sendToBase(true, name, surname, adres, cashAmount, title);
        } catch (Error | Exception e) {
            try {
                WebPageMethods.takeSnapShot(name + surname);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            excelRaport.writeToExcelPositive(name, surname, adres, cashAmount, title, false);
            MySqlData.sendToBase(false, name, surname, adres, cashAmount, title);
            throw e;
        }
    }

    @Test(dependsOnMethods = "test")
    public void testIng2() {
        Assert.assertTrue(true);
    }

    @Test
    public void removePerson() {
        mainPage.waitForCookies();
        mainPage.clickOnMyFinances();
        mainPage.clickOnSavingAccount();

    }

}
