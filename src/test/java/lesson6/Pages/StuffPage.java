package lesson6.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StuffPage extends BasicView {

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    public WebElement btnAdd;

    public StuffPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProceedCheckoutPage addStuff() {
        btnAdd.click();
        return new ProceedCheckoutPage(webDriver);
    }

}
