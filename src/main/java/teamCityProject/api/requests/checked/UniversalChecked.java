package teamCityProject.api.requests.checked;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import teamCityProject.api.requests.Request;
import teamCityProject.api.requests.unchecked.UncheckedUser;

import static io.restassured.RestAssured.given;

// do not understand how to implement there universal method
//public class UniversalChecked extends Request {
//     Class checkedType;
//    String endpoint;
//
//
//    public UniversalChecked(RequestSpecification spec, Class checkedType, String endpoint) {
//        super(spec);
//        this.checkedType = checkedType;
//    }
//
//    public Response create(Object obj) {
//        return  new UncheckedUser(this.spec,  checkedType  , endpoint)
//                .create(obj)
//                .then().assertThat().statusCode(HttpStatus.SC_OK)
//                .extract().as(checkedType);
//    }
//
//    public Response get(String id) {
//        return given()
//                .spec(spec)
//                .get(endpoint + "/id:" + id);
//    }
//}
