package Selenide;

import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

//команды Селенида
public class Snippets {
    @Test
    void browser_commands_examples() {
        // Открыть страницу
        open("https://github.com/");  // абсолютная ссылка - 1 вариант
        Configuration.baseUrl="https://github.com/";  // неизменная ссылка - 2 вариант
        open(".blog/"); // ссылка, идущая после неизменной ссылки - 2 вариант (продолжение)


        Selenide.back(); // вернуться назад
        Selenide.refresh(); // перезагрузить страницу
        Selenide.closeWindow(); // закрыть активное окно
        Selenide.closeWebDriver(); // закрыть текущий браузер (и все окна в нём соответственно)
        Selenide.switchTo().window("Yandex"); // переключиться на вкладку такую-то (если открыто больше одной вкладки)

        Selenide.clearBrowserCookies(); // очистить куки //после этого обычно Selenide.refresh(); // перезагрузить страницу
        Selenide.clearBrowserLocalStorage(); // очистить локальное хранилище  //после этого обычно Selenide.refresh(); // перезагрузить страницу

        Selenide.confirm(); // подтверждает действие (например, подтвердите, что вы действительно хотите выйти со страницы)
        Selenide.dismiss(); // отменяет действие (например, отмена под)

        Selenide.switchTo().frame("Something"); // переключиться на фрейм (как бы страницв-в-странице в окне браузера)
        Selenide.switchTo().defaultContent(); // вернуться к основному контенту (если был переключен на фрейм - см. выше - Selenide.switchTo().frame("Something");)

    }

    void selectors_examples() {
        // Поиск элементов
        $(byAttribute("a", "b")).click(); // поиск по атрибуту
        $("[a=aa]").click(); // аналогичный поиск по атрибуту _ [a=aa]

        $(By.id("searchInput")).setValue("Selenide"); // поиск по id
        $("#b").click(); // аналогичный поиск по id _ (#)

        $(By.className("searchInput")).setValue("Selenide"); // поиск по классу
        $(".search").click(); // аналогичный поиск по классу _ (.)


        $(By.name("searchInput")).setValue("Selenide"); // поиск по имени
        $(By.tagName("input")).setValue("Selenide"); // поиск по тегу
        $(By.linkText("Selenide")).click(); // клик по ссылке
        $(By.partialLinkText("Selenide")).click(); // клик по частичной ссылке

        $(By.xpath("//input[@id='searchInput']")).setValue("Selenide"); // поиск по XPath
        $x("//input[@id='searchInput']").setValue("Selenide"); // аналогичный поиск по XPath

        $(By.cssSelector("input.searchInput")).setValue("Selenide"); // поиск по CSS-селектору
       element(By.cssSelector("Smth")).click(); // аналогичный поиск по CSS-селектору

        $(byText("Selenide")).click(); // поиск по тексту
        $(withText("Selenide")).click(); // поиск по ЧАСТИ текста

        $(byTagAndText("input", "Selenide")).click(); // поиск по тегу и тексту
        $(withTagAndText("input", "Seleni")).click(); // поиск по тегу и ЧАСТИ текста

        $("").parent(); // ищет "родительский" элемент
        $("").sibling(1); // ищет следующий элемент (вниз по DOM) - (номер записи 1, 2, 3 и т.д.)
        $("").preceding(2); // ищет предыдущий элемент (вверх по DOM) - (номер записи 1, 2, 3 и т.д.)
        $("").closest("div"); // ищет родительский элемент с указанным тегом (вниз по DOM)
        $("").ancestor("div"); // ищет родительский элемент с указанным тегом (вверх по DOM)

        $("div").$("input").find(byText("Selenium")); // ищет первый потомок с указанным тегом (). Слово "find" = $.  и  = "element". Но со слова "find" нельзя начать строку !!
    }

    void actions_examples() {
        // Действия с элементами
        $("").click(); // клик по тексту
        $("").doubleClick(); // двойной клик по тексту
        $("Selenide").hover(); // наведение на текст
        $("Selenide").contextClick(); // клик по тексту (правой клавишей мыши)

        $("div").sendKeys("c"); // выполнить действие на веб-форме ("горячая клавиша") с привязкой к элементу (див в данном случае)
        actions().sendKeys("c").perform(); // выполнить действие на веб-форме  без привязки к элементу ("горячая клавиша")
        actions().sendKeys(Keys.chord(Keys.CONTROL, "S")).perform(); // выполнить действие на веб-форме (открывает окно для сохранения на веб-форме Ctrl+S)
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "S")); // аналогично - выполнить действие на веб-форме (открывает окно для сохранения на веб-форме Ctrl+S)

        $("").clear(); // очистка поля ввода
        $("").setValue(""); // аналогично очистка поля ввода (т.к. команда .clear()  может сработать не всегда)
        $("").setValue("Hello, Selenide!"); // ввод текста

        $("").pressEnter(); // нажатие клавиши Enter
        $("").pressEscape(); // нажатие клавиши Esc
        $("").pressTab(); // нажатие клавиши Tab

        $("").selectOption("значение 1"); // выбор значения из выпадающего списка (строка, где указано "select" - это и есть дропдаун / он же - выпадающий список)
                                                        //этот способ подходит для "старых" дропдаунов
        $("").selectRadio("значение 1"); // выбор значения из дропдауна (строка, где указано "radio")
    }

    void assertions_examples() {
        // Проверки состояний
        $("").shouldBe(visible); // проверка видимости элемента
        $("").shouldNotBe(visible); // проверка НЕ видимости элемента

        $("").shouldHave(text("Hello, Selenide!")); // проверка текста
        $("").shouldNotHave(text("Hello, Selenide!")); // проверка ОТСУТСТВИЯ текста

        $("").shouldBe(enabled); // проверка включенности элемента
        $("").should(be(selected)); // проверка выбранности элемента

        $("").should(appear); // проверка появления элемента
        $("").shouldNot(appear); // проверка НЕ появления элемента
        }

    void conditions_examples() {
        // Условные конструкции
        $("").shouldBe(visible); // проверка видимости элемента
        $("").shouldBe(hidden); // проверка НЕ видимости элемента
        $("").shouldBe(empty); // проверка пустоты элемента (или notempty)
        $("").shouldBe(checked); // проверка отмеченности элемента (в чек-боксе) (и unchecked)

        $("").shouldHave(text("Hello, Selenide!")); // проверка текста
        $("").shouldHave(exactText(("Hello, Selenide!"))); // проверка ТОЧНОГО текста
        $("").shouldHave(attribute("disabled")); // проверка отключенности элемента
        $("").shouldHave(attribute("enabled")); // проверка включенности элемента
        $("").shouldHave(attribute("title", "Hello, Selenide!")); // проверка атрибута
        $("").shouldHave(cssClass("error1"), cssClass("error2")); // проверка нескольких CSS-классов
        $("").shouldHave(cssValue("background-color", "red")); // проверка значения CSS-атрибута (например, проверка фонового цвета - red)
        $("").shouldHave(value("Hell, Selenid!")); // проверка значения элемента
        $("").shouldHave(exactValue("Hello, Selenide!")); // проверка ТОЧНОГО значения

        $("").should(enabled); // проверка включенности элемента (или disabled)
        $("").should(exist); // проверка существования элемента (можно использовать для поиска "невидимного" элемента)
        $("").should(matchText("[0-9]#abc$")); // проверка текста с использованием рег экс (сложного текста)

        }

    void collections_examples() {
    // Коллекции

    // отбор (selections)
    $$("div"); //ничего не ищет ! (т.к. для Поиска в конце кода должно стоять какое-то действие ! Клик, Ентер и т.п.)
    $$x("//div"); // ищет по XPath

    $$("").filterBy(text("Hello, Selenide!")).shouldHave(size(1)); // ищет все элементы по фильтру текста "Hello, Selenide!" и проверяет их кол
    $$("div").excludeWith(text("Hello, Selenide!")).shouldHave(size(1)); // ищет все элементы, за ИСКЛЮЧЕНИЕМ тех, что по фильтру текста

    $$("div").findBy(text("Hello, Selenide!")).click(); // ищет все элементы по тексту


    // подтверждения (assertions)

    $$("").shouldHave(texts("Hello", "Selenide", "!")); // подтверждает наличие текста
    $$("").shouldHave(exactTexts("Hello", "Selenide", "!")); // подтверждает ТОЧНОЕ наличие текста
    $$("").shouldHave(exactTextsCaseSensitive("HellO", "SelEniDE", "!")); // подтверждает ТОЧНОЕ наличие текста (c УЧЁТОМ РЕГИСТРА !)
    $$("").shouldHave(textsInAnyOrder("Selenide", "!", "Hello")); // подтверждает наличие текста (слова в ЛЮБОМ порядке)


        }

     void file_operations_examples() {
     // загрузка документов

File file1 = $("link").download(); // только для "простых"  / ("старых") ссылок типа <a href=".."> links
File file2 = $("link").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // только для "сложных" / "современных"  - код работает почти везде и всегда !

File file = new File ("src\\test\\resources\\readme.txt");
$("#file.upload").uploadFile(file1); // загрузка file1 (можно file2 и любой другой)
$("uploadButton").click(); // обязательно нажать клик, чтобы пошла загрузка !
//или
$("#file.upload").uploadFromClasspath("readme.txt");  // загрузка readme.txt
$("uploadButton").click(); // обязательно нажать клик, чтобы пошла загрузка !
  }

  void javascript_examples () {

  executeJavaScript("alert('Selenide')"); // наиболее часто встречающийся скрипт (для прохождения, например, всех шагов в маркете, чтобы сразу тестировать Корзину)
  executeJavaScript("alert(arguments[1]+arguments[2])","abc", 12); // тот же скрипт, но уже с аргументами
  long test = executeJavaScript("return alert(arguments[1]+arguments[2];",3, 4); // ещё более сложный скрипт

  }
}
