package praktikum.configuration;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import praktikum.pages.Environment;

import static io.restassured.RestAssured.given;
public class RequestSpec {
    public static RequestSpecification requestSpec() {
        return  given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(Environment.BASE_URL);
    }
}
