package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class HistoryPage {
    public HistoryPage() { PageFactory.initElements(SingletonWebdriver.getDriver(),this); }

    @FindBy(xpath = "//ul[@class=\"transactions-history-list_container grid grid--hover\"]/li[1]")
    private WebElement firstDetails;

    @FindBy(xpath = "//p[@class=\"col-xs-12 payer-details_from-account-number transaction-details-subsection_content\"]")
    private WebElement finalAccNumber;

    @FindBy(xpath = "//p[@class=\"transaction-details-subsection_content transaction-details_amount\"]")
    private WebElement finalAmount;

    public void clickFirstDetails(){
        WebPageMethods.clickElement(firstDetails);
    }
    public boolean secondComparison(){
        System.out.println(finalAccNumber.getText());
        return TransactionPage.accountNumber.equals(finalAccNumber.getText());
    }
    public String showNextAmount(){
     return finalAmount.getText().replaceAll("\\s+","").substring(1,5);
    }

}
