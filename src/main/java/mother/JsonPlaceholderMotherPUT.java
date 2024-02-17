package mother;

import model.JsonPlaceholderModelPUT;
import model.request.JsonPlaceholderRequestModelPOST;

public class JsonPlaceholderMotherPUT {
    public static JsonPlaceholderModelPUT createBodyForJsonPlaceholderPut(){
        return JsonPlaceholderModelPUT.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
}
