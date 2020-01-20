package pl.b2b.ingTest.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.pages.*;
import pl.b2b.ingTest.utils.ExcelData;
import pl.b2b.ingTest.utils.ExcelReport;

import java.util.Iterator;
import java.util.List;

public class TestIng {
    MainPage mainPage;
    ChooseAccountPage chooseAccountPage;
    TransactionPage transactionPage;
    DetailsPage detailsPage;
    PageSummary pageSummary;
    HistoryPage historyPage;

    String name;
    String surname;
    String address;
    String amount;
    String title;

    @DataProvider
    public Iterator<Object[]> dataProvider(){
        List<Object[]> list = ExcelData.getAllDataExcel("C:\\Users\\b2b\\Desktop\\TestData.xlsx", "Sheet1");
        return list.iterator();
    }

    @BeforeMethod
    public void beforeTest(){
        mainPage = new MainPage();
        chooseAccountPage = new ChooseAccountPage();
        transactionPage = new TransactionPage();
        detailsPage = new DetailsPage();
        pageSummary = new PageSummary();
        historyPage = new HistoryPage();
//        ExcelData.openExcel("C:\\Users\\b2b\\Desktop\\TestData.xlsx", "Sheet1");
//        name = ExcelData.getCellData(1,0);
//        surname = ExcelData.getCellData(1,1);
//        address = ExcelData.getCellData(1,2);
//        amount = ExcelData.getNumericCellData(1,3);
//        title = ExcelData.getCellData(1,4);
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");

    }

    @AfterMethod
    public void afterTest(){
        ExcelData.closeFile();
        SingletonWebdriver.quitDriver();
    }

    @Test(dataProvider = "dataProvider")
    public void testIng(String name, String surname, String address, String amount, String title) {
       try {
           mainPage.closeCookies();
           mainPage.clickTransactionButton();
           chooseAccountPage.accountNrComparison();
           chooseAccountPage.clickVacationAccountButton();
           transactionPage.chooseRegularTransfer();
           detailsPage.putNameAndAddress(name + " " + surname + " " + address);
           detailsPage.putAmount(amount);
           detailsPage.putTitle(title);
           detailsPage.clickNext();
           Assert.assertTrue(pageSummary.vacationAccountComparison());
           pageSummary.clickAcceptButton();
           Assert.assertEquals(pageSummary.getConfirmMessage(), "Przelew został wykonany");
           ExcelReport.writeToExcel("C:\\Users\\b2b\\Desktop\\TestReport.xlsx", "Sheet1", name, surname, address, amount, title, true );
       } catch(AssertionError|Exception e){
           ExcelReport.writeToExcel("C:\\Users\\b2b\\Desktop\\TestReport.xlsx", "Sheet1", name, surname, address, amount, title, false );
           throw e;

       }
    }

    @Test (dependsOnMethods = "testIng")
    public void testIng2(){
        pageSummary.clickHistoryButton();
        historyPage.clickTransferDetails();
        Assert.assertTrue(historyPage.anotherComparison());
//        Assert.assertEquals(historyPage.getFinalAmount(), detailsPage.transferAmount);
    }


}
