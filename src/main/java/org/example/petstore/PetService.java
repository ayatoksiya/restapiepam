package org.example.petstore;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class PetService extends CommonService {

    private static PetService instance;

    public static PetService getInstance() {
        if (instance == null) {
            instance = new PetService();
        }
        return instance;
    }
    public Response getRequest(int id, String mode) {
        return super.getRequest(id, mode);
    }
    public Response postRequest(String uri, Object body) {
        return super.postRequest(uri, body);
    }

    public Response putRequest(String uri, Object body) {
        return super.putRequest(uri, body);
    }

    public void deleteRequest(int uri) {
        super.deleteRequest(uri);
    }

}
