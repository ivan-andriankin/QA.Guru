package homeworks.registrationpage.withremotedriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.Map;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.browserSize = "1600x800";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,      // окошко в окошке
                "enableVideo", true             // запись видео
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

}
