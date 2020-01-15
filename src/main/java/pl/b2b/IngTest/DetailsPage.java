package pl.b2b.IngTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;

public class DetailsPage {
    public DetailsPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }
    @FindBy(id="transfer-recipient-name")
    private WebElement nameAndAddress;

    @FindBy(id ="amount")
    private WebElement amount;

    @FindBy(id="title")
    private WebElement title;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement next;

    public void putNameAndAddress() {
        nameAndAddress.sendKeys("Monika Kowal Lublin");
    }
    public void putAmount() {
        nameAndAddress.sendKeys("1000");
    }
    public void putTitle(){
        title.sendKeys("przelew");
    }

    public void clickNext(){
        next.click();
    }


}
