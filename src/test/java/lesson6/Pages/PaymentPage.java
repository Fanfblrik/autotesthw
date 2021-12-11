package lesson6.Pages;

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

    public StuffPage orderCheck() {
        assertThat(text.getText())
                .isEqualTo("In stock");
        return new StuffPage(webDriver);
    }
}
