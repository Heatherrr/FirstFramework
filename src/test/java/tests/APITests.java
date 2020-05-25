package tests;

import Helper.DataUser;
import com.gargoylesoftware.htmlunit.javascript.host.fetch.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.response.ValidatableResponse.*;

public class APITests {

    //статическая переменная (default url)
    static String DEFAULT_URL = "https://jsonplaceholder.typicode.com/posts";
    static String CONTENT_TYPE = "Content-type";
    static String HEADER_APP_JSON = "application/json; charset=utf-8";
    Response response;
    SoftAssert softAssert = new SoftAssert();
    DataUser getUser1 = new DataUser("1", "foo", "poo");

    @Test
    public void verifyHTTPSStatusCode200() {
        given()
                .when().get("https://jsonplaceholder.typicode.com/posts")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void verifyHTTPResponseHeader() {
        given() RequestSpecification
            .when().get(DEFAULT_URL) Response
            .then().assertThat() ValidatableResponse
            .header(CONTENT_TYPE, HEADER_APP_JSON) ValidatableResponse
            .and().statusCode(300);
    }

    @Test
    public void verifyHTTPResponseBody() {
        response = (Response) given()
                .when().get (DEFAULT_URL);
        softAssert.assertEquals(response.body()
                .jsonPath().getList("id").size(), 101);
        softAssert.assertAll();
    }

    @Test
    public void createNewPost () {
        response = given ()
                .header((CONTENT_TYPE, HEADER_APP_JSON)
                .body(getUser1)
                .when ().post(DEFAULT_URL);
        softAssert.assertEquals(response.statusCode(), 201);
                softAssert.assertNotNull(response.body());
                softAssert.assertAll();
                System.out.println("id: " + response.body()
                .jsonPath().getInt("id"));
    }

    @Test
    public void updatePost() {
        response = given()
                .header (CONTENT_TYPE, HEADER_APP_JSON)
                .body(getUser1)
                .when().put(DEFAULT_URL/1);
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(response.getBody()
                .jsonPath().getInt("id"), 1);
        softAssert.assertEquals(response.getBody()
                .jsonPath().getString("title"), "foo");
        softAssert.assertAll();
        response.body().print();
    }

    @Test
    public void deletePost (){
        response = given()
                .header(CONTENT_TYPE, HEADER_APP_JSON)
                .when().delete()(DEFAULT_URL + "1");
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertAll();
        response.body().print();
    }
}
