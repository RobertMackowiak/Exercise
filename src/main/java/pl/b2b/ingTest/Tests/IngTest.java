package pl.b2b.ingTest.Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import pl.b2b.Pages.*;
import pl.b2b.WebPageMethods;
import pl.b2b.utils.ExeclRaport;
import pl.b2b.utils.ExelData;
import pl.b2b.utils.MySqlData;
import pl.b2b.utils.SingletonWebdriver;

import java.util.Iterator;
import java.util.List;

public class IngTest {
    MainPage mainPage;
    TransactionOptionPage transactionOptionPage;
    PageSummary pageSummary;
    TransferHistory transferHistory;
    SavingAccount savingAccount;
    AttorneysPage attorneysPage;
    RecipientsPage recipientsPage;
    String name;
    String surname;
    String address;
    String ammount;
    String title;

    @DataProvider
    public Iterator<Object[]> dataProvider() {
        List<Object[]> list = ExelData.getAllDataExcel("C:\\Users\\B2B\\Desktop\\TestData.xlsx", "Sheet1");
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProviderFromSql() {
        List<Object[]> dataListFromSql = MySqlData.getFromBase();
        return dataListFromSql.iterator();
    }

    @BeforeTest
    public void beforTest() {
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
        mainPage = new MainPage();
        transactionOptionPage = new TransactionOptionPage();
        pageSummary = new PageSummary();
        transferHistory = new TransferHistory();
        savingAccount = new SavingAccount();
        attorneysPage = new AttorneysPage();
        recipientsPage = new RecipientsPage();

//        ExelData.openExel("C:\\Users\\B2B\\Desktop\\TestData.xlsx", "Sheet1");
//        name = ExelData.getCellData(1,0);
//        surname = ExelData.getCellData(1,1);
//        address = ExelData.getCellData(1,2);
//        cash = ExelData.getNumericCellData(1, 3);
//        title = ExelData.getCellData(1,4);


    }

//    @AfterTest
//    public void afterTest() {
//        SingletonWebdriver.quitDriver();
////        ExelData.closeFile();
//
//    }

    @Test(dataProvider = "dataProvider")
    public void test(String name, String surname, String address, String cash, String title) {
        try {

            mainPage.clickOnShutDownnCookies();
            Reporter.log("Cookies closed"); // metoda pobiera logi po danej akcji(powyżej)
            mainPage.clickExecutionBtn();
            Reporter.log("Click execution button");
            transactionOptionPage.chooseHolidaysButton();
            transactionOptionPage.copyMyAccount();
            transactionOptionPage.setUsualTransfer();
            transactionOptionPage.setNameAndAddress(name + " " + surname + " " + address);
            transactionOptionPage.setAmmount(cash);
            transactionOptionPage.setTitle(title);
            transactionOptionPage.setNextPageButton();
            Assert.assertTrue(pageSummary.cutGetAccountNumber());
            pageSummary.setClickOnButtonConfirm();
            pageSummary.setGetTransferAmount();
            Assert.assertEquals(pageSummary.setGetConfirmMessage(), "Przelew został wykonany");
            ExeclRaport.wrihtToExcell("C:\\Users\\B2B\\Desktop\\Raport.xlsx", "Arkusz2", name, surname, address, cash, title, true);
            MySqlData.sendToBase(name, surname, address, cash, title, "Pozytywny");
        } catch (Exception e) {
            WebPageMethods.takeAScreenShoot();
            ExeclRaport.wrihtToExcell("C:\\Users\\B2B\\Desktop\\Raport.xlsx", "Arkusz2", name, surname, address, cash, title, false);
            MySqlData.sendToBase(name, surname, address, cash, title, "Negatywny");
            throw e;


        }


    }

    @Test(dependsOnMethods = "test")
    public void transferHistory() {
        pageSummary.setClickOnHistoryTransferButton();
        transferHistory.clickOnTransferDeatailsHistory();
        Assert.assertTrue(transferHistory.getAccountNumberAfterTransaction());
        Assert.assertTrue(transferHistory.compareTransferValueAfterTransaction());
    }

    @Test
    public void test3() {
        mainPage.clickOnShutDownnCookies();
        mainPage.clickMyFinancesButton();
        mainPage.clickOpenSaveingAccount();
        attorneysPage.clickOnaddAttoray1();
        attorneysPage.clickAddAttorney();
        attorneysPage.setNameAndSurname("Jacek");
        attorneysPage.clickDropDown();
        attorneysPage.clickOnPassport();
        attorneysPage.stIdNumber("142513");
        attorneysPage.clickForwardButton();
        attorneysPage.waitForAneks();
        attorneysPage.clickForwardButton();
        attorneysPage.clickOnConfirmButton();
        Assert.assertEquals(attorneysPage.getTextToCompare(), "Pełnomocnik został dodany");
    }

    @Test(dependsOnMethods = "test3")
    public void test4() {
        mainPage.clickMyFinancesButton();
        mainPage.clickOpenSaveingAccount();
        attorneysPage.clickOnaddAttoray1();
        attorneysPage.setClickRevokeButton();
        attorneysPage.clickOnNextButtonAfterRevoking();
        attorneysPage.clickConfirmationButtonAfterRevoking();
        mainPage.clickMyFinancesButton();
        mainPage.clickOpenSaveingAccount();
        attorneysPage.clickOnaddAttoray1();
        attorneysPage.setClickRevokeButton();
        attorneysPage.clickOnNextButtonAfterRevoking();
        attorneysPage.clickConfirmationButtonAfterRevoking();
    }

    @Test
    public void testIng5() {
        mainPage.clickOnShutDownnCookies();
        mainPage.clickOnServiceAndTools();
        mainPage.clickOnRecipient();
        recipientsPage.searchForRecipient("Tomek K");
        recipientsPage.setClickOnTomekK();
        recipientsPage.setClicnOnEditTomekK();
        recipientsPage.sendCellNumber("111222333");
        recipientsPage.setClickOnNameButton();
        recipientsPage.clickOnSaveButtonAfetrEditionTomekK();
        recipientsPage.clikOnConfirmationButton();
        Assert.assertEquals(recipientsPage.getTextOfAfterConfirmation(), "Odbiorca został zaktualizowany");
    }

    @Test
    public void testWithChild() {
        mainPage.clickOnShutDownnCookies();
        mainPage.clickOnServiceAndTools();
        mainPage.clickOnSaveingTargets();
        mainPage.setClickOnAddAim();
        mainPage.setClickOnChildButton();
        mainPage.sendValueOfNameOfTheAim("Maluch");
        mainPage.sendCashAmmoount("10000");
        mainPage.setClickOnNextButtonAfterChieldValue();
        mainPage.markCheckBoxToFirstAmount();
        mainPage.moveFirstDragAndDrop();
        mainPage.clickOnRandomElement();
        mainPage.moveSecondDragAndDrop();



    }
}
