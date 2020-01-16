package pl.b2b.ingTest.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.pages.HistoryPage;
import pl.b2b.ingTest.pages.MainPage;
import pl.b2b.ingTest.pages.TransactionPage;
import pl.b2b.ingTest.pages.TransactionSummary;

public class IngTest {

    MainPage mainPage;
    TransactionPage transactionPage;
    TransactionSummary transactionSummary;
    HistoryPage historyPage;

    @BeforeTest
    public void before() {
        mainPage = new MainPage();
        transactionPage = new TransactionPage();
        transactionSummary = new TransactionSummary();
        historyPage = new HistoryPage();

        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @Test
    public void test() {
        mainPage.closeCookies();
        mainPage.clickExecuteTransactionBtn();
        transactionPage.clickHolidayButton();
        transactionPage.copyMyAccountNumber();
        transactionPage.clickRegularTransferBtn();
        transactionPage.putDetails();
        transactionPage.clickNextBtn();
        Assert.assertTrue(transactionSummary.vacationAccNumbersComparison());
        transactionSummary.clickAcceptButton();
        Assert.assertEquals(transactionSummary.getConfirmMessage(), "Przelew został wykonany");
    }

    @Test(dependsOnMethods = "test")
    public void test2() {
        transactionSummary.clickHistoryButton();
        historyPage.clickFirstDetails();
        Assert.assertTrue(historyPage.secondComparison());
        Assert.assertEquals(historyPage.showNextAmount(),transactionPage.transferAmount );
    }

    @AfterTest
    public void after() {
        SingletonWebdriver.getDriver().quit();
    }
}

