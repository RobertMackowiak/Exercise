package pl.b2b.IngTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class ChooseAccountPage {
    public ChooseAccountPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//p[contains(text(),'Cel: Wakacje')]/parent::div/p[2]/")
    private WebElement vacationAccount;

    public String accountNrComparison() {
        String cut;
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(vacationAccount));
        cut = vacationAccount.getText();
        System.out.println(cut);
        return cut;
    }
    public void clickVacationAccountButton() {
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(vacationAccount));
        vacationAccount.click();
    }

}