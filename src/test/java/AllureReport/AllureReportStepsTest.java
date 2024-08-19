package AllureReport;

import GitHub.TestAllureSelenide;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class AllureReportStepsTest extends TestAllureSelenide {  //для Allure - отчётов, но о{

    private static final String Website = "https://github.com/";

    @Test
    @Owner("Андрей Калинченко")
    @Description ("Поиск на ГитХаб страницы создателя Селенида - Андрея Солнцева")
    @Feature("Тестирование для получения Аллюр Репортс") //
    @Story("Получение результатов отчетов Аллюр Репортс разными способами") // Как пользователь ведёт себя при работе с данной Фичей !
    @Severity(SeverityLevel.BLOCKER)
    @Link (value = "https://github.com/", url = "https://github.com/")
    @DisplayName("Получение результатов отчетов Аллюр Репортс при тестировании GitHub Project Андрея Солнцева")

    public   void  FindBestSelenideContributorTest(){
        SelenideLogger.addListener("allure", new AllureSelenide()); // !! всё итак хорошо работало и без этой строчки !! - её в 15 Уроке сказал ставить Артём Ерошенко (создатель Аллюра)
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(false)
//                .savePageSource(true));  //для Allure - отчётов, но такая конструкция не работает, так что оставил только 1-ю строку

        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))

        // В таком подходе ЛУЧШЕ читаемость Отчета, но ХУЖЕ переиспользуемость Тестов !!!
// 1 - открыть сайт: https://github.com/
        step("открыть сайт: https://github.com/", () ->
        {
        open(Website);
        });

        //или оно же -

//        step("открыть открыть сайт: https://github.com/", new Allure.ThrowableContextRunnableVoid<Allure.StepContext>() {
//            @Override
//            public void run(Allure.StepContext context) throws Throwable {
//            }
//        });

// 2 - в поисковой строке ввести слово: Selenide
        step("в поисковой строке ввести слово: Selenide", () -> {
        $(By.xpath("//*[@data-target='qbsearch-input.inputButtonText']")).click();
        $x(".//*[@style='width: 300px;']").setValue("Selenide").pressEnter();
        });

// 3 - кликнуть на первую строку/первый репозиторий из списка найденных
        step("кликнуть на первую строку/первый репозиторий из списка найденных", () -> {
                    $x(".//span[@class='Text-sc-17v1xeu-0 qaOIC search-match' and contains(text(),'selenide/')]").click();
        });

// 4 - найти в заголовке Contributors страницу Андрея Солнцева (первого в списке)
        step("найти в заголовке Contributors страницу Андрея Солнцева (первого в списке)", () -> {
                    $x(".//*[@src='https://avatars.githubusercontent.com/u/279773?s=64&v=4']").click();
        });

// 5 - выйти на страницу Андрея Солнцева
        step("выйти на страницу Андрея Солнцева", () -> {
        $x(".//*[@itemprop='name']").shouldHave(text("Andrei Solntsev"));

        }); //    УСПЕШНО

// 6 - Успешный тест
        step ("Успешный тест");
    }
  }
