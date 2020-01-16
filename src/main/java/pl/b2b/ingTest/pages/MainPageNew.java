package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;

public class MainPage {

    public MainPage () {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (id = "menu-transactions")
    private WebElement 


}
