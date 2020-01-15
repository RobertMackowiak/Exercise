package pl.b2b.IngTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.b2b.SingletonWebdriver;

public class IngTest {

    MainPage mainPage;
    TransactionOptionPage transactionOptionPage;
    TransactionDetails transactionDetails;
    TransactionSummary transactionSummary;
    ConfirmationPage confirmationPage;

    @BeforeTest
    public  void before(){
        mainPage = new MainPage();
        transactionOptionPage = new TransactionOptionPage();
        transactionSummary = new TransactionSummary();
        transactionDetails = new TransactionDetails();
        confirmationPage = new ConfirmationPage();
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @AfterTest
    public void after(){
        SingletonWebdriver.getDriver().quit();
    }

    @Test
    public void transferTest(){
        mainPage.chooseTransactionButton();
//        transactionOptionPage.chooseHolidaysButton();
//        transactionDetails.copyAccountNumber();
//        transactionDetails.chooseNormalTransactionButton();
//        transactionDetails.fillRecipientAddress();
//        transactionDetails.fillTransactionAmount();
//        transactionDetails.fillTransactionTitle();
//        transactionDetails.chooseNextButton();
    }

}
