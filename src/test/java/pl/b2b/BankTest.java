package pl.b2b;



import org.testng.Assert;
import org.testng.annotations.*;


public class BankTest {
    MainPage mainpage;
    TransactionPage transactionPage;

    @BeforeTest
    public void bankTest(){
        mainpage = new MainPage();
        transactionPage = new TransactionPage();


        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }


    @Test
    public void bankTest1(){
//        mainpage.closeCookie();
        mainpage.clickTransactionButton();
        transactionPage.clickWakacjeButton();
        transactionPage.regularTransactionButtonClick();
        transactionPage.getIbanNumber();
        transactionPage.setNameField();
        transactionPage.setAmount();
        transactionPage.setTitle();
        transactionPage.furtherButtonClick();
        Assert.assertTrue(transactionPage.ibanNumberCheck());
        transactionPage.confirmButtonClick();





    }



}
