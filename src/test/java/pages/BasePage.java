package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BasePage {

    @BeforeAll
    static void selenoidConnection(){
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
    @BeforeEach
    void launchBrowserTest(){
        SelenideLogger.addListener("allure",new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize="2880x1800";
        Selenide.clearBrowserCookies();
    };
    @AfterEach
    void driverClose()
    {
        closeWebDriver();
    }
    @AfterEach
    void attachments(){

    }
}
