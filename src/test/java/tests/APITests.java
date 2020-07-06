package tests;

import Helper.DataUser;                                                        //импорт класса DataUser
import com.jayway.restassured.response.Response;                               //restassured - библиотека Java, работающая с http запросами, позволяет выполнить запрос к API и проверить полученный результат
import org.junit.Test;                                                         //junit - библиотека для юнит-тестирования кода
import org.testng.asserts.SoftAssert;                                          //testng - для возможности передавть параметры в тест (параметризировать удобнее, чем в junit)

import static com.jayway.restassured.RestAssured.given;                        //с помощью гивена мы создаем спецификацию для реквеста, через given/then строится наш запрос

public class APITests {                                                        //класс APITests

    //статическая переменная (default url)
    static String DEFAULT_URL = "https://jsonplaceholder.typicode.com/posts";  //URL запрос
    static String CONTENT_TYPE = "Content-type";                               //html, css, js, контент
    static String HEADER_APP_JSON = "application/json; charset=utf-8";         //формат json, чтобы распознавал англ и рус
    Response response;                                                         //объект респонса, а респонс - это целый объект, который включает методы запроса get, post, итд
    SoftAssert softAssert = new SoftAssert();                                  //конструктор, чтобы потом использовать наши ассерты (проверки)
    DataUser getUser1 = new DataUser("1", "foo", "poo");    // объект/экземпляр класса DataUser со значениями, ключ для аутентификации юзера

    @Test                                                                     //аннотация Test
    public void verifyHTTPSStatusCode200() {                                  //метод теста для проверки что сайт отвечает по данному URL        Ключевые слова given, when и then формируют запрос:
        given()                                                               //given() - определяет что будет отправлено в запросе (авторизация и параметры запроса)
                .when().get("https://jsonplaceholder.typicode.com/posts")  //when() - с каким методом и на какой эндпоинт (URL) отправляем запрос (описывает требуемое действие – запрос какого типа и на какой адрес следует отправить.)
                .then().assertThat().statusCode(200);                         //then() - как проверяется пришедший ответ. Проверяем соответствует ли статус код ответа сервера ожидаемому (200). Включает проверки, которые необходимо произвести (их может быть несколько одновременно).
    }

    @Test                                                                     //
    public void verifyHTTPResponseHeader() {                                  //проверяем тип возвращаемого хедера, что сайт возвращает определенный тип в котором он парсится, что он парсится в json, а второй проверко, что он доступен
        given()                                                               //
            .when().get(DEFAULT_URL)
            .then().assertThat()
            .header(CONTENT_TYPE, HEADER_APP_JSON)
            .and().statusCode(200);                                           //
    }

    @Test                                                                     //обознач создаваемый метод как тест, чтобы потом можно было его запускать
    public void verifyHTTPResponseBody() {                                    //метод   get запрос, а потом получаем бади юзеров в json -е,
        response = (Response) given()
                .when().get (DEFAULT_URL);
        softAssert.assertEquals(response.body()
                .jsonPath().getList("id").size(), 100);
        softAssert.assertAll();
    }

    @Test
    public void createNewPost () {
        response = given ()
                .header(CONTENT_TYPE, HEADER_APP_JSON)
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
                .when().put(DEFAULT_URL + "/1");
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
                .when().delete(DEFAULT_URL + "/1");
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertAll();
        response.body().print();
    }
}
