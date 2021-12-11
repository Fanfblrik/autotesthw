package lesson6.test;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lesson5.BasicTest;
import lesson6.Pages.LoginPage;



import static io.qameta.allure.Allure.parameter;

@DisplayName("Тесты магазина одежды")
public class ShopWithoutPageObjectTest extends BasicTest {
    private final String username = "autosupertravel+1117140805004@yandex.ru";
    private final String password = "12345";
    private final Faker faker = new Faker();

    @Test
    @DisplayName("Изменение имени")
    @Description("В этом тесте мы меняем имя и проверяем, что оно корректно изменилось")
    @Severity(SeverityLevel.BLOCKER)
    void changeFirstNameTest() {
        String name = faker.name().firstName();

        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=identity");

        new LoginPage(webDriver).loginAccount(username, password)
                .clickPersonalInformation()
                .changeFirstName(name)
                .inputPassword(password)
                .clickSaveButton()
                .clickBackToYourAccountButton()
                .clickPersonalInformation()
                .checkFirstName(name);
    }


    @Test
    @DisplayName("Изменение фамилии")
    @Description("В этом тесте мы меняем фамилию и проверяем, чтио оно корректно изменилось")
    @Severity(SeverityLevel.BLOCKER)
    void changeLastNameTest() {
        String name = faker.name().lastName();

        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=identity");
        new LoginPage(webDriver).loginAccount(username, password)
                .clickPersonalInformation()
                .changeLastName(name)
                .inputPassword(password)
                .clickSaveButton()
                .clickBackToYourAccountButton()
                .clickPersonalInformation()
                .checkLastName(name);
    }

    @DisplayName("Положить в корзину одежду с разных страниц")
    @ParameterizedTest(name = "Со страницы {0}")
    @ValueSource(strings = {"Summer Dresses", "T-shirts"})
    @Severity(SeverityLevel.CRITICAL)
    void selectSummerDressTest(String secondTab) {
        parameter("Название страницы", secondTab);
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=identity");
        new LoginPage(webDriver).loginAccount(username, password)
                .getHeaderBlock()
                .goToPage("Women", secondTab)
                .selectProduct(0)
                .checkProductAdded();
    }
}