package pl.b2b.ingTest.Tests;

import org.omg.PortableServer.ServantLocatorPackage.CookieHolder;
import org.testng.Assert;
import org.testng.annotations.*;
import pl.b2b.Pages.MainPage;
import pl.b2b.Pages.PageSummary;
import pl.b2b.Pages.TransactionOptionPage;
import pl.b2b.Pages.TransferHistory;
import pl.b2b.utils.ExeclRaport;
import pl.b2b.utils.ExelData;
import pl.b2b.utils.SingletonWebdriver;

import java.util.Iterator;
import java.util.List;

public class IngTest {
    MainPage mainPage;
    TransactionOptionPage transactionOptionPage;
    PageSummary pageSummary;
    TransferHistory transferHistory;
    String name;
    String surname;
    String address;
    String cash;
    String title;

    @DataProvider
    public Iterator<Object[]> dataProvider(){
        List<Object[]> list = ExelData.getAllDataExcel("C:\\Users\\B2B\\Desktop\\TestData.xlsx", "Sheet1");
        return list.iterator();
    }

    @BeforeMethod
    public void beforTest() {
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
        mainPage = new MainPage();
        transactionOptionPage = new TransactionOptionPage();
        pageSummary = new PageSummary();
        transferHistory = new TransferHistory();

//        ExelData.openExel("C:\\Users\\B2B\\Desktop\\TestData.xlsx", "Sheet1");
//        name = ExelData.getCellData(1,0);
//        surname = ExelData.getCellData(1,1);
//        address = ExelData.getCellData(1,2);
//        cash = ExelData.getNumericCellData(1, 3);
//        title = ExelData.getCellData(1,4);


    }
    @AfterMethod
    public void afterTest(){
        SingletonWebdriver.quitDriver();
        ExelData.closeFile();

    }

    @Test(dataProvider = "dataProvider")
    public void test(String name, String surname, String address, String cash, String title) {
        try {

            mainPage.clickOnShutDownnCookies();
            mainPage.clickExecutionBtn();
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
        } catch(Exception e) {
            ExeclRaport.wrihtToExcell("C:\\Users\\B2B\\Desktop\\Raport.xlsx", "Arkusz2", name, surname, address, cash, title, false);
            throw  e;


        }


    }

    @Test(dependsOnMethods = "test")
    public void transferHistory() {
    pageSummary.setClickOnHistoryTransferButton();
    transferHistory.clickOnTransferDeatailsHistory();
    Assert.assertTrue(transferHistory.getAccountNumberAfterTransaction());
    Assert.assertTrue(transferHistory.compareTransferValueAfterTransaction());
    }

}
