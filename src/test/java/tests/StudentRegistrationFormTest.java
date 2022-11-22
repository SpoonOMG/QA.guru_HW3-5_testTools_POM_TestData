package tests;

import org.junit.jupiter.api.*;
import pages.BasePage;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultsModal;
import pages.practiceForm.StudentRegistrationFormPage;
import testData.TestData;

public class StudentRegistrationFormTest extends BasePage {
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    TestData testData = new TestData();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    @Test
    void filledFormStudentRegistrationForm() {

        //fillingTheForm
        studentRegistrationFormPage.openPage()
                .verifyRegistrationForm()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .selectGender(testData.gender)
                .setMobile(testData.mobile)
                .setBirthDateField(testData.monthRandom, testData.yearRandom, testData.dayRandom)
                .setSubject(testData.subject)
                .selectHobbies(testData.hobbies)
                .setUploadPictureButton(testData.pictureSrc)
                .setCurrentAddress(testData.address)
                .scrollToElement(studentRegistrationFormPage.city)
                .setState(testData.state)
                .setCity(testData.city);
        //check the modal
        studentRegistrationFormPage.verifyRegistrationForm()
                .verifyResultModalAppears()
                .verifyResults("Student Name", testData.firstName+" "+testData.lastName)
                .verifyResults("Student Email", testData.email)
                .verifyResults("Gender", testData.gender)
                .verifyResults("Mobile", testData.mobile)
                .verifyResults("Date of Birth", testData.selectedDate)
                .verifyResults("Subjects", testData.subject)
                .verifyResults("Hobbies", testData.hobbies)
                .verifyResults("Picture", testData.pictureName)
                .verifyResults("Address", testData.address)
                .verifyResults("State and City", testData.state+" "+testData.city);


    }
}
