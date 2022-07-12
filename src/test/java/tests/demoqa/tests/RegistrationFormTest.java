package tests.demoqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.RegistrationFormPage;
import tests.demoqa.utils.RandomUtils;

import java.util.Locale;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@DisplayName("RegistrationFormTest тест")
@Tag("RegistrationFormTest")
public class RegistrationFormTest extends TestBase {

    Faker fakerRu = new Faker(new Locale("ru"));

    // My Details
    String firstName = RandomUtils.getRandomStringName(),
            lastName = fakerRu.name().lastName(),
            email = RandomUtils.getRandomEmail(),
            phoneNumber = RandomUtils.getRandomPhoneNumbers(),
            currentAddress = fakerRu.address().fullAddress(),
            myGender = "Other",
            bithDay = "15",
            bithMonth = "January",
            bithYear = "1995",
            mySubject = "English",
            myHobbies = "Music",
            myState = "Haryana",
            myCity = "Panipat",
            file = "1.PNG";

    // My verification details
    String fullName = format("%s %s", firstName, lastName),
            fullBithDate = format("%s %s,%s", bithDay, bithMonth, bithYear),
            myStateAndCity = format("%s %s", myState, myCity);


    @DisplayName("Тест на форму регистрации demoqa")
    @Test
    @AllureId("11177")
    @Owner("allure8")
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        step("Открываем страницу с таблицей", () -> {
            registrationFormPage.openPage();
        });

        step("Вводим имя и фамилию", () -> {
            registrationFormPage.setFirstName(firstName).setLastName(lastName);
        });
        step("Вводим email", () -> {
            registrationFormPage.setEmail(email);
        });
        step("Вводим Gender", () -> {
            registrationFormPage.setGender(myGender);
        });
        step("Вводим номер телефона", () -> {
            registrationFormPage.setNumberPhone(phoneNumber);
        });
        step("Заполняем дату рождения", () -> {
            registrationFormPage.setBirthDay(bithDay, bithMonth, bithYear);
        });
        step("Вводим mySubject", () -> {
            registrationFormPage.setSubject(mySubject);
        });
        step("Вводим Хобби", () -> {
            registrationFormPage.setHobbies(myHobbies);
        });
        step("Подгружаем картинку", () -> {
            registrationFormPage.setUploadPicture(file);
        });
        step("Вводим адрес", () -> {
            registrationFormPage.setCurrentAddress(currentAddress);
        });
        step("Выбираем штат", () -> {
            registrationFormPage.setMyState(myState);
        });
        step("Выбираем город", () -> {
            registrationFormPage.setMyCity(myState, myCity);
        });
        step("Кликаем Готово", () -> {
            registrationFormPage.clickSubmit();
        });

        step("Выполняем проверки корректности заполнения ячеек", () -> {
            registrationFormPage.checkResult("Student Name", fullName).checkResult("Student Email", email).checkResult("Gender", myGender).checkResult("Mobile", phoneNumber).checkResult("Date of Birth", fullBithDate).checkResult("Subjects", mySubject).checkResult("Hobbies", myHobbies).checkResult("Picture", file).checkResult("Address", currentAddress).checkResult("State and City", myStateAndCity).closeTable();
        });
        System.out.println("Тест пройдет успешно");

    }

}
