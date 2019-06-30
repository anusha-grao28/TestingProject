package Api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HealthcheckApi {

    final static String healthcheck = "/healthcheck";

    public static Response getStatus()
    {
        return given()
                .log().all()
                .when()
                .get(healthcheck);
    }
}
