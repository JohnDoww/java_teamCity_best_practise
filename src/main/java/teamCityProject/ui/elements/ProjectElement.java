package teamCityProject.ui.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import teamCityProject.ui.Selectors;

@Getter
public class ProjectElement extends  PageElement{
    private final SelenideElement header;
    private final SelenideElement icon;

    public ProjectElement(SelenideElement element) {
        super(element);
        this.header = findElementBy(Selectors.byDataTest("subproject"));
        this.icon = findElementBy("svg");
    }
}