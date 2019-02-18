import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class Test1_BasicFeatures {

//    simply checking status code:
    public void testStatusCode() {
        given()
                .get("https://reqres.in/api/users/1")
                .then()
                .statusCode(200);
    }

//    it will verify code and print complete response in console:
    public void testLogging(){
        given()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200)
                .log().all();
    }

//    verifying single content using Matchers library
    public void testEqualToFunction(){
        given()
                .get("https://reqres.in/api/users/3")
                .then()
                .body("data.first_name", equalTo("Emma")); //expected value is "Emma"
    }

//    verifying single content using Matchers library
    public void testHasItemFunction(){
        given()
                .get("https://reqres.in/api/users")
                .then()
                .body("data.last_name", hasItems("Bluth", "Weaver", "Wong"));
    }
    
}

