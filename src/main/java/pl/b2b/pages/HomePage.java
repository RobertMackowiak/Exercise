package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = ("(//li[@id=\"menu-transactions\"])"))
    private WebElement transfer;

    //(xpath = ("(//a[@title=\"Blouse\"])[2]"))
    //href="#transactions"

    public void clickTransfer(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(transfer));
        transfer.click();
    }
//href="#transactions"
//WebDriverConfig.getWait().until(ExpectedConditions.visibilityOf(goToCart));

}
