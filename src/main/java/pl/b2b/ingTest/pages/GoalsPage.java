package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class GoalsPage {
    public GoalsPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(),this);
    }

    @FindBy (xpath = "//a[@class=\"btn btn-primary js-button  btn-with-icon\"]")
    private WebElement addGoalButton;

    @FindBy(xpath = "//span[contains(text(),'Dziecko')]/parent::div")
    private WebElement childGoalButton;

    @FindBy(id="goal-new-name")
    private WebElement goalNameField;

    @FindBy(id="goal-new-amount")
    private WebElement amountField;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button\"]")
    private WebElement nextButton;

    @FindBy(xpath = "//label[@for=\"startAmountCheck\"]")
    private WebElement startAmount;

    @FindBy(xpath = "(//span[@class=\"ui-slider-handle ui-state-default ui-corner-all\"])[1]")
    private WebElement slider;

    @FindBy(xpath = "(//span[@class=\"ui-slider-handle ui-state-default ui-corner-all\"])[2]")
    private WebElement slider2;

    @FindBy(id="goal-new-period")
    private WebElement randomClick;

    public void clickAddGoalButton(){
        WebPageMethods.clickElement(addGoalButton);
    }
    public void clickChildGoalButton(){
        WebPageMethods.clickElement(childGoalButton);
    }
    public void inputGoalName(String nameOfGoal){
        WebPageMethods.sendKeysToElement(goalNameField, nameOfGoal);
    }
    public void inputAmount(String amountGoal){
        WebPageMethods.sendKeysToElement(amountField, amountGoal);
    }
    public void clickNextButton(){
        WebPageMethods.clickElement(nextButton);
    }
    public void clickStartAmountCheckbox(){
        WebPageMethods.clickElement(startAmount);
    }
    public void moveSlider1(){
        WebPageMethods.moveSlider(slider, 20, 0);
    }
    public void moveSlider2(){
        WebPageMethods.moveSlider(slider2,-20,0);
    }
    public void clickRandomClick(){
        WebPageMethods.clickElement(randomClick);
    }

}
