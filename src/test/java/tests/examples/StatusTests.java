package tests.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class StatusTests {
    //curl 'https://selenoid.autotests.cloud/status' \
    //  -H 'Accept: */*' \
    //  -H 'Accept-Language: ru,en;q=0.9' \
    //  -H 'Connection: keep-alive' \
    //  -b '_pubcid=3d6b75c8-55f4-4917-bfbe-56606fdc2974; _cc_id=945b4274861fc2f31e7e6206f02d2dbc' \
    //  -H 'Referer: https://selenoid.autotests.cloud/' \
    //  -H 'Sec-Fetch-Dest: empty' \
    //  -H 'Sec-Fetch-Mode: cors' \
    //  -H 'Sec-Fetch-Site: same-origin' \
    //  -H 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/146.0.0.0 YaBrowser/26.4.0.0 Safari/537.36' \
    //  -H 'sec-ch-ua: "Chromium";v="146", "Not-A.Brand";v="24", "YaBrowser";v="26.4", "Yowser";v="2.5"' \
    //  -H 'sec-ch-ua-mobile: ?0' \
    //  -H 'sec-ch-ua-platform: "Windows"'

    @Test
    public void totalAmountTest() {
        get("https://selenoid.autotests.cloud/status")
                .then()
                .body("total", is(5));

    }

    @Test
    public void totalAmountTest_withResponseLogs() {
        get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .body("total", is(5));
    }

    @Test
    public void totalAmountTest_withAllLogs() {
        given()
                .log().all()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .body("total", is(5));
    }

    @Test
    public void status200Test() {
        given()
                .log().all()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void chromeVersionTest() {
        given()
                .log().all()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .statusCode(200)
                .body("browsers.chrome", hasKey("127.0"));
                //.body("browsers.chrome", hasKey("129.0"));

    }
    @Test
    public void statusSchemaTest() {
        given()
                .log().all()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("sсhemas/status_response_schema.json"));


    }
    @Test
    public void bestTotalAmountTest() {
        given()
                .log().all()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("sсhemas/status_response_schema.json"))
                .body("total", is(5));
    }
    @Test
    @DisplayName("Проверка, что value содержит ключи message,ready")
    public void valueObjectContainsMessageAndReady() {
        given()
                .log().all()
                .auth().basic("user1", "1234")
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .body("value", hasKey("message"))
                .body("value", hasKey("ready"));
    }
    @Test
    @DisplayName("Проверка, что значение параметра ready = true")
    public void readyContentTrueTest() {
        given()
                .log().all()
                .auth().basic("user1", "1234")
                .when()
                .get("/wd/hub/status")
                .then()
                .log().body()
                .statusCode(200)
                .body("value.ready", is(true));
    }

    @Test
    @DisplayName("Проверка значения ключа message")
    public void messageContentRightTest() {
        given()
                .log().all()
                .auth().basic("user1", "1234")
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .body("value.message", is("Selenoid 1.11.3 built at 2024-05-25_12:34:40PM"));
    }
}