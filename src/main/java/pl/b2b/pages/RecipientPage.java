package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class RecipientPage {
    public RecipientPage(){

        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@class=\"form-control js-search-input contacts-search_input\"]")
    private WebElement recipientfind;

    @FindBy (xpath = "//span[@class=\"ing-selected-text\"]")
    private WebElement selectRecipient;

    @FindBy (xpath = "//a[@class=\"link js-edit-recipient\"]")
    private WebElement editRecipient;


    public void inputRecipient(String name) {
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(recipientfind));
        recipientfind.sendKeys(name);
    }

    public void selectRecipientButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(selectRecipient));
        selectRecipient.click();

    }

    public void editRecipientButton (){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(editRecipient));
        editRecipient.click();
    }



}
