package pl.b2b;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
    MainPage mainPage = new MainPage();
    String secondNumberToCompare;

    public SummaryPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement secondTimeAccount;

    public void getSecondTimeAccount() {
        secondNumberToCompare = secondTimeAccount.getText();
        System.out.println(secondTimeAccount.getText());
    }


        public boolean compareAccount () {
            if (mainPage.getAccountNumberCopy().equals(secondNumberToCompare) ) {
                return true;
            }
            else {
                return false;}
        }

}





