package ru.yandex.practicum;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.api.CreateDeleteUser;
import ru.yandex.practicum.data.GenerationData;
import ru.yandex.practicum.page.LoginPage;
import ru.yandex.practicum.page.MainPage;
import ru.yandex.practicum.page.ProfilePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class TransitionTest {

    String name;
    String email;
    String password;
    String accessToken;
    UrlsForm urlsForm = new UrlsForm();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();


    @Before
    public void start() {
        name = GenerationData.getRandomStringEng(5);
        email = GenerationData.getRandomStringEng(5) + "@" + GenerationData.getRandomStringRu(5) + ".ru";
        password = GenerationData.getRandomStringEng(6);
        CreateDeleteUser createDeleteUser = new CreateDeleteUser();
        ValidatableResponse response = createDeleteUser.create(email, password, name);
        accessToken = response.extract().path("accessToken");
        urlsForm.openMainPage();
        mainPage.clickButtonEntryToAccount();
        loginPage.clickButtonEntry();
        loginPage.authorization(email, password);

    }

    @After
    public void clean() {

        CreateDeleteUser createDeleteUser = new CreateDeleteUser();
        createDeleteUser.delete(accessToken);
        Selenide.closeWebDriver();

    }

    @Test
    @DisplayName("click-through to the \"Personal Account\"")
    public void clickThroughPersonalAccountTest() {
        urlsForm.openMainPage();
        mainPage.clickPersonalAccount();
        step("Проверка что мы в личном кабинете", () ->
                $$("p").findBy(text("В этом разделе вы можете изменить свои персональные данные")));
    }

    @Test
    @DisplayName("click-through to the \"Constructor\"")
    public void clickThroughConstructorTest() {
        urlsForm.openMainPage();
        mainPage.clickPersonalAccount();
        mainPage.clickButtonConstructor();
        step("Проверка что перешли и кнопка оформить заказ(авторизованы)", () -> {
            mainPage.getH1TextCreateBurger().shouldBe(visible);
            loginPage.buttonOrder.shouldBe(visible);
        });
    }

    @Test
    @DisplayName("click-through to the \"Logotype\"")
    public void clickThroughLogotypeTest() {
        urlsForm.openMainPage();
        mainPage.clickPersonalAccount();
        mainPage.clickLogo();
        step("Проверка что перешли и кнопка оформить заказ(авторизованы)", () -> {
            mainPage.getH1TextCreateBurger().shouldBe(visible);
            loginPage.buttonOrder.shouldBe(visible);
        });
    }

    @Test
    @DisplayName("logout")
    public void logoutTest() {
        urlsForm.openMainPage();
        mainPage.clickPersonalAccount();
        profilePage.clickExit();
        step("Проверка отбражения страницы авторизации", () -> {
            loginPage.checkVisibleButtonEntry();
            loginPage.checkVisibleH2Entry();
        });
    }

}
