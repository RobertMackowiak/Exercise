package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class EditSummaryPage {

    public EditSummaryPage(){
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(id="contact-phone-number")
    private WebElement inputNumber;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-save contact-form_button\"]")
    private WebElement saveButton;

    @FindBy (id="contact-recipient-name-and-address")
    private WebElement randomTextField;

    @FindBy (xpath = "//div[@class=\"contact-summary-more_value\"]")
    private WebElement savedNumber;


    public void inputNumberField(String number){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(inputNumber));
        inputNumber.sendKeys(number);
    }

    public void saveButtonClick(){

        randomTextField.click();
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public String getSavedNumber (){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(savedNumber));
        return savedNumber.getText();
    }
}
