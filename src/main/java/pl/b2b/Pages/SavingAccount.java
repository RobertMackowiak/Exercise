package pl.b2b.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.WebPageMethods;
import pl.b2b.utils.SingletonWebdriver;

public class SavingAccount {
    public SavingAccount(){
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);

    }
    @FindBy(xpath = "//a[@class=\"js-attorneys-button link\"]")
    private WebElement attorneyButton;

    public void clickOnAttorneyButton(){
        WebPageMethods.clickElement(attorneyButton);
    }



}
