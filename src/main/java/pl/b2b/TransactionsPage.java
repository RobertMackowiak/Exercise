package pl.b2b;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransactionsPage {

    @FindBy ()
    private WebElement VacationGoalButton;

    @FindBy (className ="product-tile__iban is-long")
    private WebElement accountNumber;



    public TransactionsPage(){

        PageFactory.initElements(SingletonWebdriver.getDriver(),this);

    }
    public void performVacation (){

        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(VacationGoalButton));
        VacationGoalButton.click();
    }
    public void copyAccountNumber (){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf( accountNumber));
        accountNumber.getText();

    }

}
