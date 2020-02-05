package pl.b2b.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pl.b2b.WebPageMethods;
import pl.b2b.utils.SingletonWebdriver;

public class AttorneysPage {
    public String textToAssert;

    public AttorneysPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class=\"js-revoke link\"]")
    private WebElement clickRevokeButton;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button\"]")
    private WebElement nextButtonAfterRevoke;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmationButtonAfterRevoking;

    @FindBy(xpath = "//a[@class=\"btn btn-primary js-button btn-with-icon\"]")
    private WebElement clickOnAddAttornay;

    @FindBy(xpath = "//a[@class=\"js-attorneys-button link\"]")
    private WebElement addAttorney;

    @FindBy(id = "attorney-name")
    private WebElement nameAndSurname;

    @FindBy(xpath = "//span[@class=\"filter-option pull-left\"]")
    private WebElement idList;

    @FindBy(xpath = "//span[contains(text(), \"Paszport\")]")
    private WebElement passport;

    @FindBy(xpath = "//input[@class=\"form-control js-id\"]")
    private WebElement idNumber;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button contact-form_button\"]")
    private WebElement forwardButton;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmButton;

    @FindBy(xpath = "//a[@class=\"link agreement bound\"]")
    private WebElement annex;

    @FindBy(xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement text;


    public String getTextToCompare() {
        textToAssert = text.getText();
        return textToAssert;
    }

    public void waitForAneks() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(annex));
    }
    public void clickConfirmationButtonAfterRevoking(){
        WebPageMethods.clickElement(confirmButton);
    }

    public void clickAddAttorney() {
        WebPageMethods.clickElement(clickOnAddAttornay);
    }

    public void clickOnaddAttoray1() {
        WebPageMethods.clickElement(addAttorney);
    }

    public void setNameAndSurname(String nameAndSurname1) {
        WebPageMethods.sendKeysToElement(nameAndSurname, nameAndSurname1);

    }

    public void clickOnPassport() {
        WebPageMethods.clickElement(passport);
    }

    public void clickDropDown() {
        WebPageMethods.clickElement(idList);
    }

    public void stIdNumber(String number) {
        WebPageMethods.sendKeysToElement(idNumber, number);
    }

    public void clickForwardButton() {
        WebPageMethods.clickElement(forwardButton);
    }

    public void clickOnConfirmButton() {
        WebPageMethods.clickElement(confirmButton);
    }

    public void setClickRevokeButton() {
        WebPageMethods.clickElement(clickRevokeButton);
    }

    public void clickOnNextButtonAfterRevoking() {
        WebPageMethods.clickElement(nextButtonAfterRevoke);


        if (SingletonWebdriver.getDriver().findElements(By.xpath("//a[@class=\"js-revoke link\"][1]")).size()>0) {
            WebPageMethods.clickElement(clickRevokeButton);
            WebPageMethods.clickElement(nextButtonAfterRevoke);
            clickConfirmationButtonAfterRevoking();
            }
        }
    }
