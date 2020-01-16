package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;

public class SummaryPage {

    public SummaryPage () {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement secondAccount;
}
