package teamCityProject.api.requests.checked;

import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import teamCityProject.api.models.User;
import teamCityProject.api.requests.CrudInterface;
import teamCityProject.api.requests.Request;
import teamCityProject.api.requests.unchecked.UncheckedUser;


/**
 * This class for interaction with User endpoint - positive scenarios.
 */
public class CheckedUser extends Request implements CrudInterface {


    public CheckedUser(RequestSpecification spec) {
        super(spec);
    }

    @Override
    public User create(Object obj) {
        return new UncheckedUser(spec)
                .create(obj)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(User.class);
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
    public Object delete(String id) {
        return null;
    }
}

