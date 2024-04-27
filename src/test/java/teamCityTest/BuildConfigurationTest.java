package teamCityTest;

import org.testng.annotations.Test;
import teamCityProject.api.generators.TestDataStorage;
import teamCityProject.api.requests.checked.CheckedProject;
import teamCityProject.api.requests.checked.CheckedUser;
import teamCityProject.api.spec.Specifications;

public class BuildConfigurationTest extends BaseApiTest {

    @Test
    public void buildConfigurationTest(){
        var testData = testDataStorage.addTestData();

        new CheckedUser(Specifications.getSpec().suerUserSpec()).create(testData.getUser());

        var project = new CheckedProject(Specifications.getSpec()
                .authSpec(testData.getUser()))
                .create(testData.getProject());
        softAssert.assertThat(project.getId()).isEqualTo(testData.getProject().getId());
    }
}
