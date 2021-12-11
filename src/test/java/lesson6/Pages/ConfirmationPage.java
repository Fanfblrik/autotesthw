package lesson6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasicView {

    @FindBy(name = "processCarrier")
    public WebElement confirmBtn;

    @FindBy(name = "cgv")
    public WebElement checkBox;

    public ConfirmationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Оформить заказ")
    public PaymentPage confirmOrder() {
        checkBox.click();
        confirmBtn.click();
        return new PaymentPage(webDriver);
    }
}
