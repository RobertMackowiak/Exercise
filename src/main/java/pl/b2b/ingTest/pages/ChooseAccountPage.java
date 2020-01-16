package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class ChooseAccountPage {

    public ChooseAccountPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }
    public static String cut = "";

    @FindBy(xpath = "//p[contains(text(),'Cel: Wakacje')]/parent::a/div[3]/p[3]")
    private WebElement vacationAccount;

    public void accountNrComparison() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(vacationAccount));
        cut = vacationAccount.getText();
        System.out.println(cut);
    }
    public void clickVacationAccountButton() {
        WebPageMethods.clickElement(vacationAccount);
    }


}