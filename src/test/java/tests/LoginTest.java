package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import pages.StartPage;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    //Тест проверка корректной авториазции
    @Test(testName = "Тест проверка корректной авториазции ",
            description = "Тест проверка корректной авториазции "
    )
    @Description("Тест проверка корректной Авторизации ")
    @Severity(SeverityLevel.NORMAL)
    @Epic("finalsurge. - 1.0")
    @Feature("Login")
    @Story("Авторизация ")
    @TmsLink("www.Jira.com/web-134")
    public void openRegisterWindow() {
        Selenide.open("https://log.finalsurge.com/login.cshtml");
        LoginPage.loginUser("test45@test.com", "#vXxeT2Y56ghefa");
        assertTrue(
                StartPage.checkUserInfo(),
                " элемент userinfo отсутствует ");
    }
}
