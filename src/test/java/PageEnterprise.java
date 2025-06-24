import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PageEnterprise {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkPageEnterpriseTest() {

        open("https://github.com/");
        $(byTagAndText("button","Solutions")).hover();
        $(byText("Enterprises")).click();
        $("h1#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));

    }

}
