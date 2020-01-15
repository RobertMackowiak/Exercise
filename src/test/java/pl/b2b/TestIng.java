package pl.b2b;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.b2b.IngTest.*;

public class TestIng {
    MainPage mainPage;
    ChooseAccountPage chooseAccountPage;
    TransactionPage transactionPage;
    DetailsPage detailsPage;

    @BeforeTest
    public void beforeTest(){
        mainPage = new MainPage();
        chooseAccountPage = new ChooseAccountPage();
        transactionPage = new TransactionPage();
        detailsPage = new DetailsPage();

        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }
    @AfterTest
    public void afterTest(){SingletonWebdriver.getDriver().quit();
    }

    @Test
    public void TestIng(){

        mainPage.clickTransactionButton();


    }

}
