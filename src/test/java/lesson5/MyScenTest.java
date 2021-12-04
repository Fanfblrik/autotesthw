package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class MyScenTest {

    @SneakyThrows
    @Test
    void mS() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        webDriver.get("http://automationpractice.com/index.php");

        webDriver.manage().window().setSize(new Dimension(1000, 720));

        webDriver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]")).click();
        webDriver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
        webDriver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
        //new WebDriverWait(webDriver, 10, 500)
        //         .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Proceed to checkout')]")))
        //        .click();
        webDriver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();

        webDriver.findElement(By.name("email")).sendKeys("example@mail.ru");
        webDriver.findElement(By.name("passwd")).sendKeys("11111");
        webDriver.findElement(By.name("SubmitLogin")).click();
        // webDriver.findElement(By.xpath("//span[text()='Add a new address']")).click();
        webDriver.findElement(By.name("lastname")).sendKeys("Иванов");
        webDriver.findElement(By.name("firstname")).sendKeys("Иван");
        webDriver.findElement(By.name("address1")).sendKeys("Moscow Red Square");
        webDriver.findElement(By.name("city")).sendKeys("Moscow");
        webDriver.findElement(By.name("postcode")).sendKeys("00000");
        webDriver.findElement(By.name("phone")).sendKeys("88005553535");
        webDriver.findElement(By.name("alias")).sendKeys("MyAddress");
        webDriver.findElement(By.name("phone_mobile")).sendKeys("88005553536");
        new Select(webDriver.findElement(By.name("id_state"))).selectByVisibleText("Alabama");
        webDriver.findElement(By.name("submitAddress")).click();
        webDriver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
        webDriver.findElement(By.name("cgv")).click();
        webDriver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
        //new WebDriverWait(webDriver, 8).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'In stock\t')]")));

        assertThat(webDriver.findElement(By.xpath("//*[contains(text(), 'In stock')]")).getText())
                .isEqualTo("In stock");

        Thread.sleep(5000);

        webDriver.quit();

    }

}