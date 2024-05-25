package teamCityProject.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import lombok.Getter;
import teamCityProject.api.models.User;
import teamCityProject.ui.Selectors;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class LoginPage extends Page{

    private static final String LOGIN_PAGE_URL = "/login.html";
    private SelenideElement userNameInput = element(Selectors.byId("username"));
    private SelenideElement userPasswordInput = element(Selectors.byId( "password"));


    public LoginPage open(){
        Selenide.open(LOGIN_PAGE_URL);
        return this;
    }

    public void login(User user){
        userNameInput.sendKeys(user.getUsername());
        userPasswordInput.sendKeys(user.getPassword());
        submit();
    }


}