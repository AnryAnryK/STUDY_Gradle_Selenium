package GitHub;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.SetValue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchTest {

    @Test
          void shouldFindSelenideRepositoryAtTheTop(){
// 1 - открыть сайт: https://github.com/
        open("https://github.com/");

// 2 - в поисковой строке ввести слово: Selenide
        $(By.xpath("//*[@data-target='qbsearch-input.inputButtonText']")).click();
        $x(".//*[@style='width: 300px;']").setValue("Selenide").pressEnter();

// 3 - кликнуть на первую строку/первый репозиторий из списка найденных
        $x(".//span[@class='Text-sc-17v1xeu-0 qaOIC search-match' and contains(text(),'selenide/')]").click();

 // 4 - проверить, что заголовок после 3 Шага: selenide
        $x(".//a[@class='url fn']").shouldHave(text("selenide"));    //-  УСПЕШНО
//        $x(".//span[@class='author flex-self-stretch']").shouldHave(text("selenide"));  - ТОЖЕ УСПЕШНО
//        $x(".//strong[@class='mr-2 flex-self-stretch']").shouldHave(text("selenide"));   - ТОЖЕ УСПЕШНО
        //sleep(999999);

 //5 - кладу в ГитХаб
    }
}
