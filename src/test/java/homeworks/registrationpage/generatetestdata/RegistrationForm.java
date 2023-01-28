package homeworks.registrationpage.generatetestdata;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static homeworks.registrationpage.generatetestdata.utils.RandomUtils.*;

public class RegistrationForm extends TestBase {

    @Test
    void firstTest() {

        // мною написанные методы из TestBase
//        String firstName = randomString(10);
//        String lastName = randomString(10);
//        String userEmail = randomEmail();


        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String gender = randomGender();
        String userNumber = randomMobileNumber();
        String[] userBirthday = randomDate();
        String[] userSubjects = {"English", "Accounting"}; // нет необходимости в генерации тестовых данных
        String[] userHobbies = {"Reading", "Sports"}; // нет необходимости в генерации тестовых данных
        String currentAddress = faker.address().fullAddress();
        String state = "Rajasthan"; // нет необходимости в генерации тестовых данных
        String city = "Jaipur"; // нет необходимости в генерации тестовых данных

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(userBirthday[0], userBirthday[1], userBirthday[2])
                .setUserSubject(userSubjects[0], userSubjects[1])
                .setUserHobby(userHobbies[0], userHobbies[1])
                .uploadPicture("images/road.png")
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
