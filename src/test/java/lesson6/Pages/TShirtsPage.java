package lesson6.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TShirtsPage extends BasicView {

    @FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    public WebElement tShirt;

    public TShirtsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public StuffPage chooseStuff() {
        tShirt.click();
        return new StuffPage(webDriver);
    }

}
