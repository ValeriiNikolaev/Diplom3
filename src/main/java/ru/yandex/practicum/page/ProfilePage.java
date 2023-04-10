package ru.yandex.practicum.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {
    private final SelenideElement
            exit = $$("button").findBy(text("Выход"));

    public void clickExit() {
        exit.click();
    }
}
