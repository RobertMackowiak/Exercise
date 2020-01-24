package pl.b2b.bankIng.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import pl.b2b.SingletonWebDriver;
import pl.b2b.bankIng.pages.*;
import pl.b2b.bankIng.utils.ExcelData;
import pl.b2b.bankIng.utils.ExcelRaport;
import pl.b2b.bankIng.utils.MySqlData;
import pl.b2b.bankIng.utils.WebPageMethods;

import java.util.Iterator;
import java.util.List;

public class BankIngTest {

    MainPage mainPage;
    ExecuteTranstactionPage executeTranstactionPage;
    NormalTransactionPage normalTransactionPage;
    HistoryOfTransactionPage historyOfTransactionPage;
    SavingAccountPage savingAccount;
    AttorneyPage attorneyPage;
    RecipientsPage recipientsPage;
    GoalsPage goalsPage;

    String name;
    String lastName;
    String adres;
    String amount;
    String title;

    @DataProvider
    public Iterator<Object[]> dataProvider() {

        List<Object[]> list = ExcelData.getAllDataExcel("C:\\Users\\B2B021\\Desktop\\TestData.xlsx", "Sheet1");

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderSql() {
        List<Object[]> list = MySqlData.getFromBase();

        return list.iterator();
    }

    @BeforeTest
    public void beforeTest() {
        mainPage = new MainPage();
        executeTranstactionPage = new ExecuteTranstactionPage();
        normalTransactionPage = new NormalTransactionPage();
        historyOfTransactionPage = new HistoryOfTransactionPage();
        savingAccount = new SavingAccountPage();
        attorneyPage = new AttorneyPage();
        recipientsPage = new RecipientsPage();
        goalsPage = new GoalsPage();
//        ExcelData.openExcel("C:\\Users\\B2B021\\Desktop\\TestData.xlsx", "Sheet1");
//        name = ExcelData.getCellData(1, 0);
//        lastName = ExcelData.getCellData(1, 1);
//        adres = ExcelData.getCellData(1, 2);
//        amount = ExcelData.getNumericCellData(1, 3);
//        title = ExcelData.getCellData(1, 4);
        SingletonWebDriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");

    }

    @AfterTest
    public void afterTest() {
//        ExcelData.closeFile();
//        SingletonWebdriver.quitDriver();
    }

    @Test(dataProvider = "dataProvider")
    public void bankTest(String name, String lastName, String adres, String amount, String title) {
        try {
            mainPage.clickCookiesButton();
            mainPage.clickExecuteTransactionButton();
            executeTranstactionPage.clickHolidayButton();
            executeTranstactionPage.copyAccountNumber();
            executeTranstactionPage.clickNormalTransaction();
//            normalTransactionPage.putInTextInLabels(name + " " + lastName + " " + adres, amount, title);

            Assert.assertEquals("47 1050 0028 2100 0023 0315 0001", executeTranstactionPage.getAccNumber());
            normalTransactionPage.clickConfirmButton();
            normalTransactionPage.checkTitle();
//            Assert.assertEquals(normalTransactionPage.getConfirmMessage(), "Przelew został wykonany");
//            ExcelRaport.writeToExcel("C:\\Users\\B2B021\\Desktop\\TestReport.xlsx", "Sheet1", name, lastName, adres, amount, title, true);
            MySqlData.sendToBase(name, lastName, adres, amount, title, "Pozytywny");
        } catch (AssertionError | Exception e) {
            WebPageMethods.takeAScreenShoot();
            MySqlData.sendToBase(name, lastName, adres, amount, title, "Negatywny");
//            ExcelRaport.writeToExcel("C:\\Users\\B2B021\\Desktop\\TestReport.xlsx", "Sheet1", name, lastName, adres, amount, title, false);
            throw e;
        }
    }

    @Test(dependsOnMethods = "bankTest")
    public void bankTest2() {
        normalTransactionPage.clickHistoryButton();
        historyOfTransactionPage.clickLastTransaction();
        historyOfTransactionPage.checkAccountAgain();
        Assert.assertEquals("47 1050 0028 2100 0023 0315 0001", historyOfTransactionPage.getLastAssertion());

    }

    @Test
    public void bankTest3() {
        mainPage.clickCookiesButton();
        mainPage.clickMyFinances();
        mainPage.clicOpenSavingsAccount();
        savingAccount.clickAttorneyButton();
        attorneyPage.clickAddAttorney();
        attorneyPage.putTextInNameAndSurname("Janusz Kowalski");
        attorneyPage.setIdList();
        attorneyPage.setIdNumber("79041986439");
        attorneyPage.clickNextButton();
        attorneyPage.waitForAneksIconShows();
        attorneyPage.clickConfirmButton();
        Assert.assertEquals(attorneyPage.getText(), "Pełnomocnik został dodany");
    }

    @Test(dependsOnMethods = "bankTest3")
    public void bankTest4() {
        mainPage.clickMyFinances();
        mainPage.clicOpenSavingsAccount();
        savingAccount.clickAttorneyButton();
        attorneyPage.clickRevokeButton();
        mainPage.clickMyFinances();
        mainPage.clicOpenSavingsAccount();
        savingAccount.clickAttorneyButton();
        attorneyPage.clickRevokeButton();
        mainPage.clickMyFinances();
        mainPage.clicOpenSavingsAccount();
        savingAccount.clickAttorneyButton();
    }

    @Test
    public void bankTest5() {
        mainPage.clickCookiesButton();
        mainPage.clickFinanceMeterButton();
        mainPage.clickServicesRecipient();
        recipientsPage.putNameInSearchRecipients();
        recipientsPage.clickSelectRecipient();
        recipientsPage.clickEditRecipient();
        recipientsPage.editphoneNumber();
        recipientsPage.clickRandomClick();
        recipientsPage.clickSaveButton();
        recipientsPage.clickConfirmButton();
        Assert.assertEquals(attorneyPage.getText(), "Pełnomocnik został dodany");
    }

    @Test(dataProvider = "dataProviderSql")
    public void bankTest6(String name, String surname, String adres, String title) {
        mainPage.clickCookiesButton();
        Reporter.log("Cookies Closed");
        mainPage.clickExecuteTransactionButton();
        Reporter.log("Transaction window open");
        executeTranstactionPage.clickHolidayButton();
        Reporter.log("Click holiday button");
        executeTranstactionPage.copyAccountNumber();
        executeTranstactionPage.clickNormalTransaction();
        Reporter.log("Click normal transaction button");
        normalTransactionPage.putInTextInLabels(name + " " + lastName + " " + adres, amount, title);
    }

    @Test
    public void bankTest7_Dziecko() {
        mainPage.clickCookiesButton();
        mainPage.clickFinanceMeterButton();
        mainPage.clickServiceGoalsButton();
        mainPage.clickAddNewGoal();
        goalsPage.clickChildrenButton();
        goalsPage.addNameOfGoalAndMoney("Studia", "200");
        goalsPage.clickStartAmountCheckBox();
        goalsPage.moveSlider1();
        goalsPage.clickRandomClick();
        goalsPage.moveSlider2();
//        goalsPage.clickConfirmButton();
//        Assert.assertEquals(goalsPage.getText(), "Twój cel został utworzony, życzymy powodzenia w oszczędzaniu");
    }

}


