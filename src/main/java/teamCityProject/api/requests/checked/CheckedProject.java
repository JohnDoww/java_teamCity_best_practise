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

//    public <T> T universalMethodCreate (Class <?> clas ){
//        if(clas.equals(NewProjectDescription.class)){
//            return  new UncheckedProject(spec).create(clas)
//                    .then().assertThat().statusCode(HttpStatus.SC_OK)
//                    .extract().as((Class<T>) Project.class);
//        } else if (clas == User.class) {
//            return (T) new UncheckedUser(spec)
//                    .create(clas)
//                    .then().assertThat().statusCode(HttpStatus.SC_OK)
//                    .extract().as(User.class);
//        } else {
//            System.out.println("doesn't work");
//            return null;
//        }
//    }

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
