package pl.b2b.ingTest.pages;

import net.bytebuddy.implementation.bind.annotation.FieldProxy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class AttorneysPage {


    public AttorneysPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class=\"js-revoke link\"])[1]")
    public WebElement revokeButton;

    @FindBy(xpath = "//a[@class=\"btn btn-primary js-button btn-with-icon\"]")
    public WebElement addAttorneyButton;

    @FindBy(id="attorney-name")
    public WebElement nameField;

    @FindBy(xpath = "//select[@class=\"ing-select-list form-control js-idType bound idInserted\"]")
    public WebElement attorneyId;

    @FindBy(xpath = "//input[@class=\"form-control js-id\"]")
    public WebElement idNumberField;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button contact-form_button\"]")
    public WebElement nextBtn;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    public WebElement confirmationButton;

    @FindBy(xpath = "//a[@class=\"link agreement bound\"]")
    public WebElement annex;

    @FindBy(xpath = "//div[@class=\"sum_messages\"]")
    public WebElement sumMessage;

    @FindBy(xpath = "//span[@class=\"filter-option pull-left\"]")
    private WebElement arrow;

    @FindBy(xpath = "//span[contains(text(),\"Paszport\")]")
    private WebElement passport;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button\"]")
    private WebElement nextButtonAfterRevoke;


    public void clickRevokeButton() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(addAttorneyButton));
        if (SingletonWebdriver.getDriver().findElements(xpath("(//a[@class=\"js-revoke link\"][1])")).size()>0){
            WebPageMethods.clickElement(revokeButton);
            WebPageMethods.clickElement(nextButtonAfterRevoke);
            clickConfirmationButton();
            }
    }

    public void clickAddAttorneyButton(){
        WebPageMethods.clickElement(addAttorneyButton);
    }
    public void inputName(String name){
        WebPageMethods.sendKeysToElement(nameField, name);
    }
    public void setAttorneyId(){
        WebPageMethods.clickElement(arrow);
        passport.click();

    }

    public void inputIdNumber(String id){
        WebPageMethods.sendKeysToElement(idNumberField, id);
    }

    public void clickNextBtn(){                       //klikamy dwa razy
        WebPageMethods.clickElement(nextBtn);
    }
    public void clickConfirmationButton(){
        WebPageMethods.clickElement(confirmationButton);
    }
    public void waitAnnex(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(annex));
    }
    public String getMessage(){
        return sumMessage.getText();
    }
    public void clickArrow(){
        WebPageMethods.clickElement(arrow);
    }
}
