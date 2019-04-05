package com.luxoft.ak47;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class TradeEventControllerTest {

    @Test
    void tradeEvent() {
        //Unit test below commented:
        //new TradeEventController().tradeEvent();
                when().get( "/tradeEvent")
                .then().statusCode(200);
    }

    @Test
    void shouldGet404OnNonExistingPage() {
        when().get("/nonExisting").then().statusCode(404);
    }

    @Test
    void  shouldReturnTradesWithVersion0() {
        when().get("/tradeEvent").then()
                .statusCode(200)
                .body("tradeEvent.version", equalTo("0"));
    }
}