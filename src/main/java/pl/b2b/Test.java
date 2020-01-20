package pl.b2b;


import org.testng.Assert;
import org.testng.annotations.*;
import pl.b2b.ingTest.MainPage;
import pl.b2b.ingTest.MakeTransactionPage;
import pl.b2b.ingTest.NormalTransactionSummaryPage;
import pl.b2b.utils.ExcelData;
import pl.b2b.utils.ExcelRaport;

public class Test {

    MainPage mainPage;
    MakeTransactionPage makeTransactionPage;
    NormalTransactionSummaryPage normalTransactionSummaryPage;
    ExcelRaport excelRaport;
    String name = null;
    String surname = null;
    String adres = null;
    String cashAmount = null;
    String title = null;




    @BeforeTest
    public void before(){
        mainPage = new MainPage();
        makeTransactionPage = new MakeTransactionPage();
        normalTransactionSummaryPage = new NormalTransactionSummaryPage();
        excelRaport = new ExcelRaport();
        try {
            ExcelData.setExcelFile("C:/Users/B2B/Desktop/TestData.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            name = ExcelData.getCellData(1,0);
            surname = ExcelData.getCellData(1,1);
            adres = ExcelData.getCellData(1,2);
            cashAmount = ExcelData.getNumericCellData(1,3);
            title = ExcelData.getCellData(1,4);
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
       try{
        mainPage.clickOnWykonaj();
        makeTransactionPage.clickVacationAccount();
        makeTransactionPage.getTextFromAccountNumber();
        makeTransactionPage.clickNormalTransaction();
        makeTransactionPage.fillNameAndAdress(name,surname, adres);
        makeTransactionPage.fillCashAmount(cashAmount);
        makeTransactionPage.fillTitle(title);
        makeTransactionPage.clickForwardButton();
        Assert.assertTrue(normalTransactionSummaryPage.checkAccountNumber());
        normalTransactionSummaryPage.clickConfirmButton();
        Assert.assertEquals(normalTransactionSummaryPage.getConfirmMessage(),"Przelew został wykonan");
        excelRaport.writeToExcelPositive(name,surname, adres,cashAmount,title);
    }catch(Error | Exception e){
       excelRaport.writeToExcelNegative();
       throw e;
       }
   }

   @org.testng.annotations.Test
    public void removePerson(){
mainPage.waitForCookies();
mainPage.clickOnMyFinances();
mainPage.clickOnSavingAccount();

   }

}