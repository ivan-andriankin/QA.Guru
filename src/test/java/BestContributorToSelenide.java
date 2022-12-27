import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.text;

public class BestContributorToSelenide {
    @Test
    void solntcevShouldBeTheTopContributor() {
        Configuration.browserSize="800x400";
        open("https://www.github.com/selenide/selenide");
            //open repository page
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
            // hover mouse to the first avatar of Contributors
        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
            // check name: it should be Andrei Solntsev
    }
}
