package homeworks;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork4 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x800";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void firstTest() {

        // Variables used in this test case
        String firstName = "Ivan";
        String lastName = "Andriankin";
        String userEmail = "qqq@bk.ru";
        String userNumber = "8777888123";
        String userSubject = "eng";
        String currentAddress = "India";
        String state = "Rajasthan";
        String city = "Jaipur";

        // prepare test page
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // check that expected page was open
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        // specify values in the form and submit
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("August");
            $(".react-datepicker__year-select").selectOption("2011");
            $(".react-datepicker__day--010:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(userSubject).pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/images/road.png"));
        $("#currentAddress").setValue(currentAddress);
        $("#stateCity-wrapper").$(byText("Select State")).click();
            $("#stateCity-wrapper").$(byText("Rajasthan")).click();
            $("#stateCity-wrapper").$(byText("Select City")).click();
            $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        // check that the confirmation pop-up appeared
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(firstName), text(lastName), text(userEmail), text("Male"),
                text(userNumber), text("10 August,2011"), text("English"), text("Reading"), text("road.png"),
                text(currentAddress), text(state + " " + city));

        // close the confirmation pop-up
        $("#closeLargeModal").click();

    }

}
