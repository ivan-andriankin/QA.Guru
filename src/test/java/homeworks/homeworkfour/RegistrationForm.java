package homeworks.homeworkfour;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm extends TestBase {

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

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Male")
                .setUserNumber(userNumber)
                .setBirthDate("30", "August", "1998");



        $("#subjectsInput").setValue(userSubject).pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/images/road.png"));
        $("#currentAddress").setValue(currentAddress);
        $("#stateCity-wrapper").$(byText("Select State")).click();
            $("#stateCity-wrapper").$(byText("Rajasthan")).click();
            $("#stateCity-wrapper").$(byText("Select City")).click();
            $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", "30 August,1998");
        
        // close the confirmation pop-up
        $("#closeLargeModal").click();

    }

}
