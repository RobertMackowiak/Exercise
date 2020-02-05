package pl.b2b.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.WebPageMethods;
import pl.b2b.utils.SingletonWebdriver;

public class RecipientsPage {
    String getTextToAssert;
    public RecipientsPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(name = "search-text")
    public WebElement searchRecipient;

    @FindBy(xpath = "//span[@class=\"ing-selected-text\"]")
    public WebElement clickOnTomekK;

    @FindBy(xpath = "//a[@class=\"link js-edit-recipient\"]")
    public WebElement clickOnEditTomekK;

    @FindBy(id = "contact-phone-number")
    public WebElement writeCellNumber;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-save contact-form_button\"]")
    public WebElement saveButtonAfterEditionTomekK;

    @FindBy(id ="contact-name")
    public WebElement clickOnNameButton;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    public WebElement confirmEditioButton;

    @FindBy(xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    public WebElement getTextOfConfirmationButton;

    public void searchForRecipient(String recepitntname) {
        WebPageMethods.sendKeysToElement(searchRecipient, recepitntname);
    }

    public void setClickOnTomekK() {
        WebPageMethods.clickElement(clickOnTomekK);
    }
    public void setClicnOnEditTomekK(){
        WebPageMethods.clickElement(clickOnEditTomekK);
    }
    public void sendCellNumber(String cellNumber){
        WebPageMethods.sendKeysToElement(writeCellNumber, cellNumber);
    }
    public void clickOnSaveButtonAfetrEditionTomekK(){
        WebPageMethods.clickElement(saveButtonAfterEditionTomekK);
            }
            public void setClickOnNameButton(){
        WebPageMethods.clickElement(clickOnNameButton);
            }
            public void clikOnConfirmationButton(){
        WebPageMethods.clickElement(confirmEditioButton);
            }
            public String getTextOfAfterConfirmation(){
       getTextToAssert = getTextOfConfirmationButton.getText();
       return getTextToAssert;
            }

}
