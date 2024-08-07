package demoqacom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;


public class TextBoxTests {
    @BeforeAll
    static void setUp() {
    Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
    Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))
    Configuration.baseUrl = "https://demoqa.com"; // для УНИВЕРСАЛЬНОСТИ тестов указал один базовый URL для ВСЕХ тестов
    }

    @Test
    void SuceccfulTextBoxTests () throws InterruptedException {
// Тест 1 "Проверка успешности внесения данных в текстовые поля"
        String userName1 = "Ivanov Ivan Ivanovich"; // Данные 1: вынесли в Отдельную Переменную UserName (чтобы в каждом тесте не писать её заново)
        String email1 = "Ivanov@mail.com";
        String currentAdress1 = "Moscow, Kremlin, 1";
        String permanentAdress1 = "Kostroma, Kostromskay str., 1";

        String userName2 = "Petrov Petrov Petrovich"; // Данные 2


      open ("/text-box");
      $x(".//*[@class='text-center']").shouldHave(text("Text Box")); // Проверка заголовка

      $x(".//*[@placeholder='Full Name']").setValue(userName1);
      $x(".//*[@placeholder='name@example.com']").setValue(email1);
      $x(".//*[@placeholder='Current Address']").setValue(currentAdress1);
      $x(".//*[@id='permanentAddress']").setValue(permanentAdress1);
      $x(".//*[@id='submit']").click();

        $x(".//*[@class='border col-md-12 col-sm-12']").shouldHave(text(userName1));
        $x(".//*[@id='email']").shouldHave(text("Ivanov@mail.com"));
        $x(".//*[@id='output']").shouldHave(text("Moscow, Kremlin, 1"));
        $x(".//*[@id='output']").shouldHave(text("Kostroma, Kostromskay str., 1"));
        //$x(".//*[@id='currentAddress']").shouldHave(text("Moscow, Kremlin, 1")); // так - не работает, т.к. таких Локаторов - несколько (2 шт.) !
        //$x(".//*[@id='permanentAddress']").shouldHave(text("Kostroma, Kostromskay str., 1")); // так - не работает, т.к. таких Локаторов - несколько (2 шт.) !
        //sleep(9999);
        // Тест 1 "Проверка успешности внесения данных в текстовые поля"  -  Успешный
    }
 }

