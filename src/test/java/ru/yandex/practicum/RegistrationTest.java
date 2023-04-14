package ru.yandex.practicum;


import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.api.CreateDeleteUser;
import ru.yandex.practicum.page.RegisterPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static ru.yandex.practicum.data.GenerationData.getRandomStringEng;
import static ru.yandex.practicum.data.GenerationData.getRandomStringRu;


public class RegistrationTest {

    String email;
    String password;
    String name;
    String passwordInvalid;
    String accessToken;

    UrlsForm urlsForm = new UrlsForm();
    RegisterPage registerPage = new RegisterPage();
    CreateDeleteUser createDeleteUser = new CreateDeleteUser();


    @Before
    public void start() {
        urlsForm.openRegisterPage();
        name = getRandomStringRu(5);
        email = getRandomStringEng(5) + "@" + getRandomStringEng(5) + ".ru";
        password = getRandomStringEng(6);
        passwordInvalid = getRandomStringEng(5);
        registerPage.getH2Registration().shouldBe(visible);

    }

    @After
    public void clean() {
        Selenide.closeWebDriver();
        if (accessToken != null) {
            createDeleteUser.delete(accessToken).statusCode(SC_ACCEPTED).extract().path("success");
            createDeleteUser.delete("accessToken");
        }
    }

    @Test
    @DisplayName("Registration success")
    public void registrationSuccessTest() {
        registerPage.createClient(name, email, password);
        registerPage.clickButtonRegistration();
        step("Проверка Открытия формы входа", () -> registerPage.getH2Entry().shouldHave(text("Вход")));
        accessToken = new CreateDeleteUser().login(email, password);
        step("Авторизация пользователя", () -> {
            Selenide.executeJavaScript("localStorage.setItem('accessToken', '" + accessToken + "')");
        });

    }


    @Test
    @DisplayName("Error Registration no validate password")
    public void registrationNoValidatePasswordTest() {
        registerPage.enterName(name);
        registerPage.enterEmail(email);
        registerPage.setPasswordNoValidate(passwordInvalid);
        registerPage.clickButtonRegistration();
        step("Проверка ошибки", () -> registerPage.getError().shouldBe(visible));
        if (!registerPage.getError().isDisplayed()) {
            step("Авторизация пользователя", () -> {
                accessToken = new CreateDeleteUser().login(email, password);
                Selenide.executeJavaScript("localStorage.setItem('accessToken', '" + accessToken + "')");
            });
        }
    }

}
