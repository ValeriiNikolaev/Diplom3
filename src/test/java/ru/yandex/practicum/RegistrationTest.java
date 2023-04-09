package ru.yandex.practicum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;
import static ru.yandex.practicum.GenerationData.*;

public class RegistrationTest {
    UrlsForm urlsForm = new UrlsForm();
    RegisterPage registerPage = new RegisterPage();

    @Test
    @DisplayName("Registration success")
    public void registrationSuccessTest() {
        urlsForm.openRegisterPage();
        step("Проверка формы регистрации", () -> registerPage.h2Registration.shouldHave(text("Регистрация")));
        step("Ввод в поле имя", () -> registerPage.name.val(getRandomStringRu(5)));
        step("Ввод в поле email", () -> registerPage.email.val(getRandomStringEng(5) + "@" + getRandomStringEng(5) + ".ru"));
        step("Ввод в поле пароль", () -> registerPage.password.val(getRandomStringEng(6)));
        step("Клик по кнопке зарегистрироваться", () -> registerPage.buttonRegistration.click());
        step("Открытие формы входа", () -> registerPage.h2Entry.shouldHave(text("Вход")));

    }

    @Test
    @DisplayName("Error Registration")
    public void registrationErrorTest() {
        urlsForm.openRegisterPage();
        step("Ввод валидных Имя + Емаил", () -> {
            registerPage.name.val(getRandomStringRu(5));
            registerPage.email.val(getRandomStringEng(5) + "@" + getRandomStringEng(5) + ".ru");
        });
        step("Некорректный ввод в поле пароль ", () -> registerPage.password.val(getRandomStringEng(5)));
        step("Клик по кнопке зарегистрироваться", () -> registerPage.buttonRegistration.click());
        step("Проверка ошибки", () -> registerPage.error.shouldBe(visible));
    }

}
