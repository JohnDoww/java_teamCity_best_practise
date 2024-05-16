package teamCityProject.api.requests.unchecked;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import teamCityProject.api.requests.Request;

import static io.restassured.RestAssured.given;

/**
 * There universal method for all unchecked requests
 */
public class UniversalUnchecked extends Request {
    private Class type;
    String endpoint;
    private final String PROJECT_ENDPOINT = "/app/rest/projects";
    private static final String USER_ENDPOINT = "/app/rest/users";
    private static final String BUILD_CONFIG_ENDPOINT = "/app/rest/buildTypes";

    public UniversalUnchecked(RequestSpecification spec, Class type, String endpoint) {
        super(spec);
        this.type = type;

        switch (endpoint) {
            case "BuildType":
                this.endpoint = BUILD_CONFIG_ENDPOINT;
                break;
            case "Project":
                this.endpoint = PROJECT_ENDPOINT;
                break;
            case "User":
                this.endpoint = USER_ENDPOINT;
                break;
        }
    }

    public Response create(Object obj) {
        return given()
                .spec(spec)
                .body(obj)
                .post(endpoint);
    }

    public Response get(String id) {
        return given()
                .spec(spec)
                .get(endpoint + "/id:" + id);
    }


}
