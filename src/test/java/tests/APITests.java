package tests;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class APITests {

    @Test
    public void verifyHTTPSStatusCode200() {
        given()
                .when().get("https://jsonplaceholder.typicode.com/posts")
                .then().assertThat().statusCode(200);
    }
}
