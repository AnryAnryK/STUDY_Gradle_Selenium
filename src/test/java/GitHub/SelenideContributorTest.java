package GitHub;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideContributorTest extends TestAllureSelenide {  //для Allure - отчётов, но о{

    @Test
@Owner("Андрей Калинченко")
    @Description ("Поиск на ГитХаб страницы создателя Селенида - Андрея Солнцева")
      public   void  FindBestSelenideContributorTest(){
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(false)
//                .savePageSource(true));  //для Allure - отчётов, но оно не работает

        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))
// 1 - открыть сайт: https://github.com/
      open("https://github.com/");

// 2 - в поисковой строке ввести слово: Selenide
        $(By.xpath("//*[@data-target='qbsearch-input.inputButtonText']")).click();
        $x(".//*[@style='width: 300px;']").setValue("Selenide").pressEnter();

// 3 - кликнуть на первую строку/первый репозиторий из списка найденных
        $x(".//span[@class='Text-sc-17v1xeu-0 qaOIC search-match' and contains(text(),'selenide/')]").click();

// 4 - найти в заголовке Contributors страницу Андрея Солнцева (первого в списке)
            $x(".//*[@src='https://avatars.githubusercontent.com/u/279773?s=64&v=4']").click();

// 5 - выйти на страницу Андрея Солнцева
    $x(".//*[@itemprop='name']").shouldHave(text("Andrei Solntsev")); //    УСПЕШНО

               }
}
