package Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import static com.codeborne.selenide.Selenide.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SelenideDownloadFilesTest  {
    //эти шаги  void selenideDownloadFilesTest валидны, если НЕТ Локатора -  href !! Файлы скачиваются через ПРОКСИ (но  - такие Шаги через ПРОКСИ могут быть НЕ СТАБИЛЬНЫ !!)

    static {
       // Configuration.fileDownload = FileDownloadMode.PROXY; //вариант, но не стабильный
        Configuration.downloadsFolder = "D:\\ANDREY\\STUDY\\Lessons\\YandexPracticum_QA\\Автоматизация тестирования Java\\13_Работа с файлами" ; //лучший вариант - прям сюда и успешно скачивается !
    }

    @Test
        //эти шаги  void selenideDownloadFilesTest валидны, если есть Локатор -  href.  Файл скачивается в папку Build - Downloads. Если этот - ождаемый результат, то ок (по уроку - это непонятно)

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


        @Test // upload, т.е. загрузка В интернет
        void selenideUploadFilesTest () {
        open("https://fineuploader.com/demos.html"); //https://demoqa.com/upload-download
            /* загрузить файл на сайт получилось ! Лучше класть загружаемый файл именно в папку "resources" (чтобы у всех, кто работает на этом проекте, был к нему не локальный доступ) */
        $("input[type='file']").uploadFile(new File("C:\\Users\\User\\IdeaProjects\\STUDY_Gradle_Selenium\\src\\test\\resources\\sampleFile1.jpeg"));
            //можно и так - второй вариант
          //  $("input[type='file']").uploadFromClasspath("sampleFile1.jpeg");


}
}