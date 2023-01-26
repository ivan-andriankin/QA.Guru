package homeworks.moex;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.TimeZone;
import java.util.stream.Stream;

public class TestBase {

    static DateComponent dateComponent = new DateComponent();

    @BeforeEach
    void beforeEach() {
        Configuration.baseUrl = "https://www.moex.com";
    }

    static Stream<Arguments> moexWeekDay() {
        return Stream.of(
                Arguments.of(dateComponent.weekDay)
        );
    }

    static Stream<Arguments> moexLocaleDataProvider() {
        return Stream.of(
                Arguments.of(Locale.EN, List.of("Markets", "Indices", "Market data", "Listing", "Connectivity", "News and events", "About MOEX", "Investor Relations")),
                Arguments.of(Locale.RU, List.of("Продукты и услуги", "Биржевая информация", "Документы", "Медиа", "О компании"))
        );
    }

}
