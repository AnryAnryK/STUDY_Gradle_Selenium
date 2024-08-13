package JUnit5;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTestLocal
{

    static Stream <Arguments> localTranclate(){

        return Stream.of(
                Arguments.of(Local.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Local.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );

    }

    @MethodSource  // абсолютно УНИВЕРСАЛЬНЫЙ способ (дата-провайдер). с 01:12:00 урока и с 01:27:00 - Дмитрий Тучс объясняет его универсальность

    @ParameterizedTest(name = "Для локали {0} отображаются кнопки {1}")

    @Tag("BLOCKER")

    void localTranclate

            (
            Local local,
            List<String> buttons
    )  {
        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))

open("https://selenide.org");
$$("#languages a").find(text(local.name())).click();
$$(".main-menu-pages a")
        .filter(visible)
        .shouldHave(CollectionCondition.texts(buttons));

}

}
