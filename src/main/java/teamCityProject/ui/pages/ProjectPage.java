package teamCityProject.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import teamCityProject.ui.Selectors;

import teamCityProject.ui.elements.ProjectElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class ProjectPage extends Page{

    public static final String FAVORITE_PROJECTS_LINK = "/favorite/projects?mode=builds";

    private ElementsCollection subprojects = elements(Selectors.byClass("Subproject__container--Px"));
    private SelenideElement listOfSubprojects = element(Selectors.byClass( "Subprojects__limitWidth--MY"));


    public ProjectPage open(){
        Selenide.open(FAVORITE_PROJECTS_LINK);
        waitUntilPageIsLoaded();
        return this;
    }

    public List <ProjectElement> getSubprojects(){
        listOfSubprojects.shouldBe(Condition.visible);
        return generatePageElements(subprojects, ProjectElement::new);
    }


}