package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.qameta.allure.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class RegisterPage {

    public static SelenideElement nameField = $("#create_first");
    public static SelenideElement lastnameField = $("#create_last");
    public static SelenideElement emailField = $("#create_email");
    public static SelenideElement passwordField = $("#password_meter");
    public static SelenideElement retypePasswordField = $("#create_passwordmatch");

    public static SelenideElement createButton = $(".btn.btn-beoro-1");

    public static SelenideElement errorNameField = $x("//*[@for=\"create_first\"][2]");
    public static SelenideElement errorLastnameField = $x("//*[@for=\"create_email\"][2]");
    public static SelenideElement errorEmailField = $x("//*[@for=\"create_email\"][2]");
    public static SelenideElement errorPasswordField = $x("//*[@for=\"password_meter\"]");
    public static SelenideElement errorRetypePasswordField = $x("//*[@for=\"create_passwordmatch\"][2]");
    public static SelenideElement errorTotal = $(".alert.alert-error");

    public static SelenideElement tittleRegister = $(".heading_main");
    public static SelenideElement progressBarPasswordLevel = $x("//*[@id=\"pwdMeter\"]/span");


    @Step("Пользователь заполняет все поля регистрации ")
    public static void registerUser(String name, String lastname, String email, String password1, String password2) {
        nameField.setValue(name);
        lastnameField.setValue(lastname);
        emailField.setValue(email);
        passwordField.setValue(password1);
        retypePasswordField.setValue(password2);
    }

    @Step("Пользователь нажимает кнопку регистрацию ")
    public static void clickCreate() {
        createButton.click();
    }

    @Step("Проверка заголовка в окне регистрации")
    public static Boolean checkTittle() {
        return tittleRegister.getText().equals("Create a New Account for Free");
    }


    @Step("Пользователь проверяет текст ошибки ")
    public static boolean registerUserError(SelenideElement Element, String error) {
        return Element.getText().equals(error);

    }

    @Step("Пользователь проверяет уровень защиты пароля")
    public static boolean checkLevelPass(SelenideElement Element, String level) {
        return Element.shouldBe(visible).getText().equals(level);
    }


}