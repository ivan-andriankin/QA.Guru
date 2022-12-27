package homeworks;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork2 {
    @Test
    void doHomeWork2() {
        //Откройте страницу Selenide в Github
        open("https://www.github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide/selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();

        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $$("li.Box-row").shouldHave(CollectionCondition.itemWithText("SoftAssertions"));

        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$(".Box-row a").findBy(text("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }
}
