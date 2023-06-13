package ru.yandex.practicum.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegisterPage {


    private final SelenideElement
            h2Registration = $("h2");
    private final SelenideElement
            emailInput = $x("//div[label[text() = 'Email']]/input");
    private final SelenideElement
            nameInput = $x("//div[label[text() = 'Имя']]/input");
    private final SelenideElement
            passwordInput = $x("//div[label[text() = 'Пароль']]/input");
    private final SelenideElement
            buttonRegistration = $$("button").findBy(text("Зарегистрироваться"));
    private final SelenideElement
            h2Entry = $("h2");
    private final SelenideElement
            error = $$("p").findBy(text("Некорректный пароль"));
    private final SelenideElement
            hyperTextEntry = $("a[href='/login']");




    @Step("Create  user")
    public void createClient(String name, String email, String Password) {
        enterName(name);
        enterEmail(email);
        setPasswordValidate(Password);
    }

    public void enterName(String name) {
        step("Ввод в поле имя", () -> nameInput.val(name));
    }

    public void enterEmail(String email) {
        step("Ввод в поле email", () -> emailInput.val(email));
    }

    public void setPasswordValidate(String password) {
        step("Ввод в поле пароль", () -> passwordInput.val(password));
    }

    public void setPasswordNoValidate(String passwordInvalid) {
        step("Ввод в поле пароль", () -> passwordInput.val(passwordInvalid));
    }

    public void clickButtonRegistration() {
        step("Клик по кнопке зарегистрироваться", () -> buttonRegistration.click());

    }

    public void clickLinkEnter() {
        step("Клик по link Войти", () -> hyperTextEntry.click());
    }


    public SelenideElement getError() {
        return error;
    }

    public SelenideElement getH2Entry() {
        return h2Entry;
    }

    public SelenideElement getH2Registration() {
        return h2Registration;
    }

    @Step("Entering the data of the created user")
    public void enterDataCreatedUser(String email, String password) {
        enterEmail(email);
        setPasswordValidate(password);
    }
}
