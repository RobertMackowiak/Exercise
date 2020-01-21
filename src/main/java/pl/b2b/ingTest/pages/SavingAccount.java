package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class SavingAccount {
    public SavingAccount() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@class=\"js-attorneys-button link\"]")
    private WebElement attorneyButton;

    public void clickAttorneyButton(){
        WebPageMethods.clickElement(attorneyButton);
    }

}
