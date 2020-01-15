package pl.b2b;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.b2b.ingTest.pages.*;


public class ingFirstTest {

    private MainPage mainPage;
    private TransactionsPage transactionsPage;

    @BeforeTest
    public void beforeTest() {
        mainPage = new MainPage();
        transactionsPage = new TransactionsPage();

        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

//    @AfterTest
//    public void afterTest() {
//        SingletonWebdriver.getDriver().quit();
//    }

    @Test
    public void ingTest1() {
        mainPage.clickMakeTransactionBtn();
    }

    @Test(dependsOnMethods = "ingTest1")
    public void ingTest2() {
        transactionsPage.clickOnAccountNo3();
    }

}


//uzupełnij dane do przelewu
//kliknij dalej
