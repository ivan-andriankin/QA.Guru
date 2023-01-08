package practice;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Practice8_2 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x800";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String userName = "Ivan Andriankin";
        String userEmail = "andriankin.ivan@yandex.ru";

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box")); // == $("[class=main-header]").shouldHave(text("Text Box"));

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue("70 let Pobedy");
        $("#permanentAddress").setValue("70 let Pobedy");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave((text(userName)));
        $("#output #email").shouldHave((text(userEmail)));
    }
}
