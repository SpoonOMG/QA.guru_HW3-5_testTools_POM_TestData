import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class testData {
    Faker faker = new Faker();

    String name = faker.name().fullName(); // Miss Samanta Schmidt
    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton
    String email = firstName+"_"+lastName+"@gmail.com";
    String mobile = faker.phoneNumber().subscriberNumber(10);
    String birthDate = faker.date().birthday(19,65).toString();
    String subject = faker.programmingLanguage().name();
    String address = faker.address().fullAddress();

    String state = "Haryana";
    String city = "Karnal";

    public void setCalendar(String month, String year) {
        $x("//select[@class=\"react-datepicker__month-select\"]").selectOption(month);
        $x("//select[@class=\"react-datepicker__year-select\"]").selectOption(year);
        $x("//div[@class='react-datepicker__day react-datepicker__day--002']").click();
    }


}
