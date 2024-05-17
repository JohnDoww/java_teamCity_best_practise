package teamCityUiTest;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeSuite;
import teamCityApiTest.BaseTest;
import teamCityProject.api.config.Config;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.browserCapabilities;

public class BaseUiTest extends BaseTest {
    @BeforeSuite
    public void setupUiTests(){
        Configuration.browser = "firefox";
        Configuration.baseUrl = "http://"+ Config.getProperty("host");
        Configuration.remote =Config.getProperty("remote");

        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.downloadsFolder ="target/downloads";

        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableLog", true);

        FirefoxOptions capabilities = new FirefoxOptions();
        browserCapabilities = capabilities;
        browserCapabilities.setCapability("selenoid:options", options);

    }
}