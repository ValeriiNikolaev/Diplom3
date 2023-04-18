package ru.yandex.practicum.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

;

public class MainPage {


    private  final SelenideElement
            personalAccount = $("a[href='/account']");
    private  final SelenideElement
            buttonEnterAccount = $$("button").findBy(text("Войти в аккаунт"));
    private  final SelenideElement
            constructor = $$("a[href='/']").findBy(text("Конструктор"));
    private  final SelenideElement
            logo = $("a[href='/']");
    private  final SelenideElement
            bun = $$("div span").findBy(text("Булки"));
    private  final SelenideElement
            sauce = $$("div span").findBy(text("Соусы"));
    private  final SelenideElement
            h1TextCreateBurger = $$("h1").findBy(text("Соберите бургер"));
    private  final SelenideElement
            filling = $$("div span").findBy(text("Начинки"));
    private  final SelenideElement
            active = $x("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");



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

    public SelenideElement getActive() {
        return (active);
    }


}

