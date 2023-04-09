package ru.yandex.practicum;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class UrlsForm {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    private static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    private static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";


    public void openMainPage() {
        open(BASE_URL);
    }

    public void openLoginPage() {
        open(LOGIN_URL);

    }

    public void openRegisterPage() {
        open(REGISTER_URL);
    }

}
