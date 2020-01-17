package pl.b2b.IngTest.tests;

import org.junit.Assert;
import org.testng.annotations.*;
import pl.b2b.IngTest.pages.*;
import pl.b2b.IngTest.utils.ExcelData;
import pl.b2b.SingletonWebDriver;


public class IngTest {

    MainPage mainPage;
    TransactionPage transactionPage;
    SummaryPage summaryPage;
    TransactionHistoryPage transactionHistoryPage;
    String name;
    String surname;
    String address;
    String amount;
    String title;

    @BeforeTest
    public void before() {

        mainPage = new MainPage();
        transactionPage = new TransactionPage();
        summaryPage = new SummaryPage();
        transactionHistoryPage = new TransactionHistoryPage();

        ExcelData.openExcel("C:\\Users\\Michał\\Desktop\\TestData.xlsx", "Arkusz1");
        name = ExcelData.getCellData(1,0);
        surname = ExcelData.getCellData(1,1);
        address = ExcelData.getCellData(1,2);
        amount = ExcelData.getNumericCellData(1,3);
        title = ExcelData.getCellData(1,4);
        SingletonWebDriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");

    }

    @AfterTest
    public void after() {
        SingletonWebDriver.getDriver().quit();
        ExcelData.closeFile();
    }

    @Test
    public void firstIngTest() {
        mainPage.setCloseCookies();
        mainPage.clickIntoTransactionButton();
        transactionPage.clickOnVacationAccount();
        transactionPage.copyMyAccountNumber();
        transactionPage.clickOnUsualransfer();
        transactionPage.setTransactionFields(name+" "+surname+ " " +address, amount,title);
        transactionPage.nextButtonClick();
        Assert.assertTrue(summaryPage.vacationAccountComparision());
        summaryPage.confirmButtonClick();
        Assert.assertEquals(summaryPage.getConfirmMessage(), "Przelew został wykonany");
    }


    @Test(dependsOnMethods = "firstIngTest")
    public void secondIngTest() {
        summaryPage.historyButtonClick();
        transactionHistoryPage.clickOnLastTransfer();
        Assert.assertTrue(transactionHistoryPage.accountComparisionFromPages());
        Assert.assertEquals(transactionHistoryPage.getDetailsOfTransaction(), amount.substring(0,3));

    }
}
