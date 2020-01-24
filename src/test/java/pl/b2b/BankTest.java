package pl.b2b;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import pl.b2b.pages.*;
import pl.b2b.utils.ExcelData;
import pl.b2b.utils.ExcelRaport;
import pl.b2b.utils.MySqlData;
import pl.b2b.utils.WebPageMethods;

import java.util.Iterator;
import java.util.List;


public class BankTest {
    MainPage mainpage;
    TransactionPage transactionPage;
    SavingsAccount savingsAccount;
    AttorneysPage attorneysPage;
    RecipientPage recipientPage;
    EditSummaryPage editSummaryPage;
    GoalsPage goalsPage;

    String name;
    String surname;
    String address;
    String amount;
    String title;

    @DataProvider
    public Iterator<Object[]> dataProvider(){
        List<Object[]> list = ExcelData.getAllDataExcel("C:\\Users\\b2b_2\\Desktop\\TestData.xlsx", "Arkusz1");

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loadData(){
        List<Object[]> list = MySqlData.getFromBase();

        return list.iterator();
    }

    @BeforeTest
    public void before() {
        mainpage = new MainPage();
        transactionPage = new TransactionPage();
        savingsAccount = new SavingsAccount();
        attorneysPage = new AttorneysPage();
        recipientPage = new RecipientPage();
        editSummaryPage = new EditSummaryPage();
        goalsPage = new GoalsPage();

//        ExcelData.openExcel("C:\\Users\\b2b_2\\Desktop\\TestData.xlsx", "Arkusz1");
//        name = ExcelData.getCellData(1, 0);
//        surname = ExcelData.getCellData(1, 1);
//        address = ExcelData.getCellData(1, 2);
//        amount = ExcelData.getNumericCellData(1, 3);
//        title = ExcelData.getCellData(1, 4);
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");

    }

//    @AfterTest
//    public void after() {
//        SingletonWebdriver.quitDriver();
////        ExcelData.closeFile();
//    }

    @Test (priority = -1, dataProvider = "dataProvider")
    public void bankTest1(String name, String surname, String address, String amount, String title) {
        try {
            mainpage.closeCookies();
            mainpage.clickTransactionButton();
            transactionPage.clickWakacjeButton();
            transactionPage.regularTransactionButtonClick();
            transactionPage.getIbanNumber();
            transactionPage.setTransactionFields(name + " " + surname + " " + address, amount, title);
//        transactionPage.setNameField();
//        transactionPage.setAmount();
//        transactionPage.setTitle();
            transactionPage.furtherButtonClick();
            Assert.assertTrue(transactionPage.ibanNumberCheck());
            transactionPage.confirmButtonClick();
//            Assert.assertEquals(transactionPage.getConfirmMessage(), "Przelew został wykonany");
            Assert.assertEquals(transactionPage.getConfirmMessage(), "Przelew został wykonany");

//        Assert.assertTrue(transactionPage.getConfirmMessage().equals("Przelew został wykonany"));
//        ExcelData.setCellData(result);
            ExcelRaport.writeToExcel("C:\\Users\\b2b_2\\Desktop\\TestData.xlsx", "Arkusz2", name, surname, address, amount, title, true);
            MySqlData.sendToBase(name, surname, address, amount, title, "Pozytywny");
        } catch (AssertionError | Exception e) {
            WebPageMethods.sreenshotMaker();
            ExcelRaport.writeToExcel("C:\\Users\\b2b_2\\Desktop\\TestData.xlsx", "Arkusz2", name, surname, address, amount, title, false);
            MySqlData.sendToBase(name, surname, address, amount, title, "Negatywny");
            throw e;
        }


    }

    @Test
    public void bankTest2(){
        mainpage.closeCookies();
        mainpage.clickMyFinancesButton();
        mainpage.clickMySavingsButton();
        savingsAccount.clickAttorneysButton();
        attorneysPage.addAttorneyClick();
        attorneysPage.nameOfAttorney("Krzychu");
        attorneysPage.selectIDPesel();
        attorneysPage.setIDNumber("vawesoak");
        attorneysPage.clickContinueButton();
        attorneysPage.clickConfirmButton();
        Assert.assertTrue(attorneysPage.getText().equals("Pełnomocnik został dodany"));

}

    @Test (dependsOnMethods = "bankTest2")
    public void bankTest3(){
        mainpage.clickMyFinancesButton();
        mainpage.clickMySavingsButton();
        savingsAccount.clickAttorneysButton();
        attorneysPage.clickRevokeButton();
        attorneysPage.confirmDeleting();
        attorneysPage.clickConfirmButton();
        Assert.assertTrue(attorneysPage.getText().equals("Pełnomocnik został usunięty"));

        mainpage.clickMyFinancesButton();
        mainpage.clickMySavingsButton();
        savingsAccount.clickAttorneysButton();
        attorneysPage.clickRevokeButton();
        attorneysPage.confirmDeleting();
        attorneysPage.clickConfirmButton();
        Assert.assertTrue(attorneysPage.getText().equals("Pełnomocnik został usunięty"));

    }

    @Test
    public void bankTest4(){
        String number = "600 600 600";
        mainpage.closeCookies();
        mainpage.clickFinanceMeterButton();
        mainpage.clickRecipientButton();
        recipientPage.inputRecipient("Tomek K.");
        recipientPage.selectRecipientButton();
        recipientPage.editRecipientButton();
        editSummaryPage.inputNumberField(number);
        editSummaryPage.saveButtonClick();
        editSummaryPage.getSavedNumber();
        Assert.assertEquals(editSummaryPage.getSavedNumber(), "+48 " + number);

    }

    @Test (dataProvider = "loadData")
    public void bankTest5(String name, String surname, String address, String title){
        mainpage.closeCookies();
        Reporter.log("Cookie closed");
        mainpage.clickTransactionButton();
        Reporter.log("Transaction window open", true);
        transactionPage.clickWakacjeButton();
        Reporter.log("Holiday button clicked", true);
        transactionPage.getMoney();
        transactionPage.regularTransactionButtonClick();
        transactionPage.getIbanNumber();
        transactionPage.setTransactionFields(name + " " + surname + " " + address, transactionPage.getMoney(), title);
        transactionPage.furtherButtonClick();
        Assert.assertTrue(transactionPage.ibanNumberCheck());
        transactionPage.confirmButtonClick();
        Assert.assertEquals(transactionPage.getConfirmMessage(), "Przelew został wykonany");

    }

    @Test
    public void bankTest6(){
        mainpage.closeCookies();
        mainpage.clickFinanceMeterButton();
        mainpage.clickserviceGoalsButton();
        goalsPage.clickAddGoalButton();
        goalsPage.clickChildButton();
        goalsPage.setNewNameField("Bachor");
        goalsPage.setAmountField("2500");
        goalsPage.clickNextButton();
        goalsPage.clickCheckbox();
        goalsPage.moveSlider1();
//        goalsPage.clickMonthField();
        goalsPage.moveSlider2();


    }

}
