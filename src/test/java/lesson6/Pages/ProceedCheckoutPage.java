package lesson6.Pages;

import io.qameta.allure.Step;
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

    @Step("Продолжить работу с товаром")
    public ProceedCheckoutPage proceedStuff() {
        btnProceedStuff.click();
        return new ProceedCheckoutPage(webDriver);
    }
    @Step("Продолжить работу с заказом")
    public AddAddressPage proceedOrder() {
        btnProceedOrder.click();
        return new AddAddressPage(webDriver);
    }

    @Step("Подтвердить заказ")
    public ConfirmationPage proceedingOrder() {
        btnProceedOrder.click();
        return new ConfirmationPage(webDriver);
    }

}
