package pl.b2b;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Test {

WebDriver webDriver;

MainPage mainPage;
TransactionsPage transactionsPage;
TransactionPage transactionPage;

@BeforeTest

    public void beforeTest(){
      mainPage = new MainPage();
      transactionsPage = new TransactionsPage();
      transactionPage =new TransactionPage();

      SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

@AfterTest
    public void afterTest(){
       SingletonWebdriver.getDriver().quit();
    }

@org.testng.annotations.Test

public void ownTransactionTest(){
    SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    mainPage.performTransaction();
    transactionsPage.performVacation();
    transactionsPage.copyAccountNumber();
    transactionPage.getTransaction();
    transactionPage.putAdress();
    transactionPage.putAmount();

}

}
