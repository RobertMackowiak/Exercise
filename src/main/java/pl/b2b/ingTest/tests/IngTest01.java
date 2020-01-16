package pl.b2b.ingTest.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.pages.AccountHistoryPage;
import pl.b2b.ingTest.pages.MainPage;
import pl.b2b.ingTest.pages.SummaryPage;
import pl.b2b.ingTest.pages.TransactionsPage;

public class IngTest01 {

    private MainPage mainPage;
    private TransactionsPage transactionsPage;
    private SummaryPage summaryPage;
    private AccountHistoryPage accountHistoryPage;

    @BeforeTest
    public void beforeTest() {
        mainPage = new MainPage();
        transactionsPage = new TransactionsPage();
        summaryPage = new SummaryPage();
        accountHistoryPage = new AccountHistoryPage();

        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @AfterTest
    public void afterTest() {
        SingletonWebdriver.getDriver().quit();
    }

    @Test
    @Parameters({"recipientName", "transactionAmount", "transferTitle"})
    public void transferTest(@Optional("Johnnie Walker") String recipientName,
                             @Optional("399") String transactionAmount,
                             @Optional("for Scotch Whisky") String transferTitle) {
        mainPage.clickOnCloseCookiePolicyBtn();
        mainPage.clickExecuteTransactionBtn();
        transactionsPage.clickOnHolidayAccount();
        transactionsPage.copyMyAccountNumber();
        transactionsPage.clickOnUsualTransfer();
        transactionsPage.fillRecipientName(recipientName);
        transactionsPage.fillTransferAmount(transactionAmount);
        transactionsPage.fillTransferTitle(transferTitle);
        transactionsPage.clickOnContinueBtn();
        Assert.assertTrue(summaryPage.accountsNumbersComparison1());
        summaryPage.clickOnAcceptBtn();
        Assert.assertEquals(summaryPage.getConfirmMessage(), "Przelew został wykonany");
    }

    @Test(dependsOnMethods = "transferTest")
    @Parameters({"transactionAmount"})
    public void accountHistoryTest(@Optional("399") String transactionAmount) {
        summaryPage.clickOnCheckAccountHistoryBtn();
        accountHistoryPage.showLastTransactionDetails();
        Assert.assertTrue(accountHistoryPage.accountsNumbersComparison2());
        Assert.assertEquals(accountHistoryPage.getTransactionAmount(), transactionAmount);
    }
}
