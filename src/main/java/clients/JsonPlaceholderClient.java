package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.JsonPlaceholderModelPUT;
import model.request.JsonPlaceholderRequestModelPOST;
import util.Configuration;

public class JsonPlaceholderClient {
    public Response postNewsPost(JsonPlaceholderRequestModelPOST request){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(Configuration.JSON_PLACEHOLDER_BASE_URL)
                .thenReturn();
    }
    public Response getAllPosts(){
        return RestAssured.given()
                .when().log().all()
                .get(Configuration.JSON_PLACEHOLDER_BASE_URL)
                .thenReturn();
    }

    public Response getPost(String id){
        return RestAssured.given()
                .when().log().all()
                .get(Configuration.JSON_PLACEHOLDER_BASE_URL + "/" + id)
                .thenReturn();
    }
    public Response updatePost(JsonPlaceholderModelPUT request, String id){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .put(Configuration.JSON_PLACEHOLDER_BASE_URL + "/" + id)
                .thenReturn();
    }

    public Response deletePost(String id){
        return RestAssured.given()
                .when().log().all()
                .delete(Configuration.JSON_PLACEHOLDER_BASE_URL + "/" + id)
                .thenReturn();
    }




}
