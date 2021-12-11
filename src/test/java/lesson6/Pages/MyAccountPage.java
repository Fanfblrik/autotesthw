package lesson6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasicView {
    @FindBy(xpath = "//a[.='My personal information']")
    public WebElement personalInformation;

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Нажать на кнопку Моя персональная информация")
    public MyPersonalInformationPage clickPersonalInformation() {
        personalInformation.click();
        return new MyPersonalInformationPage(webDriver);
    }

    public HeaderBlock getHeaderBlock() {
        return new HeaderBlock(webDriver);
    }
}
