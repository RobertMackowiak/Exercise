package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransactionPage {
    public TransactionPage() {
        PageFactory.initElements(pl.b2b.WebDriverConfig.getDriver(), this);

    }
    @FindBy(xpath = "//i[@class=\"glyphicon-rounded glyphicon-inverse glyphicon-ing-viewfinder\"]")
    private WebElement chooseAccount;

    public void chooseAccount(){
        pl.b2b.WebDriverConfig.getWait().until(ExpectedConditions.elementToBeClickable(chooseAccount));
        chooseAccount.click();



    }
}


