package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class AttorneysPage {

    public AttorneysPage(){
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    public static int listSize;

    @FindBy(xpath = "(//a[@class=\"js-revoke link\"])[1]")
    private WebElement revokeButton;

    @FindBy (xpath = "//span[@class=\"btn-sep hidden-xs ui-btn-text\"]")
    private WebElement addAttorney;

    @FindBy (id="attorney-name")
    private WebElement nameAttorney;

    @FindBy (xpath = "//span[@class=\"caret\"]")
    private WebElement selectIDList;

    @FindBy (xpath = "//span[contains(text(),\"Paszport\")]")
    private WebElement selectID;

    @FindBy (xpath = "//input[@class=\"form-control js-id\"]")
    private WebElement idNum;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button contact-form_button\"]")
    private WebElement continueButton;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmButton;

    @FindBy (xpath = "//a[@class=\"link agreement bound\"]")
    private WebElement documents;

    @FindBy (xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement confirmation;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button\"]")
    private WebElement confirmAttorney;

    @FindBy (xpath = "//a[@class=\"link  js-summary-link js-link-id-0\"]")
    private WebElement accountDetails;


    public void clickRevokeButton(){
//        if (!SingletonWebdriver.getDriver().findElements(By.xpath("//a[@class=\"js-revoke link\"]")).isEmpty()) {
//            listSize = SingletonWebdriver.getDriver().findElements(By.xpath("//a[@class=\"js-revoke link\"]")).size();
//
//        }
            SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(revokeButton));
            revokeButton.click();
//        }
    }

    public void addAttorneyClick(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(addAttorney));
        addAttorney.click();

    }

    public void nameOfAttorney(String name){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(nameAttorney));
        nameAttorney.sendKeys(name);
    }

    public void selectIDPesel (){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(selectIDList));
        selectIDList.click();
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(selectID));
        selectID.click();

    }

    public void setIDNumber (String value){
        idNum.sendKeys(value);
    }

    public void clickContinueButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(documents));
        continueButton.click();
    }

    public void clickConfirmButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();

    }

    public String getText (){
        return confirmation.getText();
    }

    public void confirmDeleting (){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(confirmAttorney));
        confirmAttorney.click();
    }



}
