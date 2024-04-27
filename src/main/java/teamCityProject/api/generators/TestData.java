package teamCityProject.api.generators;

import io.restassured.specification.RequestSpecification;
import lombok.Builder;
import lombok.Data;
import teamCityProject.api.models.BuildType;
import teamCityProject.api.models.NewProjectDescription;
import teamCityProject.api.models.User;
import teamCityProject.api.requests.unchecked.UncheckedProject;
import teamCityProject.api.requests.unchecked.UncheckedUser;
import teamCityProject.api.spec.Specifications;

@Builder
@Data
public class TestData {
    private User user;
    private NewProjectDescription project;
    private BuildType buildType;

    public void delete() {
        var spec = Specifications.getSpec().authSpec(user);
        new UncheckedProject( spec).delete(project.getId());
        new UncheckedUser(spec).delete(user.getUsername());
    }
}