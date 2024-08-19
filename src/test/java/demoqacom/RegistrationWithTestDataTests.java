package demoqacom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithTestDataTests extends TestData {

//    String  userName = "Alex",
//            lastName = "Egorov",
//            userEmail = "alex@egorov.com"; // можно здесь указать переменные - 1-й способ - он мне нравится больше других (ещё способ - вынести в отдельный Класс (здесь он реализован - в классе "TestData"))

    //    String userName = "Alex";
    //    String lastName = "Egorov";
    //    String userEmail = "alex@egorov.com";   // можно здесь указать переменные - 2-й способ


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager"; // страница не успевает прогрузиться и поэтому падает по таймауту  - лечится ТАК !!!


    }

    @Test
    void successfulRegistrationTest() {
//        String userName = "Alex";
//        String lastName = "Egorov";
//        String userEmail = "alex@egorov.com";   // можно здесь указать переменные - 3-й способ (т.е. данные пишутся не до, а после Метода)

        open(("/automation-practice-form"));
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Other")).click(); // best
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("sampleFile1.jpeg");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text(lastName),
                text(userEmail), text("1234567890"));
    }
}
