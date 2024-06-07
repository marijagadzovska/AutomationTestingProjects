package mother;

import model.response.JsonPlaceholderModelPUT;

public class JsonPlaceholderMotherPUT {

    public static JsonPlaceholderModelPUT createBodyForJsonPlaceholderPut(){
        return JsonPlaceholderModelPUT.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
}
