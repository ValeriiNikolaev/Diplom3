package ru.yandex.practicum;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

;

public class MainPage {


    private  final SelenideElement
            personalAccount = $("a[href='/account']"),
            buttonEnterAccount = $$("button").findBy(text("Войти в аккаунт")),
            constructor = $$("a[href='/']").findBy(text("Конструктор")),
            logo = $("a[href='/']"),
            bun = $$("div span").findBy(text("Булки")),
            sauce = $$("div span").findBy(text("Соусы")),
            h1TextCreateBurger = $$("h1").findBy(text("Соберите бургер")),
            filling = $$("div span").findBy(text("Начинки")),
            h2Bun = $$("h2").findBy(text("Булки")),
            h2Sauce = $$("h2").findBy(text("Соусы")),
            h2Filling = $$("h2").findBy(text("Начинки"));

    public  String
    selectElement  = "rgb(76, 76, 25)";


    public void clickButtonEntryToAccount() {
        buttonEnterAccount.click();
    }

    public void clickPersonalAccount() {
        personalAccount.click();
    }

    public void clickButtonConstructor() {
        constructor.click();
    }


    public SelenideElement getH1TextCreateBurger() {
        return h1TextCreateBurger;
    }

    public void clickLogo() {
        logo.click();
    }

    public SelenideElement getBun() {
        return (bun);
    }

    public SelenideElement getSauce() {
        return (sauce);
    }

    public SelenideElement getFilling() {
        return (filling);
    }

    public SelenideElement getH2Bun () {
        return (h2Bun);
    }

    public SelenideElement getH2Sauce () {
        return (h2Sauce);
    }

    public SelenideElement getH2Filling () {
        return (h2Filling);
    }



}

