package pl.b2b.ingTest.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.pages.MainPage;
import pl.b2b.ingTest.pages.PageSummary;
import pl.b2b.ingTest.pages.TransactionsPage;

public class IngTest01 {

    private MainPage mainPage;
    private TransactionsPage transactionsPage;
    private PageSummary pageSummary;

    @BeforeTest
    public void beforeTest() {
        mainPage = new MainPage();
        transactionsPage = new TransactionsPage();
        pageSummary = new PageSummary();

        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @AfterTest
    public void afterTest() {
        SingletonWebdriver.getDriver().quit();
    }

    @Test
    public void transferTest() {
        mainPage.clickOnCloseCookiePolicyBtn();
        mainPage.clickExecuteTransactionBtn();
        transactionsPage.clickOnHolidayAccount();
        transactionsPage.copyMyAccountNumber();
        transactionsPage.clickOnUsualTransfer();
        transactionsPage.fillRecipientName();
        transactionsPage.fillTransferAmount();
        transactionsPage.fillTransferTitle();
        transactionsPage.clickOnContinueBtn();
        Assert.assertTrue(pageSummary.accountsNumbersComparison());
        pageSummary.clickOnAcceptBtn();
        Assert.assertEquals(pageSummary.getConfirmMessage(), "Przelew został wykonany");
    }
}
