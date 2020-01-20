package pl.b2b.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.WebPageMethods;
import pl.b2b.utils.SingletonWebdriver;

public class PageSummary {

    public static String accountNumber;
    public static String transferAmount;
//    public static String finaltransferAmount;

    public PageSummary() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement getAccountNumber;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement clickOnButtonConfirm;

    @FindBy(xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement getConfirmMessage;

    @FindBy(xpath = "//li[@id=\"menu-history\"]")
    private WebElement clickOnHistoryTransferButton;

    @FindBy(xpath = "//pan[@class=\"ing-loader ing-loading-container full-screen\"]")
    private WebElement obscureElementOnHistoryButton;

    @FindBy(xpath = "//span[@class=\"product-tile__amount\"]")
    private WebElement getTransferAmount;


    public boolean cutGetAccountNumber() {
        return TransactionOptionPage.accountNumber.equals(getAccountNumber.getText());

    }

    public void setClickOnButtonConfirm() {
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(clickOnButtonConfirm));
        WebPageMethods.clickElement(clickOnButtonConfirm);
    }

    public String setGetConfirmMessage() {
        return getConfirmMessage.getText();
    }

    public void setClickOnHistoryTransferButton() {
        WebPageMethods.clickElement(clickOnHistoryTransferButton);
    }
    public void setGetTransferAmount(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(getTransferAmount));
        transferAmount = getTransferAmount.getText();

        System.out.println(transferAmount);
    }

}
