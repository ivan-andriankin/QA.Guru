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

    @Test
    void optionalTask() {

        // Откройте https://the-internet.herokuapp.com/drag_and_drop

        // Перенесите прямоугольник А на место В

        // Проверьте, что прямоугольники действительно поменялись

        // В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()

    }
}
