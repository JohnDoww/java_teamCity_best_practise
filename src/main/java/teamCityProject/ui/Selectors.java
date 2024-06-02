package teamCityProject.ui;

import com.codeborne.selenide.selector.ByAttribute;

public class Selectors {
    public static ByAttribute byId(String value){
        return new ByAttribute("id", value);
    }
    public static ByAttribute byType(String value){
        return new ByAttribute("type", value);
    }

    public static ByAttribute byName(String value){
        return new ByAttribute("name", value);
    }
    public static ByAttribute byDataTest(String value){
        return new ByAttribute("data-test", value);
    }
    public static ByAttribute byClass(String value){
        return new ByAttribute("class", value);
    }

    public static ByAttribute byAgentSidebar(String value) {
        return new ByAttribute("data-test-agents-sidebar-title", value);
    }

    public static ByAttribute byHref(String value) {
        return new ByAttribute("href", value);
    }
}
