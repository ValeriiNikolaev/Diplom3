package ru.yandex.practicum;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CreateDeleteUser {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site/api";
    public static final String USER_REGISTER_POST = "/auth/register";
    public static final String USER_DEL_DELETE = "/auth/user";

    public static RequestSpecification spec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI)
                .build();
    }

    @Step("Создание юзера")
    public ValidatableResponse create(String email, String password, String name) {
        String json = "{\"email\":\"" + email + "\","
                + "\"password\":\"" + password + "\","
                + "\"name\":\"" + name + "\"}";
        return given()
                .spec(spec())
                .body(json)
                .when()
                .post(USER_REGISTER_POST)
                .then();
    }

    @Step("Удаление юзера ")
    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(spec())
                .header("authorization", accessToken)
                .when()
                .delete(USER_DEL_DELETE)
                .then();
    }
}