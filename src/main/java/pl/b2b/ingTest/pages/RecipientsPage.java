package pl.b2b.ingTest.pages;

import com.sun.webkit.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class RecipientsPage {
    public RecipientsPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }
    @FindBy(name="search-text")
    private WebElement searchRecipient;

    @FindBy(xpath = "//span[@class=\"ing-selected-text\"]")
    private WebElement arrowContainer;

    @FindBy(xpath = "//a[@class=\"link js-edit-recipient\"]")
    private WebElement editRecipient;

    @FindBy(id="contact-phone-number")
    private WebElement phoneNumber;

    @FindBy(id="contact-name")
    private WebElement clickName;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-save contact-form_button\"]")
    private WebElement saveButton;

    public void searchforARecipient(String recipientName){
        WebPageMethods.sendKeysToElement(searchRecipient, recipientName);
    }
    public  void showRecipientsDetails(){
        WebPageMethods.clickElement(arrowContainer);
    }
    public void editRecipient(){
        WebPageMethods.clickElement(editRecipient);
    }
    public void putPhoneNumber(String number){
        WebPageMethods.sendKeysToElement(phoneNumber, number);
    }
    public void clickSaveButton(){
        clickName.click();
        WebPageMethods.clickElement(saveButton);
    }

}
