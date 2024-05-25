package teamCityUiTest;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeSuite;
import teamCityApiTest.BaseTest;
import teamCityProject.api.config.Config;
import teamCityProject.api.models.User;
import teamCityProject.api.requests.checked.CheckedUser;
import teamCityProject.api.spec.Specifications;
import teamCityProject.ui.BrowserSettings;
import teamCityProject.ui.pages.LoginPage;

public class BaseUiTest extends BaseTest {
    @BeforeSuite
    public void setupUiTests(){
        BrowserSettings.setup(Config.getProperty("browser"));
        Configuration.baseUrl = "http://"+ Config.getProperty("host");
        Configuration.remote = Config.getProperty("remote");

        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.downloadsFolder ="target/downloads";
        Configuration.timeout = 10000;
    }

    public void loginAsUser(User user){
        // generate test user
        new CheckedUser(Specifications.getSpec().superUserSpec()).create(user);

        new LoginPage().open().login(user);
    }
}
