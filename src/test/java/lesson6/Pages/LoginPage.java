package lesson6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicView {

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "passwd")
    public WebElement passwd;

    @FindBy(id = "SubmitLogin")
    public WebElement submitLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Авторизоваться юзером {0} с паролем {1}")
    public MyAccountPage loginAccount(String email, String password) {
        this.email.sendKeys(email);
        passwd.sendKeys(password);
        submitLogin.click();
        return new MyAccountPage(webDriver);
    }

    @Step("Авторизоваться юзером {0} с паролем {1}")
    public MagazinePage loginMagazine(String email, String password) {
        this.email.sendKeys(email);
        passwd.sendKeys(password);
        submitLogin.click();
        return new MagazinePage(webDriver);
    }
}
