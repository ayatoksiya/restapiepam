package org.example.petstore;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class CommonService {
    private static final String BASE_URI = "https://petstore.swagger.io/v2/";

    protected RequestSpecification requestSpecification;

    public CommonService() {
        this.requestSpecification = RestAssured.with().header("api_key", "apikey123!");

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        this.requestSpecification.headers(headers);
    }

    protected Response getRequest(int id, String mode) {
        String uri = BASE_URI + "pet/" + id;
        Response response;
        if ( mode == "deleted") {
            response = requestSpecification.expect().statusCode(HttpStatus.SC_NOT_FOUND).when().get(uri);
        }
        else {
            response = requestSpecification.get(uri);
        }

        return response;
    }

    protected Response postRequest(String uri, Object body) {
        uri = BASE_URI + uri;
        return this.requestSpecification.body(body).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().post(uri);
    }

    protected Response putRequest(String uri, Object body) {
        uri = BASE_URI + uri;
        return this.requestSpecification.body(body).expect().statusCode(HttpStatus.SC_CREATED).log().ifError()
                .when().put(uri);
    }

    protected void deleteRequest(int id) {
        String uri = BASE_URI + "pet/" + id;
        this.requestSpecification.expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().delete(uri);
    }
}
