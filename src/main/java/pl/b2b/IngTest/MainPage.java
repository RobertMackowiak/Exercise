package pl.b2b.IngTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(id="page-loader-overlay-region")
    private WebElement loader;

    @FindBy(xpath = "//div[@class=\"demo-curtain\"]")
    private WebElement curtain;


    @FindBy(id="menu-transactions")
    private WebElement transactions;


    public void clickTransactionButton() {
        SingletonWebdriver.getWait().until(ExpectedConditions.invisibilityOf(loader));
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(curtain));
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(transactions));
        transactions.click();
    }
}
