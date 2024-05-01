package teamCityProject.api.requests.checked;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import io.restassured.specification.RequestSpecification ;

public class AuthRequest {
    private final RequestSpecification spec;
    public AuthRequest(RequestSpecification user){
        this.spec = user;
    }

    public String getCsrfToken(){
        return RestAssured
                .given()
                .spec(spec)
                .get("/authenticationTest.html?csrf")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();
    }
}
