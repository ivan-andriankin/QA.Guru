package homeworks.registrationpage.withremotedriver;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static homeworks.registrationpage.generatetestdata.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;

public class RegistrationForm extends TestBase {

    @Test
    @Tag("remote")
    void firstTest() {

        // мною написанные методы из RandomUtils
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

        step("Open form", () -> {
            registrationPage.openPage();
        });

        step("Fill out the form", () -> {
            registrationPage.setFirstName(firstName)
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
        });

        step("Submit the form", () -> {
            registrationPage.submitForm();
        });

        step("Verify results", () -> {
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
                .verifyResult("State and City", state + " " + city);
        });

        // close the confirmation pop-up
        $("#closeLargeModal").click();

    }

}
