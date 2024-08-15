package Selenide;

import com.google.gson.annotations.SerializedName;

// библиотека GSON  - второй способ (связан с Классом "public class FilesParsingTest" с  "библиотека GSON  - второй способ" - строка 108 кода)

public class FileParsingTestJSonGlossary {
    public String title;
    @SerializedName("GlossDiv")
    public GlossDiv glossDiv;

    public static class GlossDiv {
        public String title;
        public Boolean flaq;
    }
}
