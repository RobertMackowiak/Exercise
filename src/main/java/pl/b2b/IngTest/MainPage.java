package pl.b2b.IngTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.b2b.SingletonWebdriver;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(),this);
    }

    @FindBy (xpath = "div//[@class=\"demo-curtain_content text-center\"]")
    private WebElement container;

    @FindBy (xpath = "span//[@class=\"move-money\"]")
    private WebElement transactionButton;

    public void chooseTransactionButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(container));
        transactionButton.click();
    }

}
