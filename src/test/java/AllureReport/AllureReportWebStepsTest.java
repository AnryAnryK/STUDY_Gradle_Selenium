package AllureReport;

import GitHub.TestAllureSelenide;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class AllureReportWebStepsTest extends TestAllureSelenide {  //для Allure - отчётов, но о{
    private static final String Website = "https://github.com/";


    // В таком подходе ХУЖЕ  читаемость Отчета, но ЛУЧШЕ !! переиспользуемость Тестов !!!
    // Подход называется Стэп Аннотейтед -  public void testAnnotededSteps ()

//  steps.openMainPage();
//steps.searchForSelenide();
//steps.clickToFirstFindString();
//steps.FindPageAndreiSolncev();
//steps.GoToPageAndreiSolncev();


    @Step ("открыть сайт: https://github.com/")
    public void openMainPage(){
// 1 - открыть сайт: https://github.com/
       step ("открыть сайт: https://github.com/"); open(Website);
    }


    // 2 - в поисковой строке ввести слово: Selenide
    @Step ("в поисковой строке ввести слово: Selenide")
    public void searchForSelenide(){
       step ("в поисковой строке ввести слово: Selenide"); $(By.xpath("//*[@data-target='qbsearch-input.inputButtonText']")).click();
        $x(".//*[@style='width: 300px;']").setValue("Selenide").pressEnter();

        $(By.xpath("//*[@data-target='qbsearch-input.inputButtonText']")).click();
        $x(".//*[@style='width: 300px;']").setValue("Selenide").pressEnter();
    }
    @Step ("кликнуть на первую строку/первый репозиторий из списка найденных")
    // 3 - кликнуть на первую строку/первый репозиторий из списка найденных
    public void clickToFirstFindString () {
        step ("кликнуть на первую строку/первый репозиторий из списка найденных"); $x(".//span[@class='Text-sc-17v1xeu-0 qaOIC search-match' and contains(text(),'selenide/')]").click();
}

    @Step ("найти в заголовке Contributors страницу Андрея Солнцева (первого в списке)")
    // 4 - найти в заголовке Contributors страницу Андрея Солнцева (первого в списке)
    public  void FindPageAndreiSolncev () {
        step ("найти в заголовке Contributors страницу Андрея Солнцева (первого в списке)"); $x(".//*[@src='https://avatars.githubusercontent.com/u/279773?s=64&v=4']").click();
}

    @Step ("выйти на страницу Андрея Солнцева")
    // 5 - выйти на страницу Андрея Солнцева
    public  void GoToPageAndreiSolncev () {
        step ("выйти на страницу Андрея Солнцева"); $x(".//*[@itemprop='name']").shouldHave(text("Andrei Solntsev"));
}
    //    УСПЕШНО




    @Test
    @Owner("Андрей Калинченко")
    @Description ("Поиск на ГитХаб страницы создателя Селенида - Андрея Солнцева")
    public   void  FindBestSelenideContributorTest() {
        SelenideLogger.addListener("allure", new AllureSelenide()); // !! всё итак хорошо работало и без этой строчки !! - её в 15 Уроке сказал ставить Артём Ерошенко (создатель Аллюра)
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(false)
//                .savePageSource(true));  //для Allure - отчётов, но такая конструкция не работает, так что оставил только 1-ю строку

        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))
    }


    @Test
    public void testAnnotededSteps () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        AllureReportWebStepsTest steps = new AllureReportWebStepsTest();
steps.openMainPage();
steps.searchForSelenide();
steps.clickToFirstFindString();
steps.FindPageAndreiSolncev();
steps.GoToPageAndreiSolncev();

    }
}
