package teamCityProject.api.requests;

import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import teamCityProject.api.requests.checked.CheckedBuildConfig;
import teamCityProject.api.requests.checked.CheckedProject;
import teamCityProject.api.requests.checked.CheckedUser;

@Getter
public class CheckedRequests {

    private CheckedUser userRequest;
    private CheckedProject projectRequest;
    private CheckedBuildConfig buildConfigRequest;

    public CheckedRequests(RequestSpecification spec){
        this.userRequest = new CheckedUser(spec);
        this.projectRequest = new CheckedProject(spec);
        this.buildConfigRequest = new CheckedBuildConfig(spec);
    }
}
