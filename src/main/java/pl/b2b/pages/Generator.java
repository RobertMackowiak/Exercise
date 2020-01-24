package pl.b2b.pages;

import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;

public class Generator {
    public Generator(){
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    public void generateNo (){
        SingletonWebdriver.getDriver().get("https://login.ingbank.pl/mojeing/demo/#home");

    }
}
