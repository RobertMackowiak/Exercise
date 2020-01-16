package pl.b2b;


import org.testng.Assert;
import org.testng.annotations.*;
import pl.b2b.ingTest.MainPage;
import pl.b2b.ingTest.MakeTransactionPage;
import pl.b2b.ingTest.NormalTransactionSummaryPage;
import pl.b2b.utils.ExcelData;

public class Test {

    MainPage mainPage;
    MakeTransactionPage makeTransactionPage;
    NormalTransactionSummaryPage normalTransactionSummaryPage;


    @DataProvider(name = "Test")
    public Object[][] data(){
        return null;
    }

    @BeforeTest
    public void before(){
        mainPage = new MainPage();
        makeTransactionPage = new MakeTransactionPage();
        normalTransactionSummaryPage = new NormalTransactionSummaryPage();
        try {
            ExcelData.setExcelFile("C:/Users/konra/Desktop/TestData.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");
    }

    @AfterTest
    public void after(){
        SingletonWebdriver.getDriver().quit();
        ExcelData.closeFiles();
    }

   @org.testng.annotations.Test
    public void test(){
       String name = null;
       String surname = null;
       String adress = null;
       String cashAmount = null;
       String title = null;
       try {
           name = ExcelData.getCellData(1,0);
           surname = ExcelData.getCellData(1,1);
           adress = ExcelData.getCellData(1,2);
           cashAmount = ExcelData.getNumericCellData(1,3);
           title = ExcelData.getCellData(1,4);
       } catch (Exception e) {
           e.printStackTrace();
       }
       mainPage.clickOnWykonaj();
        makeTransactionPage.clickVacationAccount();
        makeTransactionPage.getTextFromAccountNumber();
        makeTransactionPage.clickNormalTransaction();
        makeTransactionPage.fillNameAndAdress(name,surname,adress);
        makeTransactionPage.fillCashAmount(cashAmount);
        makeTransactionPage.fillTitle(title);
//        makeTransactionPage.clickForwardButton();
//        Assert.assertTrue(normalTransactionSummaryPage.checkAccountNumber());
//        normalTransactionSummaryPage.clickConfirmButton();
//        Assert.assertEquals(normalTransactionSummaryPage.getConfirmMessage(),"Przelew został wykonany");
    }

}
