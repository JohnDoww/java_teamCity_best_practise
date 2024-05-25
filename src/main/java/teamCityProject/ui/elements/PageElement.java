package teamCityProject.ui.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public abstract class PageElement {
    private final SelenideElement element;

    public PageElement(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement findElementBy(By by){
        return element.find(by);
    }

    public SelenideElement findElementBy(String value){
        return element.find(value);
    }

    public ElementsCollection findElementsBy(By by){
        return element.findAll(by);
    }

}
