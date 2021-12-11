package lesson6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MagazinePage extends BasicView {

    @FindBy(xpath = "//li[3]/a[(text()='T-shirts')]")
    public WebElement btn;

    public MagazinePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Выбрать категорию товаров")
    public TShirtsPage chooseCategory() {
        btn.click();
        return new TShirtsPage(webDriver);
    }

}
