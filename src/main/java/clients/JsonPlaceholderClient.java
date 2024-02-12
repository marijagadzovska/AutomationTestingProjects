package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.request.JsonPlaceholderRequestModelPOST;
import util.Configuration;

public class JsonPlaceholderClient {
    public Response postNewsPost(JsonPlaceholderRequestModelPOST request){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(Configuration.JSON_PLACEHOLDER_POST_ROUTE)
                .thenReturn();
    }

}
