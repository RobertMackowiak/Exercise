package pl.b2b;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransactionPage {

    @FindBy (className = "tile_icon tile_icon--small glyphicon-ing type-icon glyphicon-ing-transactions")
    private WebElement transactionButton;

    @FindBy (className = "js-textarea form-control bound triggered")
    private  WebElement adressBox;

    @FindBy (id = "amount")
    private WebElement amountBox;


    public TransactionPage(){

        PageFactory.initElements(SingletonWebdriver.getDriver(),this);

    }

    public void getTransaction (){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(transactionButton));
        transactionButton.getText();

    }

    public void putAdress(){
        adressBox.sendKeys("Jan Tester, ul.Ulubiona 20/56, 98-345 Pustka ");
    }

    public void putAmount(){
        amountBox.sendKeys("100");
    }


}
