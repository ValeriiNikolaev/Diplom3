package ru.yandex.practicum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.page.MainPage;

public class ConstructorTest {

    MainPage mainPage = new MainPage();
    UrlsForm urlsForm = new UrlsForm();


    @Before
    public void start() {
        urlsForm.openMainPage();
    }

    @After
    public void finish() {
        Selenide.closeWebDriver();
    }


    @Test
    @DisplayName("Переход к булкам")
    public void transitionBunTest() {
        mainPage.getSauce().click();
        mainPage.getBun().click();
        mainPage.getActive().shouldHave(Condition.text("Булки"));

    }

    @Test
    @DisplayName("Переход к соусам")
    public void transitionSauceTest() {
        mainPage.getSauce().click();
        mainPage.getActive().shouldHave(Condition.text("Соусы"));
    }

    @Test
    @DisplayName("Переход к начинкам")
    public void transitionFillingTest() {
        mainPage.getFilling().click();
        mainPage.getActive().shouldHave(Condition.text("Начинки"));

    }

}
