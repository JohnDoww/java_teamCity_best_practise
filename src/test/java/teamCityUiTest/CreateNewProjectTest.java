package teamCityUiTest;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import teamCityProject.ui.pages.ProjectPage;
import teamCityProject.ui.pages.admin.CreateNewProject;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class CreateNewProjectTest extends BaseUiTest{
    @Test
    public void  authorizeUserAbleToCreateNewProject(){
        //generate the test data
        var testData = testDataStorage.addTestData();
        var url = "https://github.com/JohnDoww/java_teamCity_best_practise.git";

        loginAsUser(testData.getUser());

        new CreateNewProject()
                .open(testData.getProject().getParentProject().getLocator())
                .createProjectByUrl(url)
                .setupProject(testData.getProject().getName(),testData.getBuildType().getName());

        new ProjectPage().open()
                .getSubprojects()
                .stream().reduce((first, second) -> second).get()
                .getHeader().shouldHave(Condition.text(testData.getProject().getName()));

    }

}