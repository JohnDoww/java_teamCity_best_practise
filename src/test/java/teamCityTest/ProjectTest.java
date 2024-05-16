package teamCityTest;

import teamCityProject.api.models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import teamCityProject.api.requests.unchecked.UniversalUnchecked;
import teamCityProject.api.spec.Specifications;

public class ProjectTest extends BaseApiTest {
    @Test
    public void createProject() {
        var testData = testDataStorage.addTestData();

        var createdProject = checkedWithSuperUser.getProjectRequest()
                .create(testData.getProject());

        softAssert.assertThat(createdProject.getId()).isEqualTo(testData.getProject().getId());
    }

    @Test
    public void noPossibleToCreateSameProjects() {
        var testData = testDataStorage.addTestData();
        checkedWithSuperUser.getProjectRequest()
                .create(testData.getProject());

        new UniversalUnchecked(Specifications.getSpec().superUserSpec(), Project.class, "Project")
                .create(testData.getProject())
                .then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}