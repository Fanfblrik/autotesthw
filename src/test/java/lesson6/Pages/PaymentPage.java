package lesson6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentPage extends BasicView {

    @FindBy(xpath = "//*[contains(text(), 'In stock')]")
    public WebElement text;

    public PaymentPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Проверить оформление заказа")
    public StuffPage orderCheck() {
        assertThat(text.getText())
                .isEqualTo("In stock");
        return new StuffPage(webDriver);
    }
}
