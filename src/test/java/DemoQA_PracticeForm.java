import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.TextCheck;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQA_PracticeForm extends testData{

    @BeforeEach
    void launchBrowserTest(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize="2880x1800";
        Selenide.clearBrowserCookies();
    }
    @Test
    void filledFormStudentRegistrationForm(){

        //fillingTheForm
        open("/automation-practice-form");
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $(By.cssSelector("[id=\"gender-radio-1\"]")).isSelected();
        $(By.cssSelector("[id=\"gender-radio-2\"]")).isSelected();
        $(By.cssSelector("[id=\"gender-radio-3\"]")).isSelected();
        $(withText("Male")).click();
        $x("//input[@placeholder='Mobile Number']").setValue(mobile);
        $x("//input[@id=\"dateOfBirthInput\"]").click();
        setCalendar("March","1993");
        $(withText("Sports")).click();
        $("[placeholder=\"Current Address\"]").setValue(address);
        $("[id=\"subjectsContainer\"]").click();
        $x("//input[@id=\"subjectsInput\"]").setValue("English").pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/mario03.png"));
        $x("//div[@id=\"state\"]").scrollTo();
        $x("//div[@id=\"state\"]").click();
        $x("//div[@class=\"css-1g6gooi\"]/div/input[@id=\"react-select-3-input\"]").setValue("Haryana").pressEnter();
        $x("//div[@id=\"city\"]").click();
        $x("//div[@class=\"css-1g6gooi\"]/div/input[@id=\"react-select-4-input\"]").setValue("Karnal").pressEnter().pressEnter();

        //valueCheck
        $(withText(firstName+" "+lastName)).shouldHave(Condition.text(firstName+" "+lastName));
        $(withText(email)).shouldHave(Condition.text(email));
        $(withText("Male")).shouldHave(Condition.text("Male"));
        $(withText(mobile)).shouldHave(Condition.text(mobile));
        $(withText("02 March,1993")).shouldHave(Condition.text("02 March,1993"));
        $(withText("English")).shouldHave(Condition.text("English"));
        $(withText("Sports")).shouldHave(Condition.text("Sports"));
        $(withText("mario03.png")).shouldHave(Condition.text("mario03.png"));
        $(withText(address)).shouldHave(Condition.text(address));
        $(withText("Haryana Karnal")).shouldHave(Condition.text(state+" "+city));
        $x("//body[@class=\"modal-open\"]//div[@class=\"modal-footer\"]/button[@id=\"closeLargeModal\"]").isEnabled();
    }
    @AfterEach
    void driverClose(){
        closeWebDriver();
    }
}
