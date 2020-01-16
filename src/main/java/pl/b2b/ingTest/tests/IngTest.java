package pl.b2b.ingTest.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.pages.*;

public class IngTest {

    MainPage mainPage;
    TransactionOptionPage transactionOptionPage;
    TransactionDetails transactionDetails;
    TransactionSummary transactionSummary;
    HistoryTab historyTab;

    @BeforeTest
    public void before() {
        mainPage = new MainPage();
        transactionOptionPage = new TransactionOptionPage();
        transactionDetails = new TransactionDetails();
        transactionSummary = new TransactionSummary();
        historyTab = new HistoryTab();
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @AfterTest
    public void after() {
        SingletonWebdriver.getDriver().quit();
    }

    @Test
    public void transferTest() {
        mainPage.closeCookiesWindow();
        mainPage.chooseTransactionButton();
        transactionOptionPage.chooseHolidaysButton();
        transactionOptionPage.copyMyAccountNumber();
        transactionOptionPage.chooseUsualTransfer();
        transactionDetails.fillAddressContainer();
        transactionDetails.fillTransferAmount();
        transactionDetails.fillTransferTitle();
        transactionDetails.chooseNextButton();
        Assert.assertTrue(transactionSummary.checkAccountNumber());
        transactionSummary.chooseConfirmTrannsaction();
        Assert.assertEquals(transactionSummary.getConfirmationMessage(), "Przelew został wykonany");
    }

    @Test(dependsOnMethods = "transferTest")
    public void hostoryTabTest() {
        transactionSummary.chooseHistoryTab();
        historyTab.chooseLastTransfer();
        Assert.assertEquals(historyTab.checkHistoryAccountNumber(), TransactionOptionPage.accountNumber);
        Assert.assertEquals(historyTab.checkHistoryTransferAmount(),"-" + TransactionDetails.myTransferAmount + " PLN");
    }

}
