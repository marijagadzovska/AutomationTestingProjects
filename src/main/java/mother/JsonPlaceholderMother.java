package mother;

import model.request.JsonPlaceholderRequestModelPOST;

public class JsonPlaceholderMother {

    public static JsonPlaceholderRequestModelPOST createBodyForJsonPlaceholderPost(){
        return JsonPlaceholderRequestModelPOST.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
}
