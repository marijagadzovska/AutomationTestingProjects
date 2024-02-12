package jsonplaceholdertest;

import clients.JsonPlaceholderClient;
import datafactory.JsonPlaceholderDataFactory;
import io.restassured.response.Response;
import model.request.JsonPlaceholderRequestModelPOST;
import model.response.JsonPlaceholderResponseModelPOST;
import org.junit.Test;

import static mother.JsonPlaceholderMother.createBodyForJsonPlaceholderPost;
import static org.junit.Assert.assertEquals;

public class JsonPlaceholderTests {

    @Test
    public void JsonPlaceholderRequestDefaultValues() {
        JsonPlaceholderRequestModelPOST requestBody = new JsonPlaceholderDataFactory(createBodyForJsonPlaceholderPost())
                .createRequest();

        Response postResponse = new JsonPlaceholderClient()
                .postNewsPost(requestBody);

        JsonPlaceholderResponseModelPOST jsonplaceholderResponse = postResponse.body().as(JsonPlaceholderResponseModelPOST.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Default title", jsonplaceholderResponse.getTitle());
        assertEquals("Default body", jsonplaceholderResponse.getBody());
    }


    @Test
    public void JsonPlaceholderRequestMaximumCharactersForFields() {
        JsonPlaceholderRequestModelPOST requestBody = new JsonPlaceholderDataFactory(createBodyForJsonPlaceholderPost())
                .setTitle("aaaaaaaaaa")
                .setBody("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .createRequest();

        Response postResponse = new JsonPlaceholderClient()
                .postNewsPost(requestBody);

        JsonPlaceholderResponseModelPOST jsonplaceholderResponse = postResponse.body().as(JsonPlaceholderResponseModelPOST.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("aaaaaaaaaa", jsonplaceholderResponse.getTitle());
        assertEquals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", jsonplaceholderResponse.getBody());
    }

    @Test
    public void JsonPlaceholderRequestMoreThenMaximumCharactersForFields() {
        JsonPlaceholderRequestModelPOST requestBody = new JsonPlaceholderDataFactory(createBodyForJsonPlaceholderPost())
                .setTitle("aaaaaaaaaa")
                .setBody("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .createRequest();

        Response postResponse = new JsonPlaceholderClient()
                .postNewsPost(requestBody);

        assertEquals(201, postResponse.statusCode());

    }









}
