package pl.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.b2b.MainPage;
import pl.b2b.SingletonWebdriver;
import pl.b2b.SummaryPage;

import java.util.concurrent.TimeUnit;

public class IngTest {

MainPage mainPage;
SummaryPage summaryPage;



@BeforeTest
    public void before () {
    mainPage = new MainPage();
    summaryPage = new SummaryPage();
    SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
}

@AfterTest
    public void after () {
    SingletonWebdriver.getDriver().quit();
}

@Test
    public void bankTest () {
    mainPage.newTransactionButtonClick();
    mainPage.setTargetHolidayAccountClick();
    mainPage.accountNumberCopy();
    mainPage.traditionalTransferButtonClick();
    mainPage.setTransactionValueAndGo();
    mainPage.clickForwardButton();
    summaryPage.getSecondTimeAccount();
    Assert.assertTrue(summaryPage.compareAccount());
}





}
