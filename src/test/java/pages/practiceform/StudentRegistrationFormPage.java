package pages.practiceform;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormPage {
        CalendarComponents CalendarComponents = new CalendarComponents();
        RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
        public SelenideElement
                // page elements
                titlePage = $(withText("Practice Form")),
                headerPage = $x("//img [@src=\"/images/Toolsqa.jpg\"]"),
                menuPanel = $(".left-pannel"),
                titleForm = $(withText("Student Registration Form")),
                submitButton = $(withText("Submit")),

                // form elements
                firstName = $("[id=firstName]"),
                lastName = $("[id=lastName]"),
                email = $("[id=userEmail]"),
                genderRadio = $("[id=\"genterWrapper\"]"),
                mobile = $x("//input[@placeholder='Mobile Number']"),
                birthDateField = $x("//input[@id=\"dateOfBirthInput\"]"),
                subjectFieldClick = $("[id=\"subjectsContainer\"]"),
                subjectFieldInputElement = $x("//input[@id=\"subjectsInput\"]"),
                hobbies = $("[id=\"hobbiesWrapper\"]"),
                uploadPictureButton = $("#uploadPicture"),
                currentAddress = $("[placeholder=\"Current Address\"]"),
                state = $x("//div[@id=\"state\"]"),
                stateFieldInput = $x("//div[@class=\"css-1g6gooi\"]/div/input[@id=\"react-select-3-input\"]"),
                city = $x("//div[@id=\"city\"]"),
                cityFieldInput =  $x("//div[@class=\"css-1g6gooi\"]/div/input[@id=\"react-select-4-input\"]");

                //check elements available
                public void registrationFormElementsDisplayed (){
                        firstName.isDisplayed();
                        lastName.isDisplayed();
                        email.isDisplayed();
                        genderRadio.isDisplayed();
                        mobile.isDisplayed();
                        birthDateField.isDisplayed();
                        subjectFieldClick.isDisplayed();
                        hobbies.isDisplayed();
                        uploadPictureButton.isDisplayed();
                        currentAddress.isDisplayed();
                        state.isDisplayed();
                        city.isDisplayed();
                };
                public void registrationFormElementsEnabled(){
                        firstName.isEnabled();
                        lastName.isEnabled();
                        email.isEnabled();
                        genderRadio.isSelected();
                        mobile.isEnabled();
                        birthDateField.isEnabled();
                        subjectFieldClick.isEnabled();
                        hobbies.isEnabled();
                        uploadPictureButton.isEnabled();
                        currentAddress.isEnabled();
                        state.isEnabled();
                        city.isEnabled();
                };

                // Actions with elements
                public StudentRegistrationFormPage setFirstName(String value){
                        firstName.setValue(value);
                        return this;
                };
        
                public StudentRegistrationFormPage setLastName(String value){
                        lastName.setValue(value);
                        return this;
                };
        
                public StudentRegistrationFormPage setEmail(String value){
                        email.setValue(value);
                        return this;
                };
        
                public StudentRegistrationFormPage selectGender(String genderRadioElement){
                        genderRadio.$(withText(genderRadioElement)).click();
                        return this;
                };
        
                public StudentRegistrationFormPage setMobile(String mobilePhone){
                        mobile.setValue(mobilePhone);
                        return this;
                };
        
                public StudentRegistrationFormPage setBirthDateField(String month, String year, String day){
                        birthDateField.click();
                        CalendarComponents.setCalendar(month,year,day);
                        return this;
                };
        
                public StudentRegistrationFormPage setSubject(String value){
                        subjectFieldClick.click();
                        subjectFieldInputElement.setValue(value).pressEnter();
                        return this;
                };
        
                public StudentRegistrationFormPage selectHobbies(String hobbiesCheckBoxElement){
                        hobbies.$(withText(hobbiesCheckBoxElement)).click();
                        return this;
                };
        
                public StudentRegistrationFormPage setUploadPictureButton(String path){
                        uploadPictureButton.uploadFile(new File(path));
                        return this;
                };
        
                public StudentRegistrationFormPage setCurrentAddress (String value){
                        currentAddress.setValue(value);
                        return this;
                };
        
                public StudentRegistrationFormPage setState(String value){
                        state.click();
                        stateFieldInput.setValue(value).pressEnter();
                        return this;
                };
        
                public StudentRegistrationFormPage setCity(String value){
                        city.click();
                        cityFieldInput.setValue(value).pressEnter().pressEnter();
                        return this;
                };
        
                public StudentRegistrationFormPage submit(){
                        submitButton.click();
                        return this;
                };
        
                // Actions with page

                public StudentRegistrationFormPage openPage() {
                open("/automation-practice-form");
                $(withText("Practice Form")).shouldHave(Condition.text("Practice Form"));
                        return this;
                };
        
                public StudentRegistrationFormPage scrollToElement(SelenideElement element){
                        element.scrollTo();
                        return this;
                };

                public StudentRegistrationFormPage verifyRegistrationForm(){
                registrationFormElementsDisplayed();
                registrationFormElementsEnabled();
                        return this;
                };

                // Check results
                public StudentRegistrationFormPage verifyResultModalAppears(){
                        registrationResultsModal.verifyModalAppears();
                        return this;
                };

                public StudentRegistrationFormPage verifyResults(String key, String value){
                        registrationResultsModal.verifyResult(key, value);
                        return this;
                        }
        
}
