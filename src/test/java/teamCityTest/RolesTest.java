package teamCityTest;

import teamCityProject.api.enums.Role;
import teamCityProject.api.generators.TestDataGenerator;
import teamCityProject.api.models.BuildType;
import teamCityProject.api.requests.UncheckedRequests;
import teamCityProject.api.requests.checked.CheckedBuildConfig;
import teamCityProject.api.requests.checked.CheckedProject;
import teamCityProject.api.requests.unchecked.UncheckedBuildConfig;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import teamCityProject.api.requests.unchecked.UncheckedProject;
import teamCityProject.api.requests.unchecked.UniversalUnchecked;
import teamCityProject.api.spec.Specifications;

import static teamCityProject.api.generators.TestDataGenerator.generateRoles;

/**
 * User Roles tests
 */
public class RolesTest extends BaseApiTest {

    @Test
    public void unauthorizedUserShouldNotHaveRightToCreateProject() {
        var testData = testDataStorage.addTestData();

        new UniversalUnchecked(Specifications.getSpec().unauthSpec(), UncheckedProject.class, "Project")
                .create(testData.getProject())
                .then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);

        new UniversalUnchecked(Specifications.getSpec().superUserSpec(), UncheckedProject.class, "Project")
                .get(testData.getProject().getId())
                .then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND)
                .body(Matchers.containsString("No project found by locator" +
                        " 'count:1,id:" + testData.getProject().getId() + "'"));
    }

    @Test
    public void systemAdminShouldHaveRightsToCreateProject(){
        var testData = testDataStorage.addTestData();

        testData.getUser().setRoles(generateRoles(Role.SYSTEM_ADMIN, "g"));

        checkedWithSuperUser.getUserRequest()
                .create(testData.getUser());

        var project = new CheckedProject(Specifications.getSpec()
                .authSpec(testData.getUser()))
                .create(testData.getProject());

        softAssert.assertThat(project.getId()).isEqualTo(testData.getProject().getId());
    }

    @Test
    public void projectAdminShouldHaveRightsToCreateBuildConfigToHisProject(){
        var testData = testDataStorage.addTestData();

        checkedWithSuperUser.getProjectRequest()
                .create(testData.getProject());

        testData.getUser().setRoles(generateRoles(Role.PROJECT_ADMIN, "p:"+testData.getProject().getId()));

        checkedWithSuperUser.getUserRequest()
                .create(testData.getUser());


        var buildConfig = new CheckedBuildConfig(Specifications.getSpec().authSpec(testData.getUser()))
                .create(testData.getBuildType());
        softAssert.assertThat(buildConfig.getId()).isEqualTo(testData.getBuildType().getId());
    }

    @Test
    public void projectAdminShouldNotHaveRightsToCreateBuildConfigToAnotherProject(){
        var firstTestData = testDataStorage.addTestData();
        var secondTestData = testDataStorage.addTestData();



        checkedWithSuperUser.getProjectRequest().create(firstTestData.getProject());
        checkedWithSuperUser.getProjectRequest().create(secondTestData.getProject());

        firstTestData.getUser().setRoles(TestDataGenerator
                .generateRoles(Role.PROJECT_ADMIN, "p:"+firstTestData.getProject().getId()));

        checkedWithSuperUser.getUserRequest().create(firstTestData.getUser());

        secondTestData.getUser().setRoles(TestDataGenerator
                .generateRoles(Role.PROJECT_ADMIN, "p:"+secondTestData.getProject().getId()));

        checkedWithSuperUser.getUserRequest()
                .create(secondTestData.getUser());

        new UniversalUnchecked(Specifications.getSpec().authSpec(secondTestData.getUser()), BuildType.class, "BuildType")
                .create(firstTestData.getBuildType())
                .then().assertThat().statusCode(HttpStatus.SC_FORBIDDEN);

    }
}
