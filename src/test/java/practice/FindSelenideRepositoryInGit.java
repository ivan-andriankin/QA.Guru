package practice;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FindSelenideRepositoryInGit {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        // ARRANGE
        // ACT
        // ASSERT
        Selenide.open("https://www.github.com/"); // открыть главную страницу
        Selenide.$("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter(); // ввести в поле поиска selenide и нажать enter
        $$("ul.repo-list li").first().$("a").click(); // кликнуть на первый репозиторий из списка найденных
        $("#repository-container-header").shouldHave(text("selenide / selenide")); // проверка: заголовок selenide/selenide
        //sleep(5000);
    }
}
