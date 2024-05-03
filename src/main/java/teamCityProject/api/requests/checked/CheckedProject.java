package teamCityProject.api.requests.checked;

import org.apache.http.HttpStatus;
import teamCityProject.api.models.Project;
import io.restassured.specification.RequestSpecification;
import teamCityProject.api.requests.CrudInterface;
import teamCityProject.api.requests.Request;
import teamCityProject.api.requests.unchecked.UncheckedProject;


/**
 * This class for interaction with Project endpoint - positive scenarios.
 */
public class CheckedProject extends Request implements CrudInterface {


    public CheckedProject(RequestSpecification spec) {
        super(spec);
    }

    @Override
    public Project create(Object obj) {
        return new UncheckedProject(spec).create(obj)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(Project.class);
    }

    @Override
    public Project get(String id) {
        return new UncheckedProject(spec)
                .get(id)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(Project.class);

    }

    @Override
    public Object update(Object obj) {
        return null;
    }

    @Override
    public String delete(String id) {
        return new UncheckedProject(spec)
                .delete(id)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();
    }
}
