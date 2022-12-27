import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));

        //вариант с "https://selenide.org" фейлится т.к. в результатах поиска выдается "https://ru.selenide.org"
        //тест успешно отрабатывает с вариантами "selenide.org" и "https://ru.selenide.org"
    }


}
