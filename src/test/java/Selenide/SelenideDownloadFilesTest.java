package Selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import static com.codeborne.selenide.Selenide.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SelenideDownloadFilesTest  {
    @Test
    void selenideDownloadFilesTest () throws Exception {
        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))

        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $x(".//*[@data-testid='raw-button']").download(); // с href
        try ( InputStream is = new FileInputStream(downloadedFile)) {
            byte[] bytes = is.readAllBytes();
            String readme = new String(bytes, StandardCharsets.UTF_8);
            assertThat(readme).contains("This repository is the home of _JUnit 5_.");

        }

        //$x(".//*[@class='octicon octicon-download']").click(); // - нажимать-то нажимает, но не скачивает ! без href
        //File downloadedFile = $x(".//*[@id=':R3b76faladaeb:']").download(); // не работает ! без href
    }
}
