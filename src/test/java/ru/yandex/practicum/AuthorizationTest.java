package ru.yandex.practicum;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AuthorizationTest {

    String name;
    String email;
    String password;
    String accessToken;

    @Before
    public void start() {
        name = GenerationData.getRandomStringEng(5);
        email = GenerationData.getRandomStringEng(5) + "@" + GenerationData.getRandomStringRu(5) + ".ru";
        password = GenerationData.getRandomStringEng(6);
        CreateDeleteUser createDeleteUser = new CreateDeleteUser();
        ValidatableResponse response = createDeleteUser.create(email, password, name);
        accessToken = response.extract().path("accessToken");

    }

    @After
    public void clean() {

        CreateDeleteUser createDeleteUser = new CreateDeleteUser();
        createDeleteUser.delete(accessToken);
        Selenide.closeWebDriver();

    }


    @Test
    @DisplayName("Entry click button Entry to account in main page")
    public void checkButtonEntryToAccountMainPageTest() {
        UrlsForm urlsForm = new UrlsForm();
        urlsForm.openMainPage();
        MainPage mainPage = new MainPage();
        mainPage.clickButtonEntryToAccount();
        LoginPage loginPage = new LoginPage();
        loginPage.clickButtonEntry();
        loginPage.authorization(email, password);
    }

    @Test
    @DisplayName("Entry click button Entry to personal Account in main page")
    public void entryToPersonalAccountTest() {
        UrlsForm urlsForm = new UrlsForm();
        urlsForm.openMainPage();
        MainPage mainPage = new MainPage();
        mainPage.clickPersonalAccount();
        LoginPage loginPage = new LoginPage();
        loginPage.clickButtonEntry();
        loginPage.authorization(email, password);
    }

    @Test
    @DisplayName("Entry click to buttonHyperText in form registrations" +
            "")
    public void entryButtonHyperTextEntryInRegistrationsPageTest() {
        UrlsForm urlsForm = new UrlsForm();
        urlsForm.openRegisterPage();
        RegisterPage registerPage= new RegisterPage();
        registerPage.clickButtonHyperTextEntry();
        LoginPage loginPage = new LoginPage();
        loginPage.clickButtonEntry();
        loginPage.authorization(email, password);
    }


    @Test
    @DisplayName("Entry click to buttonHyperText in form ForgotPasswordPage")
    public void entryButtonHyperTextEntryForgotPasswordPageTest() {
        UrlsForm urlsForm = new UrlsForm();
        urlsForm.openForgotPasswordPage();
        ForgotPassword forgotPassword = new ForgotPassword();
        forgotPassword.hyperTextEntry.click();
        LoginPage loginPage = new LoginPage();
        loginPage.clickButtonEntry();
        loginPage.authorization(email, password);
    }






}
