package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BasePage {

    @BeforeEach
    void launchBrowserTest(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize="2880x1800";
        Selenide.clearBrowserCookies();
    };
    @AfterEach
    void driverClose()
    {
        closeWebDriver();

    }
}
