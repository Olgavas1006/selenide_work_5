import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @AfterEach
    void tearDown () {
        Selenide.closeWebDriver();
    }

    @Test
    void dragAndDropWithActionsTest() {
        open("/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");

        $(elementA).shouldHave(text("A"));
        $(elementB).shouldHave(text("B"));

        actions().moveToElement(elementA).clickAndHold().moveToElement(elementB).release()                              // Отпускаем
                .perform();

        elementA.shouldHave(text("B"));
        elementB.shouldHave(text("A"));

    }
    @Test
    void DragAndDropElementTest () {
        open("/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");

        $(elementA).shouldHave(text("A"));
        $(elementB).shouldHave(text("B"));

        $(elementA).dragAndDrop(to(elementB));

        elementA.shouldHave(text("B"));
        elementB.shouldHave(text("A"));

    }
}
