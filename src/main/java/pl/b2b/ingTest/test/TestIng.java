package pl.b2b.ingTest.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.pages.*;

public class TestIng {
    MainPage mainPage;
    ChooseAccountPage chooseAccountPage;
    TransactionPage transactionPage;
    DetailsPage detailsPage;
    PageSummary pageSummary;
    HistoryPage historyPage;

    @BeforeTest
    public void beforeTest(){
        mainPage = new MainPage();
        chooseAccountPage = new ChooseAccountPage();
        transactionPage = new TransactionPage();
        detailsPage = new DetailsPage();
        pageSummary = new PageSummary();
        historyPage = new HistoryPage();

        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @AfterTest
    public void afterTest(){
        SingletonWebdriver.getDriver().quit();
    }

    @Test
    public void testIng() {
        mainPage.closeCookies();
        mainPage.clickTransactionButton();
        chooseAccountPage.accountNrComparison();
        chooseAccountPage.clickVacationAccountButton();
        transactionPage.chooseRegularTransfer();
        detailsPage.putDetails();
        detailsPage.clickNext();
        Assert.assertTrue(pageSummary.vacationAccountComparison());
        pageSummary.clickAcceptButton();
        Assert.assertEquals(pageSummary.getConfirmMessage(), "Przelew został wykonany");
    }

    @Test (dependsOnMethods = "testIng")
    public void testIng2(){
        pageSummary.clickHistoryButton();
        historyPage.clickTransferDetails();
        Assert.assertTrue(historyPage.anotherComparison());
        Assert.assertEquals(historyPage.getFinalAmount(), detailsPage.transferAmount);
    }


}
