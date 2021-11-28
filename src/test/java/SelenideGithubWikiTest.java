import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class SelenideGithubWikiTest {

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void selenideWikiPageContainsSoftAssertionsTest() {
        open("/selenide/selenide");

        //переходим на вики и проверяем, что находимся на странице документации
        $("#wiki-tab").click();
        $("#wiki-body h1").shouldHave(text("Welcome to the selenide wiki!"));

        //ищем SoftAssertions среди Pages и проверяем, что есть в результатах
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        //кликаем на страницу SoftAssertions
        $("#wiki-pages-box").$(withText("SoftAssertions")).click();

        //проверяем, что в тексте есть пример использования JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
