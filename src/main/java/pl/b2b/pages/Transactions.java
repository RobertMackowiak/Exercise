package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;

public class Transactions {
    public Transactions() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = ("(//p[@class=\"product-tile__name\"])[3]"))
    private WebElement celWakacje;

    public void clickcelWakacje(){
        celWakacje.click();
    }










}
