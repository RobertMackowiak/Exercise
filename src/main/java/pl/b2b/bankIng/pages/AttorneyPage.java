package pl.b2b.bankIng.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.FixMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pl.b2b.SingletonWebDriver;
import pl.b2b.bankIng.utils.ExcelRaport;
import pl.b2b.bankIng.utils.WebPageMethods;

public class AttorneyPage {

    private String textToAssert;

    public AttorneyPage() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class=\"js-revoke link\"])[1]")
    private WebElement revokeButton;


    @FindBy(xpath = "//span[@class=\"btn-sep hidden-xs ui-btn-text\"]")
    private WebElement addAttorney;

    @FindBy(id = "attorney-name")
    private WebElement addNameAndUsrname;

    @FindBy(xpath = "//select[@class=\"ing-select-list form-control js-idType bound idInserted\"]")
    private WebElement idList;

    @FindBy(xpath = "//input[@class=\"form-control js-id\"]")
    private WebElement idNumber;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button contact-form_button\"]")
    private WebElement nextButton;

    @FindBy(xpath = "//i[@class=\"glyphicon-ing glyphicon-ing-pattern\"]")
    private WebElement annexForIcon;

    @FindBy(xpath = "//span[@class=\"caret\"]")
    private WebElement clickList;

    @FindBy(xpath = "//li[@data-original-index=\"1\"]")
    private WebElement addPassport;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmButton;

    @FindBy(xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement text;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button\"]")
    private WebElement nextButtonAfterRevoke;


    public void clickAddAttorney() {
        WebPageMethods.clickElement(addAttorney);
    }

    public void putTextInNameAndSurname(String nameAndSurname) {
        WebPageMethods.sendKeysToElement(addNameAndUsrname, nameAndSurname);
    }

    public void setIdList() {
        WebPageMethods.clickElement(clickList);
        WebPageMethods.clickElement(addPassport);
    }

    public void clickRevokeButton() {


//        if (!SingletonWebDriver.getDriver().findElements(By.xpath("(//a[@class=\"js-revoke link\"])[1]")).isEmpty()) {
        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(addAttorney));
        if(SingletonWebDriver.getDriver().findElements(By.xpath("(//a[@class=\"js-revoke link\"])[1]")).size()>0) {
            WebPageMethods.clickElement(revokeButton);
            WebPageMethods.clickElement(nextButtonAfterRevoke);
            clickConfirmButton();
        }
//        WebPageMethods.clickElement(nextButton);
//        }
//            int listSize = SingletonWebDriver.getDriver().findElements(By.xpath("//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")).size();
//            for (int i = 0; i <= listSize; i++) {
//
//                WebPageMethods.clickElement((WebElement) By.xpath("//a[@class=\"js-revoke link\"]"));
//            }
//        }
////        if (SingletonWebdriver.getDriver().findElements(By.xpath("//a[@class=\"js-revoke link\"]")).size() > 0) {
////            revokeButton.click();
////        }

    }


    public void setIdNumber(String number) {
        idNumber.clear();
        WebPageMethods.sendKeysToElement(idNumber, "79041986439");
    }

    public void clickNextButton() {
        WebPageMethods.clickElement(nextButton);
    }

    public void waitForAneksIconShows() {
        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(annexForIcon));
        WebPageMethods.clickElement(nextButton);
    }

    public void clickConfirmButton() {
        WebPageMethods.clickElement(confirmButton);
    }

    public String getText() {

        return textToAssert = text.getText();
    }
}