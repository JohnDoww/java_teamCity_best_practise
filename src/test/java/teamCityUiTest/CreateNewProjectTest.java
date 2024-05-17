package teamCityUiTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByAttribute;
import org.testng.annotations.Test;
import teamCityProject.api.requests.checked.CheckedUser;
import teamCityProject.api.spec.Specifications;

import static com.codeborne.selenide.Selenide.element;

public class CreateNewProjectTest extends BaseUiTest{
    @Test
    public void  authorizeUserAbleToCreateNewProject(){
        //generate the test data
        var testData = testDataStorage.addTestData();
        // generate test user
        new CheckedUser(Specifications.getSpec().superUserSpec()).create(testData.getUser());

        Selenide.open("/login.html");


        var userNameInput = element(new ByAttribute("id", "username"));
        var userPasswordInput = element(new ByAttribute("id", "password"));
        var loginButton = element(new ByAttribute("type", "submit"));

        userNameInput.sendKeys(testData.getUser().getUsername());
        userPasswordInput.sendKeys(testData.getUser().getPassword());
        loginButton.click();


    }
}
