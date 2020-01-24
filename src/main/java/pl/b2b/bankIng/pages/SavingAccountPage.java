package pl.b2b.bankIng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebDriver;
import pl.b2b.bankIng.utils.WebPageMethods;

public class SavingAccountPage {

    public SavingAccountPage() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class=\"js-attorneys-button link\"]")
    private WebElement attorneyButton;

    public void clickAttorneyButton() {
        WebPageMethods.clickElement(attorneyButton);
    }

}
