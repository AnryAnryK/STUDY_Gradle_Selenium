package Selenide;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


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
           assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).contains("Коммент");

       }
    }
    @Test
    // CSV
    void csvParsingTest () throws Exception {
        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))

        try (InputStream resourceAsStream = cl.getResourceAsStream("csvParsingTest.csv");
            CSVReader csv = new CSVReader(new InputStreamReader(resourceAsStream))
        ) {
            List<String[]> content = csv.readAll();

            assertThat(content.get(0)[1]).contains("Lesson");
        }

    }
    @Test
        // ZIP file
    void zipParsingTest () throws Exception {
        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))

        try (InputStream resourceAsStream = cl.getResourceAsStream("zip1a.zip");
             ZipInputStream zis = new ZipInputStream(resourceAsStream);

        ) {
            ZipEntry entry;
while ((entry = zis.getNextEntry()) != null) {
    assertThat( entry.getName()).contains("zip1.txt");

            }
        }
    }


    @Test
        // библиотека GSON  - первый способ
    void gsonParsingTest () throws Exception {
        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))

        Gson gson = new Gson();

        try (InputStream resourceAsStream = cl.getResourceAsStream("glossary.json");
            InputStreamReader reader = new InputStreamReader(resourceAsStream)

        )  {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            assertThat(jsonObject.get("title").getAsString()).isEqualTo("example glossary"); // так можно проверить 1-ю строку в json-файле
            assertThat(jsonObject.get("GlossDiv").getAsJsonObject().get("title").getAsString()).isEqualTo("S"); // так можно проверить 2-ю строку в json-файле... и т.д.
            assertThat(jsonObject.get("GlossDiv").getAsJsonObject().get("flaq").getAsBoolean()).isTrue(); // так можно проверить 3-ю строку в json-файле... и т.д.
        }
    }

    // библиотека GSON  - второй способ (связан с Классом "public class FileParsingTestJSonGlossary")
@Test
    void gsonParsingImprovedTest () throws Exception {
        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!
        Configuration.browserSize = "1920x1080";  // раскрыть экран на всю ))

        Gson gson = new Gson();

        try (InputStream resourceAsStream = cl.getResourceAsStream("glossary.json");
             InputStreamReader reader = new InputStreamReader(resourceAsStream)

        )  {
            FileParsingTestJSonGlossary jsonObject = gson.fromJson(reader, FileParsingTestJSonGlossary.class);
            assertThat(jsonObject.title).isEqualTo("example glossary");
            assertThat(jsonObject.glossDiv.title).isEqualTo("S");
            assertThat(jsonObject.glossDiv.flaq).isTrue();
        }
    }
}


