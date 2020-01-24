package pl.b2b.bankIng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebDriver;
import pl.b2b.bankIng.utils.WebPageMethods;

public class RecipientsPage {
    private String textToAssert;
    public RecipientsPage() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@class=\"form-control js-search-input contacts-search_input\"]")
    private WebElement searchRecipients;

    @FindBy(xpath = "//span[@class=\"ing-selected-text\"]")
    private WebElement selectRecipient;

    @FindBy(xpath = "(//div[@class=\"contact-details_link\"])[2]")
    private WebElement editRecipient;

    @FindBy(id = "contact-phone-number")
    private WebElement phoneNumber;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-save contact-form_button\"]")
    private WebElement saveButton;

    @FindBy(id = "contact-name")
    private WebElement randomClick;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmButton;

    @FindBy(xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement text;

    public void putNameInSearchRecipients() {
        WebPageMethods.sendKeysToElement(searchRecipients, "Tomek k");
    }

    public void clickSelectRecipient() {
        WebPageMethods.clickElement(selectRecipient);
    }

    public void clickEditRecipient() {
        WebPageMethods.clickElement(editRecipient);
    }

    public void editphoneNumber() {
        WebPageMethods.sendKeysToElement(phoneNumber, "758965423");
    }

    public void clickRandomClick() {
        WebPageMethods.clickElement(randomClick);
    }

    public void clickSaveButton() {
        WebPageMethods.clickElement(saveButton);
    }

    public void clickConfirmButton() {
        WebPageMethods.clickElement(confirmButton);
    }

    public String getText() {

        return textToAssert = text.getText();
    }
}
