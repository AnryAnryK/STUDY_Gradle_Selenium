package JUnit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class JUnitTest1 {

    @DisplayName("Тест1") // описание действия - в Аллюр Репорт вместо названия Теста названия метода "JUnitTest1" будет выводиться название Теста "Тест 1
@Test
    @Tags({@Tag("BLOCKER"), @Tag("UI_Test")}) // эта аннотация означает Уровень критичности Теста (по ней можно будет фильтровать, например: все "BLOCKER" тесты и т.д.

    void  setup (){
                open("https://github.com/"); // открыть сайт: https://github.com/
    }
       void JUnitTest1(){
    Assertions.assertTrue(3>2);
    }

    //@ParameterizedTest  //- так обозначаются параметризованные тесты
//@ValueSource (strings = "Selenide", "https://selenide.org")  // так обозначаются параметризованные тесты когде есть всего Один документ

    //@CsvSource({"Allure, https://qameta.io",
    //"Selenide, https://selenide.org" })    // можно описать так




       //  @MethodSource  // абсолютно УНИВЕРСАЛЬНЫЙ способ (дата-провайдер). можно описать так - это УНИВЕРСАЛЬНЫЙ дата-провайдер !!  с 01:12:00 урока и с 01:27:00 - Дмитрий Тучс объясняет его универсальность


   @CsvFileSource(resources = "/JUnitTest1") //можно описать через путь к файлу CSV
   @ParameterizedTest
   void ParametrizedTest (
            String url,
            String value)
      {

//   2 - в поисковой строке ввести слово: Selenide
   $(By.xpath("//*[@data-target='qbsearch-input.inputButtonText']")).click();
   $x(".//*[@style='width: 300px;']").setValue("Selenide").pressEnter();

 }  //я так и не понял как это работает - урок 12_JUnit5 где-то с 55 минуты


    @Disabled /* эта аннотация означает, что JUnitTest2 - исключён из Тестов (можно и закомментировать тест,
    но так - считается правильнее, т.к. эта аннотация попадёт в Аллюр Репорт, а Комментарий - туда не попадет.
    Вообще Коммент в коде - это "плохо", нужно пользоваться инструментами языка)*/
    void JUnitTest2(){
        Assertions.assertTrue(1>2);
    }


}

