package pl.b2b.ingTest.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.pages.*;

import pl.b2b.ingTest.utils.ExcelData;
import pl.b2b.ingTest.utils.ExcelRaport;
import pl.b2b.ingTest.utils.MySqlData;
import pl.b2b.ingTest.utils.WebPageMethods;

import java.util.Iterator;
import java.util.List;

public class IngTest {
    MainPage mainPage;
    TransactionPage transactionPage;
    TransactionSummary transactionSummary;
    HistoryPage historyPage;
    SavingAccount savingAccount;
    AttorneysPage attorneysPage;
    RecipientsPage recipientsPage;
//    String name;
//    String surname;
//    String address;
//    String amount;
//    String title;

    @DataProvider
    public Iterator<Object[]> dataProvider(){
        List<Object[]> List = ExcelData.getAllDataExcel("C:\\Users\\B2B\\Desktop\\TestData.xlsx", "Arkusz1");
        return List.iterator();
    }

    @BeforeTest
    public void beforeTest(){
        mainPage = new MainPage();
        transactionPage = new TransactionPage();
        transactionSummary = new TransactionSummary();
        historyPage = new HistoryPage();
        savingAccount = new SavingAccount();
        attorneysPage = new AttorneysPage();
        recipientsPage = new RecipientsPage();
//        ExcelData.openExcel("C:\\Users\\B2B\\Desktop\\TestData.xlsx", "Arkusz1");
//        name = ExcelData.getCellData(1,0);
//        surname = ExcelData.getCellData(1,1);
//        address = ExcelData.getCellData(1,2);
//        amount = ExcelData.getNumCellData(1,3);
//        title = ExcelData.getCellData(1,4);
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");

    }

    @Test
    public void dodawaniePełnomocnika(){
        mainPage.closeCookies();
        mainPage.clickMyFinancesButton();
        mainPage.clickOpenSavingAccount();
        savingAccount.clickAttorneyButton();
        attorneysPage.clickAddAttorneyButton();
        attorneysPage.inputName("Andrzej Duda");
        attorneysPage.setAttorneyId();
        attorneysPage.inputIdNumber("4546798684");
        attorneysPage.clickNextBtn();
        attorneysPage.waitAnnex();
        attorneysPage.clickNextBtn();
        attorneysPage.clickConfirmationButton();
        Assert.assertEquals(attorneysPage.getMessage(), "Pełnomocnik został dodany");

        // attorneysPage.clickRevokeButton();
    }

    @Test(dependsOnMethods = "dodawaniePełnomocnika")
    public void usuwaniePełnomocnika(){
        mainPage.clickMyFinancesButton();
        mainPage.clickOpenSavingAccount();
        savingAccount.clickAttorneyButton();
        attorneysPage.clickRevokeButton();
        mainPage.clickMyFinancesButton();
        mainPage.clickOpenSavingAccount();
        savingAccount.clickAttorneyButton();
        attorneysPage.clickRevokeButton();
        Assert.assertEquals(attorneysPage.getMessage(), "Pełnomocnik został usunięty");
    }

    @Test(dataProvider = "dataProvider")
    public void testIng(String name, String surname, String address, String amount, String title) {
        try {
            mainPage.closeCookies();
            mainPage.clickExecuteTransactionBtn();
            transactionPage.clickHolidayButton();
            transactionPage.copyMyAccountNumber();
            transactionPage.clickRegularTransferBtn();
            transactionPage.putNameAndAddress(name + " " + surname + " " + address);
            transactionPage.putAmount(amount);
            transactionPage.putTitle(title);
            transactionPage.clickNextBtn();
            Assert.assertTrue(transactionSummary.vacationAccNumbersComparison());
            transactionSummary.clickAcceptButton();

            Assert.assertEquals(transactionSummary.getConfirmMessage(), "Przelew został wykonany");
            ExcelRaport.writeToExcel("C:\\Users\\B2B\\Desktop\\TestRecord.xlsx", "Arkusz1", name, surname, address, amount, title, true);
            MySqlData.sendToBase(name, surname, address, amount, title, "Pozytywny");
        }catch(AssertionError|Exception e){
            WebPageMethods.takeAScreenshot();
            ExcelRaport.writeToExcel("C:\\Users\\B2B\\Desktop\\TestRecord.xlsx", "Arkusz1", name, surname, address, amount, title, false);
            MySqlData.sendToBase(name, surname, address, amount, title, "Negatywny");
            throw e;
        }
    }

    @Test
    public void testIng5(){
        mainPage.closeCookies();
        mainPage.clickServicesAndTools();
        mainPage.clickRecipients();
        recipientsPage.useSearchRecipients("Tomek K");
        recipientsPage.clickArrowContainer();
        recipientsPage.clickDetailsButton();
        recipientsPage.inputPhoneNumber("456456321");
        recipientsPage.clickNameField();
        recipientsPage.clickSaveButton();
        attorneysPage.clickConfirmationButton();
        Assert.assertEquals(attorneysPage.getMessage(), "Odbiorca został zaktualizowany");

    }

    @Test
    @Parameters({"name", "surname", "address", "title"})
    public void testIng6(String name, String surname, String address, String title){
        mainPage.closeCookies();
        mainPage.clickExecuteTransactionBtn();
        transactionPage.clickHolidayButton();
        transactionPage.copyMyAccountNumber();
        transactionPage.clickRegularTransferBtn();
        transactionPage.putNameAndAddress(name + " " + surname + " " + address);
        transactionPage.putAmount(transactionPage.getAmount());
        transactionPage.putTitle(title);

    }

    @Test (dependsOnMethods = "testIng")
    public void testIng2(){
        transactionSummary.clickHistoryButton();
        historyPage.clickFirstDetails();
        Assert.assertTrue(historyPage.secondComparison());
        Assert.assertEquals(historyPage.showNextAmount(), transactionPage.transferAmount);
    }



//    @AfterTest
//    public void afterTest(){
////        ExcelData.closeFile();
//        SingletonWebdriver.quitDriver();

//    }
}