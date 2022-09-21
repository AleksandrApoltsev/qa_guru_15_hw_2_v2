package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.desktop.OpenFilesEvent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {

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

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        //$("#submit").click();


    }







}
