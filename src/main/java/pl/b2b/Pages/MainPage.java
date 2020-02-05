package pl.b2b.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.WebPageMethods;
import pl.b2b.utils.SingletonWebdriver;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(id = "menu-transactions")
    private WebElement executeTransaction;

    @FindBy(xpath = "//p[@class=\"demo-curtain_container\"]")
    private WebElement demoInfo;

    @FindBy(xpath = "//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement shutDownCookies;

    @FindBy(id = "menu-products")
    private WebElement myFinancesButton;

    @FindBy(xpath = "//span[@class=\"name row_name--S\"]")
    private WebElement openSaveingAccount;

    @FindBy(id = "menu-financemeter")
    private WebElement serviceAndTols;

    @FindBy(id = "servicesRecipient")
    private WebElement recipient;

    @FindBy(id = "servicesGoals")
    private WebElement saveingTargets;

    @FindBy(xpath = "//a[@class=\"btn btn-primary js-button  btn-with-icon\"]")
    private WebElement clickOnAddAim;

    @FindBy(xpath = "//span[contains(text(), 'Dziecko')]/parent::div")
    private WebElement clickOnChildButton;

    @FindBy(id = "goal-new-name")
    private WebElement nameOfTheAim;

    @FindBy(id = "goal-new-amount")
    private WebElement cashAmmountToFinish;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button\"]")
    private WebElement clickOnNextButtonAfterChieldValue;

    @FindBy(xpath = "//span[@class=\"checkbox_label_middle\"]")
    private WebElement checkBoxToFirsAmount;

    @FindBy(xpath = "(//span[@class=\"ui-slider-handle ui-state-default ui-corner-all\"])[1]")
    private WebElement slider
            ;

    @FindBy(xpath = "(//span[@class=\"ui-slider-handle ui-state-default ui-corner-all\"])[2]")
    private WebElement slider2;

    @FindBy(xpath = "//input[@class=\"form-control js-period\"]")
    private WebElement clickOnRandomButton;

    public void clickOnRandomElement(){
        WebPageMethods.clickElement(clickOnRandomButton);
    }

    public void moveFirstDragAndDrop(){
        WebPageMethods.sliderMove(slider, 20, 0);
    }
    public void moveSecondDragAndDrop(){
        WebPageMethods.sliderMove(slider2, -20, 0);
    }

    public void markCheckBoxToFirstAmount() {
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(checkBoxToFirsAmount));
        WebPageMethods.clickElement(checkBoxToFirsAmount);
    }

    public void setClickOnNextButtonAfterChieldValue() {
        WebPageMethods.clickElement(clickOnNextButtonAfterChieldValue);
    }

    public void sendCashAmmoount(String cash) {
        WebPageMethods.sendKeysToElement(cashAmmountToFinish, cash);
    }

    public void sendValueOfNameOfTheAim(String name) {
        WebPageMethods.sendKeysToElement(nameOfTheAim, name);
    }

    public void setClickOnChildButton() {
        WebPageMethods.clickElement(clickOnChildButton);
    }

    public void setClickOnAddAim() {
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(clickOnAddAim));
        WebPageMethods.clickElement(clickOnAddAim);
    }

    public void clickOnSaveingTargets() {
        WebPageMethods.clickElement(saveingTargets);
    }

    public void clickExecutionBtn() {
        WebPageMethods.clickElement(executeTransaction);
    }

    public void clickOnShutDownnCookies() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(demoInfo));
        if (SingletonWebdriver.getDriver().findElements(By.xpath("//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")).size() > 0) {
            WebPageMethods.clickElement(shutDownCookies);
        }

    }

    public void clickMyFinancesButton() {
        WebPageMethods.clickElement(myFinancesButton);
    }

    public void clickOpenSaveingAccount() {
        WebPageMethods.clickElement(openSaveingAccount);
    }

    public void clickOnServiceAndTools() {
        WebPageMethods.clickElement(serviceAndTols);
    }

    public void clickOnRecipient() {
        WebPageMethods.clickElement(recipient);
    }
}
