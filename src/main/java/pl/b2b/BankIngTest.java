package pl.b2b;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.b2b.bankIngPages.ExecuteTranstactionPage;
import pl.b2b.bankIngPages.MainPage;
import pl.b2b.bankIngPages.NormalTransactionPage;
//import pl.b2bnetwork.clothingStore.Pages.*;

public class BankIngTest {

    MainPage mainPage;
    ExecuteTranstactionPage executeTranstactionPage;
    NormalTransactionPage normalTransactionPage;

    @BeforeTest
    public void beforeTest() {
        mainPage = new MainPage();
        executeTranstactionPage = new ExecuteTranstactionPage();
        normalTransactionPage = new NormalTransactionPage();
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @AfterTest
    public void afterTest() {
//        SingletonWebdriver.getDriver().quit();
    }

    @Test
    public void bankTest() {
//        mainPage.clickCookiesButton();
        mainPage.clickExecuteTransactionButton();
        executeTranstactionPage.copyAccountNumber();
        executeTranstactionPage.clickHolidayButton();
        executeTranstactionPage.clickNormalTransaction();
        normalTransactionPage.putInTextInLabels();
        Assert.assertEquals("47 1050 0028 2100 0023 0315 0001", executeTranstactionPage.getAccNumber());
        normalTransactionPage.clickConfirmButton();

    }

}
