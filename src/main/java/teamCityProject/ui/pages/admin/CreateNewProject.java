package teamCityProject.ui.pages.admin;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import teamCityProject.ui.Selectors;
import teamCityProject.ui.pages.Page;

import static com.codeborne.selenide.Selenide.element;

public class CreateNewProject extends Page {
    private SelenideElement urlInput = element(Selectors.byName("url"));
    private SelenideElement projectNameInput = element(Selectors.byId("projectName"));
    private SelenideElement buildTypeNameInput = element(Selectors.byId("buildTypeName"));
    public CreateNewProject open(String parentProjectId){
        Selenide.open("/admin/createObjectMenu.html?projectId="+parentProjectId+"&showMode=createProjectMenu&cameFromUrl=http%3A%2F%2Flocalhost%3A8111%2Ffavorite%2Fprojects%3Fmode%3Dbuilds#createFromUrl");
        waitUntilPageIsLoaded();
    return this;
    }

    public CreateNewProject createProjectByUrl(String url){
        urlInput.sendKeys(url);
        submit();
        return this;
    }

    public void setupProject(String projectName, String buildTypeName){
        projectNameInput.clear();
        buildTypeNameInput.clear();

        projectNameInput.sendKeys(projectName);
        buildTypeNameInput.sendKeys(buildTypeName);
        submit();
    }
}
