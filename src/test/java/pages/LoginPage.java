package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BaseTest {
    public static SelenideElement EmailField = $("#login_name");
    public static SelenideElement PasswordField = $("#login_password");
    public static SelenideElement loginButton = $(".btn.btn-beoro-1");

    @Step("Авторизация  пользователя ")
    public static void loginUser(String email, String password) {
        EmailField.setValue(email);
        PasswordField.setValue(password);
        loginButton.click();
    }
}
