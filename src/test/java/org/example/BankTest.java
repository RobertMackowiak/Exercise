package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.b2b.pages.MainPage;
import pl.b2b.pages.TransactionPage;

import java.util.concurrent.TimeUnit;

public class BankTest {

    WebDriver webDriver;
    MainPage mainPage;
    TransactionPage transactionPage;

    @BeforeTest
    public void before(){
        System.setProperty("webdriver.gecko.driver", "C:/SeleniumDrivers/geckodriver.exe");
        transactionPage = new TransactionPage();
        mainPage = new MainPage();
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }


    @Test

    public void BankTest() {
        System.setProperty("webdriver.gecko.driver", "C:/SeleniumDrivers/geckodriver.exe");
        webDriver.get("https://login.ingbank.pl/mojeing/demo/#home");
        mainPage.makeTransaction();
        transactionPage.chooseAccount();

    }
}
