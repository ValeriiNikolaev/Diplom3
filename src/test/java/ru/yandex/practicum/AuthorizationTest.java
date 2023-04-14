package ru.yandex.practicum;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.api.CreateDeleteUser;
import ru.yandex.practicum.data.GenerationData;
import ru.yandex.practicum.page.ForgotPassword;
import ru.yandex.practicum.page.LoginPage;
import ru.yandex.practicum.page.MainPage;
import ru.yandex.practicum.page.RegisterPage;


public class AuthorizationTest {

    String name;
    String email;
    String password;
    String accessToken;
    UrlsForm urlsForm = new UrlsForm();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ForgotPassword forgotPassword = new ForgotPassword();

    public void startYandex() {
        System.setProperty("webdriver.chrome.driver", "d:\\Webdriver\\bin\\yandexdriver.exe");
        System.setProperty("selenide.browser", "Chrome");
    }

    CreateDeleteUser createDeleteUser = new CreateDeleteUser();

    @Before
    public void start() {
        name = GenerationData.getRandomStringEng(5);
        email = GenerationData.getRandomStringEng(5) + "@" + GenerationData.getRandomStringRu(5) + ".ru";
        password = GenerationData.getRandomStringEng(6);
        ValidatableResponse response = createDeleteUser.create(email, password, name);
        accessToken = response.extract().path("accessToken");

    }

    @After
    public void clean() {
        createDeleteUser.delete(accessToken);
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Successfully authorization through button Enter  in main page")
    public void checkButtonEnterAccountMainPageTest() {
        urlsForm.openMainPage();
        mainPage.clickButtonEntryToAccount();
        loginPage.authorization(email, password);
    }

    @Test
    @DisplayName("Successfully authorization through button Personal_Account in main page")
    public void enterButtonPersonalAccountTest() {
        urlsForm.openMainPage();
        mainPage.clickPersonalAccount();
        loginPage.authorization(email, password);
    }

    @Test
    @DisplayName("Successfully authorization through Link in form Registrations page")
    public void checkLinkEnterRegistrationsPageTest() {
        urlsForm.openRegisterPage();
        registerPage.clickLinkEnter();
        loginPage.authorization(email, password);
    }


    @Test
    @DisplayName("Successfully authorization through Link in form Forgot_Password Page")
    public void checkLinkEnterForgotPasswordPageTest() {
        urlsForm.openForgotPasswordPage();
        forgotPassword.clickButtonHyperTextEntryToForgotPassword();
        loginPage.authorization(email, password);
    }

}
