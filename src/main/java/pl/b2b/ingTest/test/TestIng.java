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
    SavingAccount savingAccount;
    AttorneysPage attorneysPage;


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

    @BeforeTest
    public void beforeTest(){
        mainPage = new MainPage();
        chooseAccountPage = new ChooseAccountPage();
        transactionPage = new TransactionPage();
        detailsPage = new DetailsPage();
        pageSummary = new PageSummary();
        historyPage = new HistoryPage();
        savingAccount = new SavingAccount();
        attorneysPage = new AttorneysPage();
//        ExcelData.openExcel("C:\\Users\\b2b\\Desktop\\TestData.xlsx", "Sheet1");
//        name = ExcelData.getCellData(1,0);
//        surname = ExcelData.getCellData(1,1);
//        address = ExcelData.getCellData(1,2);
//        amount = ExcelData.getNumericCellData(1,3);
//        title = ExcelData.getCellData(1,4);
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");

    }

    @AfterTest
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
    @Test
    public void testIng3(){
        mainPage.closeCookies();
        mainPage.clickMyFinancesbutton();
        mainPage.clickOpenSavingsAccount();
        savingAccount.clickAttorneyButton();
        attorneysPage.clickAddAttorneyButton();
        attorneysPage.setNameAndSurname("sdgfjsdhgjdsg");
        attorneysPage.choosePassport();
        attorneysPage.setIdNumber("sahfsfj");
        attorneysPage.clickForwardButton();
        attorneysPage.waitForAnnex();
        attorneysPage.clickForwardButton();
        attorneysPage.clickConfirmationButton();
        Assert.assertEquals(attorneysPage.getConfirmationText(), "Pełnomocnik został dodany");

    }
    @Test(dependsOnMethods = "testIng3")
    public void testIng4(){
        mainPage.clickMyFinancesbutton();
        mainPage.clickOpenSavingsAccount();
        savingAccount.clickAttorneyButton();
        attorneysPage.clickRevokeAttorney();
        mainPage.clickMyFinancesbutton();
        mainPage.clickOpenSavingsAccount();
        savingAccount.clickAttorneyButton();
        attorneysPage.clickRevokeAttorney();

    }


}
