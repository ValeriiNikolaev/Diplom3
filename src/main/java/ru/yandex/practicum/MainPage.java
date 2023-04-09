package ru.yandex.practicum;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    UrlsForm urlsForm = new UrlsForm();

    private final SelenideElement
        personalAccount = $("a[href='/account']"),
        buttonEnterAccount = $$("button").findBy(text("Войти в аккаунт")),
        constructor = $("a[href='/']"),
        bun = $$("div").findBy(text("Булки")),
        sauce = $$("div").findBy(text("Соусы")),
        filling = $$("div").findBy(text("Начинки"));




    @Test
    public void testTest(){
        urlsForm.openMainPage();
        sauce.click();
        filling.click();
        bun.click();
    }



}
