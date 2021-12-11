package lesson6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StuffPage extends BasicView {

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    public WebElement btnAdd;

    public StuffPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Добавить товар в корзину")
    public ProceedCheckoutPage addStuff() {
        btnAdd.click();
        return new ProceedCheckoutPage(webDriver);
    }

}
