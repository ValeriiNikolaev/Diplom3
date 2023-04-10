package ru.yandex.practicum;


import static com.codeborne.selenide.Selenide.open;


public class UrlsForm {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    private static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";
    private static final String FORGOT_URL = "https://stellarburgers.nomoreparties.site/forgot-password";



    public void openMainPage() {
        open(BASE_URL);
    }


    public void openRegisterPage() {
        open(REGISTER_URL);
    }

    public void openForgotPasswordPage() {
        open(FORGOT_URL);
    }





}
