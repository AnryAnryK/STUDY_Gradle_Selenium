package GitHub;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class TestAllureSelenide {
@BeforeEach
    public void setup() {
//WebDriverManager.chromedriver().setup(); // строчка была указана на видео, но и без неё работает - https://rutube.ru/video/7ed41ebb193dc3d3193f0fa020cccc2a/
    Configuration.browser = "chrome";
    Configuration.browserSize = "1920x1080";
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

}
}

