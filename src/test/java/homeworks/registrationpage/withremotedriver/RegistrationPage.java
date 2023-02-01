package homeworks.registrationpage.withremotedriver;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final static String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameElement = $("#firstName"),
            lastNameElement = $("#lastName"),
            dateOfBirthElement = $("#dateOfBirthInput"),
            emailElement = $("#userEmail"),
            genderElement = $("#genterWrapper"),
            userNumberElement = $("#userNumber"),
            userSubjectElement = $("#subjectsInput"),
            userHobbyElement = $("#hobbiesWrapper"),
            uploadPictureElement = $("#uploadPicture"),
            currentAddressElement = $("#currentAddress"),
            stateCityElement = $("#stateCity-wrapper");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameElement.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameElement.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailElement.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderElement.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberElement.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthElement.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setUserSubject(String valueOne, String valueTwo) {
        userSubjectElement.setValue(valueOne).pressEnter();
        userSubjectElement.setValue(valueTwo).pressEnter();
        return this;
    }

    public RegistrationPage setUserHobby(String valueOne, String valueTwo) {
        userHobbyElement.$(byText(valueOne)).click();
        userHobbyElement.$(byText(valueTwo)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureElement.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressElement.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateCityElement.$(byText("Select State")).click();
        stateCityElement.$(byText(state)).click();
        stateCityElement.$(byText("Select City")).click();
        stateCityElement.$(byText(city)).click();
        $("#submit").click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

}
