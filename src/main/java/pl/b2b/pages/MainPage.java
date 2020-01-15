package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.WebDriverConfig;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(pl.b2b.WebDriverConfig.getDriver(), this);

    }
    @FindBy(xpath = "//a[@data-tag=\"ADOBE:lastClickedArea=Menu:Main;events=event14;eVar9=MoveMoney;\"]")
    private WebElement makeTransaction;

    public void makeTransaction(){
        pl.b2b.WebDriverConfig.getWait().until(ExpectedConditions.elementToBeClickable(makeTransaction));
        makeTransaction.click();



    }
}



