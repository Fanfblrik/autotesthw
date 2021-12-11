package lesson6.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
    @DisplayName("Работа с магазином: Добавление товара")
    @Description("В этом тесте мы добавляем товар в корзину и доходим до этапа оплаты")
    @Severity(SeverityLevel.BLOCKER)
    void addStuffTest() {

        webDriver.get(URL + "?controller=authentication&back=my-account");

        new LoginPage(webDriver)
                .loginMagazine(email, password)
                .chooseCategory()
                .chooseStuff()
                .addStuff()
                .proceedStuff()
                .proceedOrder()
                .addressAdd()
                .proceedingOrder()
                .confirmOrder()
                .orderCheck();
    }
}
