package pl.b2b.Pages;

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

    public void clickExecutionBtn() {
        WebPageMethods.clickElement(executeTransaction);
    }

    public void clickOnShutDownnCookies() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(demoInfo));
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(shutDownCookies));
        WebPageMethods.clickElement(shutDownCookies);
    }
}
