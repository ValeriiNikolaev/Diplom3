package ru.yandex.practicum.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ForgotPassword {
    private final SelenideElement

            hyperTextEntry = $("a[href='/login']");

    public void clickButtonHyperTextEntryToForgotPassword() {
        step("Клик по гипертексту Войти", () -> hyperTextEntry.click());
    }
}
