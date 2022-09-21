package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void configuration () {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest(){
        open("/automation-practice-form");

        $("#firstName").setValue("Aleksandr");
        $("#lastName").setValue("Apoltsev");
        $("#userEmail").setValue("apoltsev@mail.ru");
        $("#userNumber").setValue("9876543210");
        $("#currentAddress").setValue("City Street 123456");
        $("#subjectsInput").setValue("English").pressEnter();
        $("#uploadPicture").uploadFromClasspath("1.jpg");

        $(byText("Male")).click();
        $(byText("Sports")).click();
        $(byText("Reading")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--008").click();

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Aleksandr Apoltsev"),
                text("apoltsev@mail.ru"),
                text("Male"),
                text("9876543210"),
                text("08 June,1992"),
                text("English"),
                text("Sports"),
                text("Reading"),
                text("1.jpg"),
                text("City Street 123456"),
                text("NCR Delhi"));

    }
}
