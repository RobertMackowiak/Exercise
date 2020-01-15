package pl.b2b;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.b2b.pages.DirectAcc;
import pl.b2b.pages.HomePage;

public class ING_Test {
    HomePage homepage;
    DirectAcc directAcc;

    @Before
    public void beforeTest() {
        homepage = new HomePage();
        directAcc = new DirectAcc();
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @After
    public void afterTest() {
        SingletonWebdriver.getDriver().quit();
    }

    @Test
    public void testNr1() {
        homepage.clickTransfer();
    }


}
