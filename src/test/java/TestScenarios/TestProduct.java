package TestScenarios;

import Api.ProductApi;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;


public class TestProduct {

    final String baseURI = "http://localhost:3030";
    Response response;

    @Before
    public void setUp() {
        RestAssured.baseURI = baseURI;
    }

    @Test
    public void testGetProducts() {
        response = ProductApi.getProducts();
        response.then()
                .statusCode(200)
                .body("limit",equalTo(10));
    }

    @Test
    public void testCreateAndFetchProduct() {
        testCreateNewProduct();
        JsonPath jsonPathEvaluator = response.jsonPath();

        long productId = Long.valueOf(jsonPathEvaluator.get("id").toString());
        System.out.println("productId = " + productId);

        response = ProductApi.getSpecificProduct(productId);
        response.then()
                .statusCode(200);
    }

    @Test
    public void testCreateAndDeleteProduct() {
        testCreateNewProduct();
        JsonPath jsonPathEvaluator = response.jsonPath();

        long productId = Long.valueOf(jsonPathEvaluator.get("id").toString());
        System.out.println("productId = " + productId);

        response = ProductApi.deleteSpecificProduct(productId);
        response.then()
                .statusCode(200);

        response = ProductApi.getSpecificProduct(productId);
        response.then()
                .statusCode(404);
    }

    @Test
    public void testCreateNewProduct() {
        response = ProductApi.createProduct();
        response.then()
                .statusCode(201)
                .body("id",notNullValue());
    }

    @Test
    public void testUpdateProduct() {
        response = ProductApi.createProduct();
        response.then()
                .statusCode(201)
                .body("id",notNullValue());

        JsonPath jsonPathEvaluator = response.jsonPath();

        long productId = Long.valueOf(jsonPathEvaluator.get("id").toString());
        String productName = jsonPathEvaluator.get("name");

        System.out.println("productId = " + productId);
        System.out.println("productName = " + productName);

        response = ProductApi.updateProduct(productId, productName);
        response.then()
                .statusCode(200)
                .body("name",is(productName));
    }

    @Test
    public void testGetProductsWithLimit() {
        int limit = 5;
        response =  ProductApi.getProducts(limit,true);
        response.then().statusCode(200);
        response.then().body("limit",equalTo(limit));
    }

    @Test
    public void testGetProductsWithSkip() {
        int skipCount = 500;
        response =  ProductApi.getProducts(skipCount,false);
        response.then().statusCode(200);
        response.then().body("skip",equalTo(skipCount));
    }

    @Test
    public void testGetProductsWithLimitAndSkip() {
        int limit =5;
        int skipCount = 10;

        response =  ProductApi.getProducts(limit,skipCount);
        response.then().statusCode(200);
        response.then().body("limit",equalTo(limit));
        response.then().body("skip",equalTo(skipCount));
    }

}

