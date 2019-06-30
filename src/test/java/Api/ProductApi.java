package Api;

import Template.Product;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductApi {

    final static String products = "/products";

    public static Response getProducts()
    {
        return given()
                .contentType("application/json")
                .log().all()
                .when()
                .get(products);
    }

    public static Response getSpecificProduct(long productId)
    {
        return given()
                .contentType("application/json")
                .log().all()
                .when()
                .get(products+"/"+productId);
    }

    public static Response deleteSpecificProduct(long productId)
    {
        return given()
                .contentType("application/json")
                .log().all()
                .when()
                .delete(products+"/"+productId);
    }
    public static Response getProducts(int limitOrSkip, boolean isLimit)
    {
        String param = "$limit";
        if(!isLimit)
            param = "$skip";
        return given()
                .formParam(param,limitOrSkip)
                .contentType("application/json")
                .log().all()
                .when()
                .get(products);
    }

    public static Response getProducts(int limit, int skip)
    {
        return given()
                .contentType("application/json")
                .formParam("$limit",limit)
                .formParam("$skip",skip)
                .log().all()
                .when()
                .get(String.format(products));
    }

    public static Response createProduct()
    {
        return given()
                .contentType("application/json")
                .body(new Product().getBasicProductAsJson())
                .log().all()
                .when()
                .post(String.format(products));
    }

    public static Response updateProduct(long productId, String productName)
    {
        return given()
                .contentType("application/json")
                .body(new Product().getProductWithNameAsJson(productName))
                .log().all()
                .when()
                .patch(String.format(products + "/" + productId));
    }


}

