package teamCityProject.api.requests;

import io.restassured.specification.RequestSpecification;

/**
 * This class for initialization Request Specification and reuse the specification for each test class.
 */
public class Request {
    protected  RequestSpecification spec;
    public Request (RequestSpecification spec){
        this.spec = spec;
    }
}
