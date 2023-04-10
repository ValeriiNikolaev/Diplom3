package ru.yandex.practicum;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.yandex.practicum.GenerationData.getRandomStringEng;
import static ru.yandex.practicum.GenerationData.getRandomStringRu;

public class RegisterPage {


    public final SelenideElement
            h2Registration = $("h2"),
            email = $x("//div[label[text() = 'Email']]/input"),
            name = $x("//div[label[text() = 'Имя']]/input"),
            password = $x("//div[label[text() = 'Пароль']]/input"),
            buttonRegistration = $$("button").findBy(text("Зарегистрироваться")),
            h2Entry = $("h2"),
            error = $$("p").findBy(text("Некорректный пароль")),
            hyperTextEntry = $("a[href='/login']");


    public void createClient() {
        step("Проверка формы регистрации", () -> h2Registration.shouldHave(text("Регистрация")));
        enterName();
        enterEmail();
        setPasswordValidate();
    }

    public void enterName() {
        step("Ввод в поле имя", () -> name.val(getRandomStringRu(5)));
    }

    public void enterEmail() {
        step("Ввод в поле email", () -> email.val(getRandomStringEng(5) + "@" + getRandomStringEng(5) + ".ru"));
    }

    public void setPasswordValidate() {
        step("Ввод в поле пароль", () -> password.val(getRandomStringEng(6)));
    }

    public void setPasswordNoValidate() {
        step("Ввод в поле пароль", () -> password.val(getRandomStringEng(5)));
    }

    public void clickButtonRegistration() {
        step("Клик по кнопке зарегистрироваться", () -> buttonRegistration.click());
    }

    public void clickButtonHyperTextEntry() {
        step("Клик по гипертексту Войти", () -> hyperTextEntry.click());
    }


}
