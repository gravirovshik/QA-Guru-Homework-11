package tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.DemoqaFormPage;

import static io.qameta.allure.Allure.step;


public class DemoqaFormTest extends TestBase {

    private final DemoqaFormPage demoqaFormPage = new DemoqaFormPage();

    String firstName = "Daria",
            lastName = "Sarycheva",
            userEmail = "daria@test.com",
            gender = "Female",
            userNumber = "8900900999",
            dayOfBirth = "23",
            monthOfBirth = "February",
            yearOfBirth = "1990",
            subjects = "Art",
            hobbies = "Sports",
            pictureName = "tst.jpg",
            address = "World",
            state = "NCR",
            city = "Del";

    @Test
    @Tag("fullFormTest")
    @DisplayName("Проверка полного заполнения формы")
    void fullFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть форму", () -> {
            demoqaFormPage.openPage()
                    .removeBanner();
        });

        step("Заполнение firstName", () ->
                demoqaFormPage.setFirstName(firstName));

        step("Заполнение lastName", () ->
                demoqaFormPage.setLastName(lastName));

        step("Заполнение userEmail", () ->
                demoqaFormPage.setEmail(userEmail));
        step("Заполнение gender", () ->
                demoqaFormPage.setGender(gender));
        step("Заполнение userNumber", () ->
                demoqaFormPage.setUserNumber(userNumber));
        step("Заполнение BirthDay", () ->
                demoqaFormPage.setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth));
        step("Заполнение subjects", () ->
                demoqaFormPage.setSubject(subjects));
        step("Заполнение hobbies", () ->
                demoqaFormPage.setHobby(hobbies));
        step("Заполнение pictureName", () ->
                demoqaFormPage.uploadPicture(pictureName));
        step("Заполнение address", () ->
                demoqaFormPage.setCurrentAddress(address));
        step("Заполнение state", () ->
                demoqaFormPage.setUserState(state));
        step("Заполнение city", () ->
                demoqaFormPage.setUserCity(city));
        step("Нажать Submit", demoqaFormPage::clickSubmit);

        step("Проверка заполненной формы", () -> {
            demoqaFormPage.checkSuccessResult("Student Name", firstName + " " + lastName)
                    .checkSuccessResult("Student Email", userEmail)
                    .checkSuccessResult("Gender", gender)
                    .checkSuccessResult("Mobile", userNumber)
                    .checkSuccessResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkSuccessResult("Subjects", subjects)
                    .checkSuccessResult("Hobbies", hobbies)
                    .checkSuccessResult("Picture", pictureName)
                    .checkSuccessResult("Address", address)
                    .checkSuccessResult("State and City", state + " " + city);
        });
    }
}
