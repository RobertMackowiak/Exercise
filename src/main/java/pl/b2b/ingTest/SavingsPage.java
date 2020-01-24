package pl.b2b.ingTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.utils.WebPageMethods;

public class SavingsPage {

    public SavingsPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(),this);
    }



    @FindBy(xpath = "//div[@class=\"cell cell-right\"]")
    private WebElement newGoal;

    @FindBy(xpath = "//span[contains(text(),'Dziecko')]/parent::div/div")
    private WebElement childGoal;

    @FindBy(id = "goal-new-name")
    private WebElement newGoalName;

    @FindBy(id = "goal-new-amount")
    private WebElement goalAmount;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button\"]")
    private WebElement forwardButton;

    @FindBy(xpath = "(//span[@class=\"ui-slider-handle ui-state-default ui-corner-all\"])[2]")
    private WebElement slider;

    public void slideSlider(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(slider));
        Actions actions = new Actions(SingletonWebdriver.getDriver());
        actions.dragAndDropBy(slider,-30,0).build().perform();
    }

    public void clickOnForward(){
        WebPageMethods.clickElement(forwardButton);
    }

    public void setNewGoalAmount(String amount){
        WebPageMethods.sendKeysToElement(goalAmount,amount);
    }

    public void setNewGoalName(String goalName){
        WebPageMethods.sendKeysToElement(newGoalName,goalName);
    }

    public void clickOnChildGoal(){
        WebPageMethods.clickElement(childGoal);
    }

    public void clickOnNewGoal(){
        WebPageMethods.clickElement(newGoal);
    }
}
