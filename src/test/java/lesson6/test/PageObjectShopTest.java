package lesson6.test;

import lesson5.BasicTest;
import lesson6.Pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;


import java.util.Locale;

public class PageObjectShopTest extends BasicTest {
    private static final String URL = "http://automationpractice.com/index.php";

    private final String email = "example@mail.ru";
    private final String password = "11111";

    private final Faker faker = new Faker(new Locale("ru"));

    @Test
    @DisplayName("Редактирование профиля: Изменить имя")
    void changeFirstNameTest() {
        String name = faker.name().firstName();

        webDriver.get(URL + "?controller=authentication&back=my-account");

        new LoginPage(webDriver)
                .login(email, password)
                .clickPersonalInformation()
                .changeFirstName(name, password)
                .backToAccount()
                .clickPersonalInformation()
                .checkFirstName(name);
    }
}
