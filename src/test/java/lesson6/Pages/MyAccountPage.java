package lesson6.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasicView {
    @FindBy(xpath = "//a[.='My personal information']")
    public WebElement personalInformation;

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MyPersonalInformationPage clickPersonalInformation() {
        personalInformation.click();
        return new MyPersonalInformationPage(webDriver);
    }
}
