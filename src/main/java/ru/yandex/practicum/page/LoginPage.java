package ru.yandex.practicum;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class LoginPage {


    public final SelenideElement
            buttonEntry = $$("button").findBy(text("Войти")),
            emailField = $x("//div[label[text() = 'Email']]/input"),
            passwordField = $x("//div[label[text() = 'Пароль']]/input"),
            h2Entry = $("h2"),
            buttonOrder = $$("button").findBy(text("Оформить заказ"));

    public void clickButtonEntry() {
        buttonEntry.click();
    }

    public void checkVisibleH2Entry() {
        h2Entry.shouldBe(visible);
    }

    public void checkSuccessEntry() {
        buttonOrder.shouldBe(visible);
    }
    public void checkVisibleButtonEntry() {
        buttonEntry.shouldBe(visible);
    }

    @Step("Ввод email")
    public void setEmail(String email) {
        emailField.click();
        emailField.setValue(email);
    }

    @Step("Ввод password")
    public void setPassword(String password) {
        passwordField.click();
        passwordField.setValue(password);
    }



    @Step("Вход пользователя")
    public void authorization(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickButtonEntry();
        step("Првоерка видимости кнопки Оформить заказ", this::checkSuccessEntry);

    }


}
