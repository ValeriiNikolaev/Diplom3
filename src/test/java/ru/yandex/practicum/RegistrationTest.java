package ru.yandex.practicum;


import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.page.RegisterPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;


public class RegistrationTest {
    UrlsForm urlsForm = new UrlsForm();
    RegisterPage registerPage = new RegisterPage();

    @Before
    public void start() {
        urlsForm.openRegisterPage();
    }

    @Test
    @DisplayName("Registration success")
    public void registrationSuccessTest() {
        registerPage.createClient();
        registerPage.clickButtonRegistration();
        step("Проверка Открытия формы входа", () -> registerPage.h2Entry.shouldHave(text("Вход")));
    }

    @Test
    @DisplayName("Error Registration")
    public void registrationErrorTest() {
        registerPage.enterName();
        registerPage.enterEmail();
        registerPage.setPasswordNoValidate();
        registerPage.clickButtonRegistration();
        step("Проверка ошибки", () -> registerPage.error.shouldBe(visible));
    }

}
