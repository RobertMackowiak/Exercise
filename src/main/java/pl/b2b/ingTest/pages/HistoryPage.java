package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class HistoryPage {
    {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class=\"transactions-history-list_container grid grid--hover\"]/li")
    private WebElement transferDetails;

    @FindBy(xpath = "//p[@class=\"col-xs-12 payer-details_from-account-number transaction-details-subsection_content\"]")
    private WebElement finalAccountNumber;

    @FindBy(xpath = "//p[@class=\"transaction-details-subsection_content transaction-details_amount\"]")
    private WebElement finalAmount;

    public void clickTransferDetails(){
        WebPageMethods.clickElement(transferDetails);
    }
    public boolean anotherComparison() {
        return ChooseAccountPage.cut.equals(finalAccountNumber.getText());
    }
    public String getFinalAmount(){
        return finalAmount.getText().replaceAll("\\s","").substring(1,5);
    }
}
