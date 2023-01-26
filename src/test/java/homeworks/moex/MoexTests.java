package homeworks.moex;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.TimeZone;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MoexTests extends TestBase {

    @CsvSource({
        "SVAV, СОЛЛЕРС"
    })
    @ParameterizedTest(name="Код тикера {0} вставить в строку поиска и имя акции  {1} должно быть отображено в результатах")
    void testOne(String tickerCode, String companyName) {
        open("/");
        $("#moex-search-input").setValue(tickerCode);
        $("[data-title=Акции]").shouldBe(Condition.visible);
        $(".search-results__category").shouldHave(text(companyName));
    }


    @CsvFileSource(resources = "/moex_test_data.csv")
    @ParameterizedTest(name="Код тикера {0} вставить в строку поиска и имя акции  {1} должно быть отображено в результатах")
    void testTwo(String tickerCode, String companyName) {
        open("/");
        $("#moex-search-input").setValue(tickerCode);
        $("[data-title=Акции]").shouldBe(Condition.visible);
        $(".search-results__category").shouldHave(text(companyName));
    }


    @ValueSource(
            strings = {"GMK", "SBER"}
    )
    @ParameterizedTest(name="Код тикера {0} вставить в строку поиска, должен отобразиться минимум 1 результат")
    void testThree(String tickerCode) {
        open("/");
        $("#moex-search-input").setValue(tickerCode);
        $("[data-title=Акции]").shouldBe(Condition.visible);
        $$("div .search-results__item").shouldHave(CollectionCondition.sizeGreaterThan(50));
    }


    @MethodSource("moexWeekDay")
    @ParameterizedTest(name = "Проверить день недели")
    void testFour(String weekDay) {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
        open("/");
        $(".header-nav__date").shouldHave(text(weekDay));
    }


    @MethodSource("moexLocaleDataProvider")
    @ParameterizedTest(name = "Для локали {0} отображаются кнопки меню {1}")
    void testFive(
            Locale locale,
            List<String> buttons
    ) {
        open("/");
        $$("a").findBy(text(String.valueOf(locale))).click();
        $(".header__menu-wrapper").$$(".tablink").shouldHave(texts(buttons));
    }

}

