import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DragAndDropTest {

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void dragAndDropTest() {
        open("/drag_and_drop");

        $("#column-a").dragAndDropTo("#column-b");

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
