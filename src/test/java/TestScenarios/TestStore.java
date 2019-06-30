package TestScenarios;

import Api.StoreApi;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TestStore {

    final String baseURI = "http://localhost:3030";
    Response response;

    @Before
    public void setUp() {
        RestAssured.config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));
        RestAssured.baseURI = baseURI;
    }

    @Test
    public void testGetStores() {
        response = StoreApi.getStores();
        response.then()
                .statusCode(200)
                .body("limit",equalTo(10));
    }

    @Test
    public void testCreateAndFetchStore() {
        testCreateNewStore();
        JsonPath jsonPathEvaluator = response.jsonPath();

        long StoreId = Long.valueOf(jsonPathEvaluator.get("id").toString());
        System.out.println("StoreId = " + StoreId);

        response = StoreApi.getSpecificStore(StoreId);
        response.then()
                .statusCode(200);
    }

    @Test
    public void testCreateAndDeleteStore() {
        testCreateNewStore();
        JsonPath jsonPathEvaluator = response.jsonPath();

        long StoreId = Long.valueOf(jsonPathEvaluator.get("id").toString());
        System.out.println("StoreId = " + StoreId);

        response = StoreApi.deleteSpecificStore(StoreId);
        response.then()
                .statusCode(200);

        response = StoreApi.getSpecificStore(StoreId);
        response.then()
                .statusCode(404);
    }

    @Test
    public void testCreateNewStore() {
        response = StoreApi.createStore();
        response.then()
                .statusCode(201)
                .body("id",notNullValue());
    }

    @Test
    public void testUpdateStore() {
        response = StoreApi.createStore();
        response.then()
                .statusCode(201)
                .body("id",notNullValue());

        JsonPath jsonPathEvaluator = response.jsonPath();

        long StoreId = Long.valueOf(jsonPathEvaluator.get("id").toString());
        String StoreName = jsonPathEvaluator.get("name");

        System.out.println("StoreId = " + StoreId);
        System.out.println("StoreName = " + StoreName);

        response = StoreApi.updateStore(StoreId, StoreName);
        response.then()
                .statusCode(200)
                .body("name",is(StoreName));
    }

    @Test
    public void testGetStoresWithLimit() {
        int limit = 5;
        response =  StoreApi.getStores(limit,true);
        response.then().statusCode(200);
        response.then().body("limit",equalTo(limit));
    }

    @Test
    public void testGetStoresWithSkip() {
        int skipCount = 500;
        response =  StoreApi.getStores(skipCount,false);
        response.then().statusCode(200);
        response.then().body("skip",equalTo(skipCount));
    }

    @Test
    public void testGetStoresWithLimitAndSkip() {
        int limit =5;
        int skipCount = 10;

        response =  StoreApi.getStores(limit,skipCount);
        response.then().statusCode(200);
        response.then().body("limit",equalTo(limit));
        response.then().body("skip",equalTo(skipCount));
    }
}
