package TestScenarios;

import Api.HealthcheckApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;


public class TestMonitoring {

    final String baseURI = "http://localhost:3030";
    Response response;

    @Before
    public void setUp() {
        RestAssured.baseURI = baseURI;
    }

    @Test
    public void testApplicationHealthStatus() {
        response = HealthcheckApi.getStatus();
        response.then()
                .statusCode(200);
    }
}
