package teamCityProject.api.requests.unchecked;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import teamCityProject.api.requests.CrudInterface;
import teamCityProject.api.requests.Request;

import static io.restassured.RestAssured.given;

/**
 * This class for interaction with Build Configuration endpoint - negative scenarios.
 */
public class UncheckedBuildConfig extends Request implements CrudInterface {
    private static final String BUILD_CONFIG_ENDPOINT = "/app/rest/buildTypes";

    public UncheckedBuildConfig(RequestSpecification spec) {
        super(spec);
    }


    @Override
    public Response create(Object obj) {
        return given().spec(spec).body(obj)
                .post(BUILD_CONFIG_ENDPOINT);
    }

    @Override
    public Object get(String id) {
        return null;
    }

    @Override
    public Object update(Object obj) {
        return null;
    }

    @Override
    public Response delete(String id) {
        return given().spec(spec)
                .delete(BUILD_CONFIG_ENDPOINT+"/id:"+id);

    }
}
