package pl.b2b.bankIng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebDriver;
import pl.b2b.bankIng.utils.WebPageMethods;

public class GoalsPage {

    String textToAssert;

    public GoalsPage() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Dziecko')]/parent::div")
    private WebElement childrenButton;

    @FindBy(id = "goal-new-name")
    private WebElement nameOfGoal;

    @FindBy(id = "goal-new-amount")
    private WebElement moneyLabel;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button\"]")
    private WebElement nextButton;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmButton;

    @FindBy(xpath = "//h4[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement xpathText;

    @FindBy(xpath = "//label[@for=\"startAmountCheck\"]")
    private WebElement startAmountCheckBox;

    @FindBy(xpath = "(//span[@class=\"ui-slider-handle ui-state-default ui-corner-all\"])[1]")
    private WebElement slider1;

    @FindBy(xpath = "(//span[@class=\"ui-slider-handle ui-state-default ui-corner-all\"])[2]")
    private WebElement slider2;

    @FindBy(id = "goal-new-period")
    private WebElement randomClick;

    public void clickChildrenButton() {
        WebPageMethods.clickElement(childrenButton);
    }

    public void addNameOfGoalAndMoney(String name, String money) {
        WebPageMethods.sendKeysToElement(nameOfGoal, name);
        WebPageMethods.sendKeysToElement(moneyLabel, money);
        WebPageMethods.clickElement(nextButton);
//        WebPageMethods.clickElement(nextButton);
//        WebPageMethods.clickElement(nextButton);
    }


    public void clickConfirmButton() {
        WebPageMethods.clickElement(confirmButton);
    }

    public String getText() {
        return textToAssert = xpathText.getText();
    }

    public void clickStartAmountCheckBox() {
        WebPageMethods.clickElement(startAmountCheckBox);
    }


    public void moveSlider1() {
        WebPageMethods.sliderMove(slider1, 70, 0);
    }

    public void moveSlider2() {
        WebPageMethods.sliderMove(slider2, -60, 0);
    }

    public void clickRandomClick() {
        WebPageMethods.clickElement(randomClick);
    }
}
