package datafactory;

import model.JsonPlaceholderModelPUT;
import model.request.JsonPlaceholderRequestModelPOST;

public class JsonPlaceholderDataFactoryPUT {

        private JsonPlaceholderModelPUT request;

        public JsonPlaceholderDataFactoryPUT(JsonPlaceholderModelPUT requestBody) {
            request = requestBody;
        }

        public JsonPlaceholderDataFactoryPUT setTitle(String value) {
            request.setTitle(value);
            return this;
        }

        public JsonPlaceholderDataFactoryPUT setBody(String value) {
            request.setBody(value);
            return this;
        }

        public JsonPlaceholderModelPUT createRequest() {
            return request;
        }
    }

