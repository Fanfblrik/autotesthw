package lesson6.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProceedCheckoutPage extends BasicView {

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    public WebElement btnProceedStuff;

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    public WebElement btnProceedOrder;

    public ProceedCheckoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProceedCheckoutPage proceedStuff() {
        btnProceedStuff.click();
        return new ProceedCheckoutPage(webDriver);
    }

    public AddAddressPage proceedOrder() {
        btnProceedOrder.click();
        return new AddAddressPage(webDriver);
    }

    public ConfirmationPage proceedingOrder() {
        btnProceedOrder.click();
        return new ConfirmationPage(webDriver);
    }

}
