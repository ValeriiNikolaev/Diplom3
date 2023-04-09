package ru.yandex.practicum;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {

    public final SelenideElement
            h2Registration = $("h2"),
            name = $x("//div[label[text() = 'Имя']]/input"),
            email = $x("//div[label[text() = 'Email']]/input"),
            password = $x("//div[label[text() = 'Пароль']]/input"),
            buttonRegistration = $$("button").findBy(text("Зарегистрироваться")),
            h2Entry = $("h2"),
            error = $$("p").findBy(text("Некорректный пароль"));


}
