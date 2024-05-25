package teamCityProject.ui;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.browserCapabilities;

public class BrowserSettings {
    public static void setup(String browserName){
        Configuration.browser = browserName;
        switch (browserName.toLowerCase()){
            case "firefox":
                setFirefoxOptions();
                break;
            case "chrome":
                setChromeOptions();
                break;
        }
    }

    private static Map<String, Boolean> getSelenoidOptions(){
        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableLog", true);
        return options;
    }

    private static void setFirefoxOptions(){
        browserCapabilities = new FirefoxOptions();;
        browserCapabilities.setCapability("selenoid:options", getSelenoidOptions());

    }
    private static void setChromeOptions(){
        browserCapabilities = new ChromeOptions();
        browserCapabilities.setCapability("selenoid:options", getSelenoidOptions());
    }
}
