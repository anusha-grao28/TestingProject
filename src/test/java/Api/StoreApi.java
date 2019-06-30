package Api;

import Template.Store;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreApi {

    final static String stores = "/stores";

    public static Response getStores()
    {
        return given()
                .contentType("application/json")
                .log().all()
                .when()
                .get(stores);
    }

    public static Response getSpecificStore(long storeID)
    {
        return given()
                .contentType("application/json")
                .log().all()
                .when()
                .get(stores+"/"+storeID);
    }

    public static Response deleteSpecificStore(long storeID)
    {
        return given()
                .contentType("application/json")
                .log().all()
                .when()
                .delete(stores+"/"+storeID);
    }
    public static Response getStores(int limitOrSkip, boolean isLimit)
    {
        String param = "$limit";
        if(!isLimit)
            param = "$skip";
        return given()
                .contentType("application/json")
                .formParam(param,limitOrSkip)
                .log().uri()
                .when()
                .get(String.format(stores));
    }

    public static Response getStores(int limit, int skip)
    {
        return given()
                .contentType("application/json")
                .formParam("$limit",limit)
                .formParam("$skip",skip)
                .log().uri()
                .when()
                .get(String.format(stores));
    }

    public static Response createStore()
    {
        return given()
                .contentType("application/json")
                .body(new Store().getBasicStoreAsJson())
                .log().all()
                .when()
                .post(String.format(stores));
    }

    public static Response updateStore(long storeId, String storeName)
    {
        return given()
                .contentType("application/json")
                .body(new Store().getStoreWithNameAsJson(storeName))
                .log().all()
                .when()
                .patch(String.format(stores + "/" + storeId));
    }
}

