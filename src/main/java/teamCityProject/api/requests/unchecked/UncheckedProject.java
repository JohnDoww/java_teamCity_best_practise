package teamCityProject.api.requests.unchecked;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification ;
import lombok.Getter;
import teamCityProject.api.requests.CrudInterface;
import teamCityProject.api.requests.Request;

import static io.restassured.RestAssured.given;

/**
 * This class for interaction with Project endpoint - negative scenarios.
 */
@Getter
public class UncheckedProject extends Request implements CrudInterface {
    private static final String PROJECT_ENDPOINT = "/app/rest/projects";

    public UncheckedProject(RequestSpecification spec) {
        super(spec);
    }



    @Override
    public Response create(Object obj) {
        return given()
                .spec(spec)
                .body(obj)
                .post(PROJECT_ENDPOINT);
    }

    @Override
    public Response get(String id) {
        return given()
                .spec(spec)
                .get(PROJECT_ENDPOINT+"/id:"+id);
    }

    @Override
    public Object update(Object obj) {
        return null;
    }

    @Override
    public Response delete(String id) {
        return given()
                .spec(spec)
                .delete(PROJECT_ENDPOINT+"/id:"+id);
    }
}
