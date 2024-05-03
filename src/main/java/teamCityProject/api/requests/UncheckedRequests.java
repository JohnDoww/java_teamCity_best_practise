package teamCityProject.api.requests;

import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import teamCityProject.api.requests.unchecked.UncheckedBuildConfig;
import teamCityProject.api.requests.unchecked.UncheckedProject;
import teamCityProject.api.requests.unchecked.UncheckedUser;

/**
 * This class for managing classes and method related to negative scenarios.
 */
@Getter
public class UncheckedRequests {


    private UncheckedUser userRequest;
    private UncheckedProject projectRequest;
    private UncheckedBuildConfig buildConfigRequest;
    public UncheckedRequests(RequestSpecification spec){
        this.userRequest = new UncheckedUser(spec);
        this.projectRequest = new UncheckedProject(spec);
        this.buildConfigRequest = new UncheckedBuildConfig(spec);
    }
}
