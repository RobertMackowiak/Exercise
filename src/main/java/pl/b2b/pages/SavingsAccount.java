package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class SavingsAccount {

    public SavingsAccount(){
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class=\"js-attorneys-button link\"]")
    private WebElement attorneyButton;

    public void clickAttorneysButton (){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(attorneyButton));
        attorneyButton.click();
    }



}
