package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class RecipientsPage {
    public RecipientsPage()  {
        PageFactory.initElements(SingletonWebdriver.getDriver(),this);
    }

    @FindBy(name="search-text")
    private WebElement searchRecipients;

    @FindBy(xpath = "//span[@class=\"ing-selected-text\"]")
    private WebElement arrowContainer;

    @FindBy(xpath = "//a[@class=\"link js-edit-recipient\"]")
    private WebElement detailsButton;

    @FindBy(id="contact-phone-number")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-save contact-form_button\"]")
    private WebElement saveButton;

    @FindBy(id="contact-name")
    private WebElement nameField;

    public void useSearchRecipients(String recipientsName){
        WebPageMethods.sendKeysToElement(searchRecipients, recipientsName);
    }
    public void clickArrowContainer(){
        WebPageMethods.clickElement(arrowContainer);
    }
    public void  clickDetailsButton(){
        WebPageMethods.clickElement(detailsButton);
    }
    public void inputPhoneNumber(String phoneNumber){
        WebPageMethods.sendKeysToElement(phoneNumberField, phoneNumber);
    }
    public void clickSaveButton(){
        WebPageMethods.clickElement(saveButton);
    }
    public void clickNameField(){
        WebPageMethods.clickElement(nameField);
    }
}
