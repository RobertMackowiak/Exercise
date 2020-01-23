package pl.b2b.ingTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class AttorneysPage {

    public AttorneysPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class=\"js-revoke link\"])[1]")
    private WebElement revokeAttorney;
    @FindBy(xpath = "//div[@class=\"cell cell-right\"]")
    private WebElement addAttorney;
    @FindBy(id="attorney-name")
    private WebElement nameAndSurname;
    @FindBy(xpath = "//input[@class=\"form-control js-id\"]")
    private WebElement idNumber;
    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button contact-form_button\"]")
    private WebElement forwardButton;
    @FindBy(xpath = "//div[@class=\"col-md-6 col-xs-12 js-agreement-link document-link\"]")
    private WebElement annex;
    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmationButton;
    @FindBy(xpath = "//div[@class=\"sum_messages\"]")
    private WebElement text;
    @FindBy(xpath = "//span[@class=\"filter-option pull-left\"]")
    private WebElement arrow;
    @FindBy(xpath = "//span[contains(text(),\"Paszport\")]")
    private WebElement passport;
    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button\"]")
    private WebElement nextButtonAfterRevoke;


    public void clickAddAttorneyButton(){
        WebPageMethods.clickElement(addAttorney);
    }

    public void setNameAndSurname(String name){
        WebPageMethods.sendKeysToElement(nameAndSurname, name);
    }

    public void choosePassport(){
       WebPageMethods.clickElement(arrow);
       passport.click();
    }

    public void setIdNumber(String number){
        WebPageMethods.sendKeysToElement(idNumber, number);
    }
    public void clickForwardButton(){
        WebPageMethods.clickElement(forwardButton); //trzeba 2x kliknąc ten przycisk - drugi raz po wait
    }
    public void waitForAnnex(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(annex));
    }
    public void clickConfirmationButton(){
        WebPageMethods.clickElement(confirmationButton);
    }
    public String getConfirmationText(){
        return text.getText();
    }

    public void clickRevokeAttorney(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(addAttorney));
        if(SingletonWebdriver.getDriver().findElements(By.xpath("(//a[@class=\"js-revoke link\"])[1]")).size()>0) {
            WebPageMethods.clickElement(revokeAttorney);
            WebPageMethods.clickElement(nextButtonAfterRevoke);
            clickConfirmationButton();
        }

    }
    }

