package praktikum.user;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.ValidatableResponse;
import praktikum.configuration.RequestSpec;
import praktikum.pages.Environment;

import java.util.Map;

public class UserClient extends RequestSpec {

    public ValidatableResponse create(User user) {
        return requestSpec()
                .body(user)
                .when()
                .post(Environment.USER_CREATE)
                .then().log().all();
    }

     public static ValidatableResponse delete(String accessToken) {
        return requestSpec()
                .headers(Map.of("Authorization", accessToken))
                .when()
                .delete(Environment.USER_DELETE)
                .then().log().all();
    }


}