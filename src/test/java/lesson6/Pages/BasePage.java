package lesson6.Pages;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import lesson6.Pages.HeaderBlock;

public class BasePage extends BasicView {

    @Getter
    private HeaderBlock headerBlock = new HeaderBlock(webDriver);

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }
}

