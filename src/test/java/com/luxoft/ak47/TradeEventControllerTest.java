package com.luxoft.ak47;

import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.hamcrest.text.CharSequenceLength;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasXPath;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.CharSequenceLength.hasLength;
import static org.junit.jupiter.api.Assertions.*;

class TradeEventControllerTest {

    @Test
    void tradeEvent() {
        //Unit test below commented:
        //new TradeEventController().tradeEvent();
                when().get( "/tradeEvent/x")   //to fix
                .then().statusCode(200);
    }

    @Test
    void shouldGet404OnNonExistingPage() {
        when().get("/nonExisting").then().statusCode(404);
    }

    @Test
    void  shouldReturnTradesWithVersion0() {
        String id = "sampleId";
        when().get("/tradeEvent/{id}", id).then()
                .statusCode(200)
                .body("tradeEvent.version", equalTo("0"))
                .body("tradeEvent.id", equalTo(id))
                .body(not(hasXPath("/tradeEvent/tradeLocation")));
    }

    @Test
    void shouldHaveTradeLocationFromObs() {
        when().get("/tradeEvent/OBS-123")
                .then()
                .body("tradeEvent.tradeLocation", equalTo("HKG"));

        //homework
        //fix this test
    }

    @Test
    void shouldNotHaveTradeLocationFromOtherThanObs() {
        when().get("/tradeEvent/MOR-555")
                .then()
                .body(not(hasXPath("/tradeEvent/tradeLocation")));
    }


    @Test
    void shouldHaveThreeCharactersForCurrency() {
         when().get("/tradeEvent/MUREX-333")
                .then()
                .body("/tradeEvent.currency", hasLength(3));
    }
    @Test
    void shouldHaveThreeUppercasedCharactersForCurrency() {
        String currency = when().get("/tradeEvent/MUREX-333")
                .then()
                .extract().xmlPath().getString("/tradeEvent.currency");
        Assertions.assertThat(currency).isUpperCase().hasSize(3);

    }

    //one more test that currency has uppercase 3 characters
    //controller should return random currency from a list
}