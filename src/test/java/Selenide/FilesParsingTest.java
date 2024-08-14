package Selenide;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class FilesParsingTest {

    ClassLoader cl = FilesParsingTest.class.getClassLoader(); // - это для void xlsParsingTest (где мы XLS-файл положили в папку "Ресурсы")

    @Test
    // PDF
    void pdfParsingTest () throws Exception {
        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))

        //сайт JUnit5 - скачать PDF-руководство по нему
open("https://junit.org/junit5/docs/current/user-guide/");
    File downloadedPDF = $x(".//*[@href='junit-user-guide-5.11.0.pdf']").shouldHave(text("PDF download")).download();
           PDF pdf = new PDF(downloadedPDF);
           assertThat(pdf.author).contains("Sam Brannen");
        }
    // XLS
    @Test
    void xlsParsingTest () throws Exception {
        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))

       try (InputStream resourceAsStream = cl.getResourceAsStream("List 1.xlsx")) {
            XLS xls = new XLS(resourceAsStream);
           assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(0)).contains("Коммент");

       }
    }
}


