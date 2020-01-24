package pl.b2b.bankIng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebDriver;
import pl.b2b.bankIng.utils.WebPageMethods;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement coockiesButton;

    //    @FindBy(id = "menu-transactions")
    @FindBy(xpath = "//li[@id=\"menu-transactions\"]")
    private WebElement executeTransactionButton;

    @FindBy(id = "page-loader-overlay-region")
    private WebElement loader;

    @FindBy(xpath = "//div[@class=\"demo-curtain\"]")
    private WebElement curtain;

    @FindBy(id = "menu-products")
    private WebElement myFinances;

    @FindBy(xpath = "(//ul[@class=\"products-list\"])[2]")
    private WebElement openSavingsAccount;

    @FindBy(id = "menu-financemeter")
    private WebElement financeMeterButton;

    @FindBy(id = "servicesRecipient")
    private WebElement servicesRecipient;

    @FindBy(id = "servicesGoals")
    private WebElement serviceGoalsButton;

    @FindBy(xpath = "//a[@class=\"btn btn-primary js-button  btn-with-icon\"]")
    private WebElement addNewGoal;

    public void clickExecuteTransactionButton() {
        SingletonWebDriver.getWait().until(ExpectedConditions.invisibilityOf(loader));
        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(curtain));
        SingletonWebDriver.getWait().until(ExpectedConditions.elementToBeClickable(executeTransactionButton));
        executeTransactionButton.click();
    }

    public void clickCookiesButton() {
        SingletonWebDriver.getWait().until(ExpectedConditions.elementToBeClickable(executeTransactionButton));
        if (SingletonWebDriver.getDriver().findElements(By.xpath("//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")).size() > 0) {
            coockiesButton.click();
        }

    }

    public void clickMyFinances() {
        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(curtain));
        WebPageMethods.clickElement(myFinances);
    }

    public void clicOpenSavingsAccount() {
        WebPageMethods.clickElement(openSavingsAccount);
    }

    public void clickFinanceMeterButton() {
        WebPageMethods.clickElement(financeMeterButton);
    }

    public void clickServicesRecipient() {
        WebPageMethods.clickElement(servicesRecipient);
    }

    public void clickServiceGoalsButton() {
        WebPageMethods.clickElement(serviceGoalsButton);
    }

    public void clickAddNewGoal(){
        WebPageMethods.clickElement(addNewGoal);
    }

}


