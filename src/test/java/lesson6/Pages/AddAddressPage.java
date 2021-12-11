package lesson6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAddressPage extends BasicView {

    private final String lastName = "Иванов";
    private final String firstName = "Иван";
    private final String addresS1 = "Moscow Red Square";
    private final String citY = "Moscow";
    private final String postCode = "00000";
    private final String pHone = "88005553535";
    private final String aLias = "MyAddress";
    private final String phoneMobile = "88005553536";


    @FindBy(name = "submitAddress")
    public WebElement submitBtn;

    @FindBy(name = "id_state")
    public WebElement idState;

    @FindBy(name = "lastname")
    public WebElement lastname;

    @FindBy(name = "firstname")
    public WebElement firstname;

    @FindBy(name = "address1")
    public WebElement address1;

    @FindBy(name = "city")
    public WebElement city;

    @FindBy(name = "postcode")
    public WebElement postcode;

    @FindBy(name = "phone")
    public WebElement phone;

    @FindBy(name = "alias")
    public WebElement alias;

    @FindBy(name = "phone_mobile")
    public WebElement phone_mobile;

    public AddAddressPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Создать адрес")
    public ProceedCheckoutPage addressAdd() {
        lastname.sendKeys(lastName);
        firstname.sendKeys(firstName);
        address1.sendKeys(addresS1);
        city.sendKeys(citY);
        postcode.sendKeys(postCode);
        phone.sendKeys(pHone);
        alias.sendKeys(aLias);
        phone_mobile.sendKeys(phoneMobile);
        idState.sendKeys("Alabama");
        submitBtn.click();
        return new ProceedCheckoutPage(webDriver);
    }

}
