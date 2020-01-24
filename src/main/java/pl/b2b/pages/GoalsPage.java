package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.utils.WebPageMethods;

public class GoalsPage {
    public GoalsPage(){
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    int a;

    @FindBy(xpath = "//span[@class=\"btn-sep hidden-xs ui-btn-text\"]")
    private WebElement addGoalButton;

    @FindBy(xpath = "//span[contains(text(), 'Dziecko')]/parent::div")
    private WebElement childButton;

    @FindBy(id="goal-new-name")
    private WebElement newNameField;

    @FindBy(id="goal-new-amount")
    private WebElement newAmountField;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-next-button\"]")
    private WebElement nextButton;

    @FindBy (xpath = "//button[@btn btn-primary btn-block btn-lg js-send]")
    private WebElement confirmButton;

//    @FindBy (id="startAmountCheck")
    @FindBy (xpath = "//span[@class=\"checkbox_label_middle\"]")
    private WebElement amountCheckbox;

    @FindBy (xpath = "(//span[@class=\"ui-slider-handle ui-state-default ui-corner-all\"])[1]")
    private WebElement slider1;

    @FindBy (xpath = "(//span[@class=\"ui-slider-handle ui-state-default ui-corner-all\"])[2]")
    private WebElement slider2;

    @FindBy (id="goal-new-period")
    private  WebElement monthField;


    public void clickAddGoalButton (){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(addGoalButton));
        addGoalButton.click();
    }
    public void clickChildButton(){

        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(childButton));
        childButton.click();
    }

    public void setNewNameField(String name){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(newNameField));
        newNameField.sendKeys(name);
    }

    public void setAmountField(String amount){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(newAmountField));
        newAmountField.sendKeys(amount);
    }
    public void clickNextButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }
    public void clickConfirmButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }

    public void clickCheckbox(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(amountCheckbox));
        if (!amountCheckbox.isSelected()){
            amountCheckbox.click();
        }
    }

    public void moveSlider1(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(slider1));
        WebPageMethods.setSlider(slider1, 70, 0);
    }

    public void moveSlider2(){
//        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(slider2));
        WebPageMethods.setSlider(slider2, 90, 0);
    }
    public void clickMonthField(){
        clickMonthField();
    }
}
