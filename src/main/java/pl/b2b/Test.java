package pl.b2b;


import org.testng.Assert;
import org.testng.annotations.*;
import pl.b2b.ingTest.MainPage;
import pl.b2b.ingTest.MakeTransactionPage;
import pl.b2b.ingTest.NormalTransactionSummaryPage;

public class Test {

    MainPage mainPage;
    MakeTransactionPage makeTransactionPage;
    NormalTransactionSummaryPage normalTransactionSummaryPage;


    @BeforeTest
    public void before(){
        mainPage = new MainPage();
        makeTransactionPage = new MakeTransactionPage();
        normalTransactionSummaryPage = new NormalTransactionSummaryPage();
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @AfterTest
    public void after(){
        SingletonWebdriver.getDriver().quit();
    }

   @org.testng.annotations.Test
    public void test(){
        mainPage.clickOnWykonaj();
        makeTransactionPage.clickVacationAccount();
        makeTransactionPage.getTextFromAccountNumber();
        makeTransactionPage.clickNormalTransaction();
        makeTransactionPage.fillNameAndAdress("Krzysiu","Makintosz","Kononowicza 2");
        makeTransactionPage.fillCashAmount("200");
        makeTransactionPage.fillTitle("Kredyt");
        makeTransactionPage.clickForwardButton();
        Assert.assertTrue(normalTransactionSummaryPage.checkAccountNumber());
        normalTransactionSummaryPage.clickConfirmButton();
        Assert.assertEquals(normalTransactionSummaryPage.getConfirmMessage(),"Przelew został wykonany");
    }

}
