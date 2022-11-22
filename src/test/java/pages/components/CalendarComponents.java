package pages.components;

import testData.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponents extends TestData {

    public void setCalendar(String month, String year, String day) {
        $x("//select[@class=\"react-datepicker__month-select\"]").selectOption(month);
        $x("//select[@class=\"react-datepicker__year-select\"]").selectOption(year);
        $(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month").click();
        //$x("//div[@class='react-datepicker__day react-datepicker__day--0"+day+"']").click();
    }

}
