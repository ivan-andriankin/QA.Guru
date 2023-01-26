package homeworks.registrationpage;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm extends TestBase {

    @Test
    void firstTest() {

        // Variables used in this test case
        String firstName = "Ivan";
        String lastName = "Andriankin";
        String userEmail = "qqq@bk.ru";
        String gender = "Other";
        String userNumber = "8777888123";
        String[] userBirthday = {"29", "May", "1991"};
        String[] userSubjects = {"English", "Accounting"};
        String[] userHobbies = {"Reading", "Sports"};
        String currentAddress = "Somewhere in India";
        String state = "Rajasthan";
        String city = "Jaipur";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(userBirthday[0], userBirthday[1], userBirthday[2])
                .setUserSubject(userSubjects[0], userSubjects[1])
                .setUserHobby(userHobbies[0], userHobbies[1])
                .uploadPicture("src/test/java/resources/images/road.png")
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city);

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth",
                        userBirthday[0] + " " + userBirthday[1] + "," + userBirthday[2])
                .verifyResult("Subjects", userSubjects[0] + ", " + userSubjects[1])
                .verifyResult("Hobbies", userHobbies[0] + ", " + userHobbies[1])
                .verifyResult("Picture", "road.png")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city)
        ;

        // close the confirmation pop-up
        $("#closeLargeModal").click();

    }

}
