package pl.b2b.ingTest.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.pages.*;

import pl.b2b.ingTest.utils.ExcelData;
import pl.b2b.ingTest.utils.ExcelRaport;

public class IngTest {
    MainPage mainPage;
    TransactionPage transactionPage;
    TransactionSummary transactionSummary;
    HistoryPage historyPage;
    String name;
    String surname;
    String address;
    String amount;
    String title;

    @BeforeTest
    public void beforeTest(){
        mainPage = new MainPage();
        transactionPage = new TransactionPage();
        transactionSummary = new TransactionSummary();
        historyPage = new HistoryPage();
        ExcelData.openExcel("C:\\Users\\B2B\\Desktop\\TestData.xlsx", "Arkusz1");
        name = ExcelData.getCellData(1,0);
        surname = ExcelData.getCellData(1,1);
        address = ExcelData.getCellData(1,2);
        amount = ExcelData.getNumCellData(1,3);
        title = ExcelData.getCellData(1,4);
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");

    }

    @Test
    public void testIng() {
        try {
            mainPage.closeCookies();
            mainPage.clickExecuteTransactionBtn();
            transactionPage.clickHolidayButton();
            transactionPage.copyMyAccountNumber();
            transactionPage.clickRegularTransferBtn();
            transactionPage.putNameAndAddress(name + " " + surname + " " + address);
            transactionPage.putAmount(amount);
            transactionPage.putTitle(title);
            transactionPage.clickNextBtn();

            Assert.assertTrue(transactionSummary.vacationAccNumbersComparison());
            transactionSummary.clickAcceptButton();

            Assert.assertEquals(transactionSummary.getConfirmMessage(), "Przelew został wykonany");
            ExcelRaport.writeToExcel("C:\\Users\\B2B\\Desktop\\TestRecord.xlsx", "Arkusz1", name, surname, address, amount, title, true);
        }catch(AssertionError|Exception e){
            ExcelRaport.writeToExcel("C:\\Users\\B2B\\Desktop\\TestRecord.xlsx", "Arkusz1", name, surname, address, amount, title, false);
            throw e;
        }
    }

    @Test (dependsOnMethods = "testIng")
    public void testIng2(){
        transactionSummary.clickHistoryButton();
        historyPage.clickFirstDetails();
        Assert.assertTrue(historyPage.secondComparison());
        Assert.assertEquals(historyPage.showNextAmount(), transactionPage.transferAmount);
    }

    @AfterTest
    public void afterTest(){
        ExcelData.closeFile();
        SingletonWebdriver.getDriver().quit();

    }
}