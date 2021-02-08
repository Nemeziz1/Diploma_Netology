package ru.netology.web.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class APITests {
    @Test
    void shouldReturnOK() {
        given()
                .baseUri("http://localhost:8080")
        .when()
            .post("/api/v1/pay")
        .then()
            .statusCode(200)
        ;
    }
}
