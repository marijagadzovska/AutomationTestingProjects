package jsonplaceholdertest;

import clients.JsonPlaceholderClient;
import datafactory.JsonPlaceholderDataFactoryPOST;
import datafactory.JsonPlaceholderDataFactoryPUT;
import io.restassured.response.Response;
import model.JsonPlaceholderModelPUT;
import model.request.JsonPlaceholderRequestModelPOST;
import model.response.JsonPlaceholderResponseModelGETAll;
import model.response.JsonPlaceholderResponseModelPOST;
import org.junit.Test;

import java.util.List;

import static mother.JsonPlaceholderMother.createBodyForJsonPlaceholderPost;
import static mother.JsonPlaceholderMotherPUT.createBodyForJsonPlaceholderPut;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JsonPlaceholderTests {

    String title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
    String body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto";

    @Test
    public void JsonPlaceholderRequestDefaultValues() {
        JsonPlaceholderRequestModelPOST requestBody = new JsonPlaceholderDataFactoryPOST(createBodyForJsonPlaceholderPost())
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
        JsonPlaceholderRequestModelPOST requestBody = new JsonPlaceholderDataFactoryPOST(createBodyForJsonPlaceholderPost())
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
        JsonPlaceholderRequestModelPOST requestBody = new JsonPlaceholderDataFactoryPOST(createBodyForJsonPlaceholderPost())
                .setTitle("aaaaaaaaaa")
                .setBody("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .createRequest();

        Response postResponse = new JsonPlaceholderClient()
                .postNewsPost(requestBody);

        assertEquals(201, postResponse.statusCode());
    }

    @Test
    public void JsonPlaceholderRequest() {
        JsonPlaceholderRequestModelPOST requestBody = new JsonPlaceholderDataFactoryPOST(createBodyForJsonPlaceholderPost())
                .setTitle("Makedonija osvoi svetso prvenstvo vo fudbal")
                .setBody("Noviot svetski prvak Maedonija go osvoi svetsoto prvenstvo vo fudbal odrzano vo Madrid")
                .createRequest();

        Response postResponse = new JsonPlaceholderClient()
                .postNewsPost(requestBody);

        JsonPlaceholderResponseModelPOST jsonplaceholderResponse = postResponse.body().as(JsonPlaceholderResponseModelPOST.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Makedonija osvoi svetso prvenstvo vo fudbal", jsonplaceholderResponse.getTitle());
        assertEquals("Noviot svetski prvak Maedonija go osvoi svetsoto prvenstvo vo fudbal odrzano vo Madrid", jsonplaceholderResponse.getBody());

    }

    @Test
    public void getAllPosts(){
        Response getResponse = new JsonPlaceholderClient()
                .getAllPosts();

        List<JsonPlaceholderResponseModelGETAll> employeeResponse = getResponse
                .body()
                .jsonPath()
                .getList("",JsonPlaceholderResponseModelGETAll.class);


//        List<JsonPlaceholderResponseModelGETAll> jsonplaceholderResponse;
//        jsonplaceholderResponse = getResponse
//                .body()
//                .as(new TypeRef<List<JsonPlaceholderResponseModelGETAll>>() {});

        assertEquals(200,getResponse.statusCode());
        assertFalse(employeeResponse.isEmpty());

    }

    @Test
    public void getPostById(){
        Response getResponse = new JsonPlaceholderClient()
                .getPost("1");

        JsonPlaceholderResponseModelGETAll postResponse = getResponse.body().as(JsonPlaceholderResponseModelGETAll.class);

        assertEquals(200,getResponse.statusCode());
        assertEquals(title,postResponse.getTitle());
        assertEquals(body, postResponse.getBody());
    }

     @Test
     public void updatePostTest() {
         JsonPlaceholderModelPUT requestBody = new JsonPlaceholderDataFactoryPUT(createBodyForJsonPlaceholderPut())
                 .setTitle("sunt aut facere repellat provident occaecati excepturi")
                 .setBody("sunt aut facere repellat provident occaecati excepturi optio")
                 .createRequest();

         Response putResponse = new JsonPlaceholderClient()
                 .updatePost(requestBody, "1");

         JsonPlaceholderModelPUT updateResponse = putResponse.body().as(JsonPlaceholderModelPUT.class);

         assertEquals(200, putResponse.statusCode());
         assertEquals("sunt aut facere repellat provident occaecati excepturi", updateResponse.getTitle());
         assertEquals("sunt aut facere repellat provident occaecati excepturi optio", updateResponse.getBody());
     }

     @Test
    public void deletePostTest(){
         Response deleteResponse = new JsonPlaceholderClient()
                 .deletePost("1");

         assertEquals(200,deleteResponse.statusCode());

     }

   }














