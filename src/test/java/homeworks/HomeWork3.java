package homeworks;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class HomeWork3 {

    @Test
    void doHomeWork3() {

        //На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
        open("https://github.com/");
        $$("button").findBy(text(" Solutions ")).hover();
        $$("div ul li a").findBy(text("Enterprise")).click();

        //Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        $("h1").shouldHave(text("Build like the best"));
        
    }
}
