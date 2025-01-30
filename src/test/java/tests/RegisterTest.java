package tests;

import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.codeborne.selenide.Selenide;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage;
import io.qameta.allure.*;

import static org.testng.Assert.assertTrue;
import static pages.RegisterPage.*;

public class RegisterTest extends BaseTest {


    //Тест проверка на открытие окна регистрации
    @Test(testName = "Тест проверка на открытие окна регистрации  ",
            description = "Тест проверка на открытие окна регистрации "
    )
    @Description("Тест проверка на открытие окна регистрации ")
    @Severity(SeverityLevel.NORMAL)
    @Epic("finalsurge - 1.0")
    @Feature("Register")
    @Story("Регистрация")
    @TmsLink("www.Jira.com/web-134")
    public void openRegisterWindow() {
        Selenide.open("https://log.finalsurge.com/register.cshtml?page_redirect=%2f");
        assertTrue(
                RegisterPage.checkTittle(),
                " элемент отсутствует ");
    }

    //Тест регистрации со всеми пустыми полями
    @Test(testName = "Тест регистрации со всеми пустыми полями ",
            description = "Тест регистрации со всеми пустыми полямии "
    )
    @Description("Тест регистрации со всеми пустыми полями")
    @Severity(SeverityLevel.NORMAL)
    @Epic("finalsurge - 1.0")
    @Feature("Register")
    @Story("Регистрация")
    @TmsLink("www.Jira.com/web-134")
    public void RegisterUserEmptyDate() {
        SoftAssert softAssert = new SoftAssert();
        Selenide.open("https://log.finalsurge.com/register.cshtml?page_redirect=%2f");
        RegisterPage.registerUser("", "", "", "", "");
        RegisterPage.clickCreate();
        softAssert.assertEquals(RegisterPage.registerUserError(errorNameField, "This field is required."),
                true);
        softAssert.assertEquals(RegisterPage.registerUserError(errorLastnameField, "This field is required."),
                true);
        softAssert.assertEquals(RegisterPage.registerUserError(errorEmailField, "This field is required."),
                true);
        softAssert.assertEquals(RegisterPage.registerUserError(errorPasswordField, "This field is required."),
                true);
        softAssert.assertEquals(RegisterPage.registerUserError(errorRetypePasswordField, "This field is required."),
                true);
        softAssert.assertAll();

    }

    //Тест регистрации с некорректной почтой
    @Test(testName = "Тест регистрации с некорректной почтой ",
            description = "Тест регистрации с некорректной почтой "
    )
    @Description("Тест регистрации с некорректной почтой ")
    @Severity(SeverityLevel.NORMAL)
    @Epic("finalsurge - 1.0")
    @Feature("Register")
    @Story("Регистрация")
    @TmsLink("www.Jira.com/web-134")
    public void RegisterInvalidEmail() {
        Selenide.open("https://log.finalsurge.com/register.cshtml?page_redirect=%2f");
        RegisterPage.registerUser("test", "test", "test", "4Vg#hS.gSf7H#SS", "4Vg#hS.gSf7H#SS");
        RegisterPage.clickCreate();
        assertTrue(registerUserError(errorEmailField, "Please enter a valid email address."));
    }

    //Тест регистрации с некорректным паролем
    @Test(testName = "Тест регистрации с некорректным паролем",
            description = "Тест регистрации с некорректным паролем "
    )
    @Description("Тест регистрации с некорректным паролем ")
    @Severity(SeverityLevel.NORMAL)
    @Epic("finalsurge - 1.0")
    @Feature("Register")
    @Story("Регистрация")
    @TmsLink("www.Jira.com/web-134")
    public void RegisterInvalidPassword() {
        Selenide.open("https://log.finalsurge.com/register.cshtml?page_redirect=%2f");
        RegisterPage.registerUser("test", "test", "test44@test.com", "123", "123");
        RegisterPage.clickCreate();
        assertTrue(registerUserError(errorTotal, "Error: *Please enter a Password value with at least one number, lower-case letter," +
                " and upper-case letter between 7 and 15 characters in length."));
    }

    //Тест регистрации с несовпадающими  паролями
    @Test(testName = "Тест регистрации с несовпадающими  паролями ",
            description = "Тест регистрации с несовпадающими  паролями "
    )
    @Description("Тест регистрации с несовпадающими  паролями  ")
    @Severity(SeverityLevel.NORMAL)
    @Epic("finalsurge - 1.0")
    @Feature("Register")
    @Story("Регистрация")
    @TmsLink("www.Jira.com/web-134")
    public void RegisterNoMatchPassword() {
        Selenide.open("https://log.finalsurge.com/register.cshtml?page_redirect=%2f");
        RegisterPage.registerUser("test", "test", "test44@test.com", "4Vg#hS.gSf7H#SS", "123");
        RegisterPage.clickCreate();
        assertTrue(registerUserError(errorTotal, "Error: The passwords you entered did not match."));
    }

    // Тест проверка прогресс бара уровня сложности пароля - легкий
    @Test(testName = " Тест проверка прогресс бара уровня сложности пароля - легкий ",
            description = "Тест проверка прогресс бара уровня сложности пароля - легкий "
    )
    @Description("Тест проверка прогресс бара уровня сложности пароля - легкий ")
    @Severity(SeverityLevel.NORMAL)
    @Epic("finalsurge - 1.0")
    @Feature("Register")
    @Story("Регистрация")
    @TmsLink("www.Jira.com/web-134")
    public void RegisterProgressPasswordWeak() {
        Selenide.open("https://log.finalsurge.com/register.cshtml?page_redirect=%2f");
        RegisterPage.registerUser("test", "test", "test44@test.com", "435432", "435432");
        Configuration.timeout = 4000;
        assertTrue(checkLevelPass(progressBarPasswordLevel, "WEAK"));
    }

    //Тест проверка прогресс бара уровня сложности пароля - средний
    @Test(testName = "Тест проверка прогресс бара уровня сложности пароля - средний  ",
            description = "Тест проверка прогресс бара уровня сложности пароля - средний "
    )
    @Description("Тест проверка прогресс бара уровня сложности пароля - средний ")
    @Severity(SeverityLevel.NORMAL)
    @Epic("finalsurge - 1.0")
    @Feature("Register")
    @Story("Регистрация")
    @TmsLink("www.Jira.com/web-134")
    public void RegisterProgressPasswordMedium() {
        Selenide.open("https://log.finalsurge.com/register.cshtml?page_redirect=%2f");
        RegisterPage.registerUser("test", "test", "test44@test.com", "4324gdsgfdgfd", "435432");
        Configuration.timeout = 4000;
        assertTrue(checkLevelPass(progressBarPasswordLevel, "MEDIUM"));
    }

    //Тест проверка прогресс бара уровня сложности пароля - сложный
    @Test(testName = "Тест проверка прогресс бара уровня сложности пароля - сложный  ",
            description = "Тест проверка прогресс бара уровня сложности пароля - сложный"
    )
    @Description("Тест проверка прогресс бара уровня сложности пароля - сложный  ")
    @Severity(SeverityLevel.NORMAL)
    @Epic("finalsurge - 1.0")
    @Feature("Register")
    @Story("Регистрация")
    @TmsLink("www.Jira.com/web-134")
    public void RegisterProgressPasswordStrong() {
        Selenide.open("https://log.finalsurge.com/register.cshtml?page_redirect=%2f");
        RegisterPage.registerUser("test", "test", "test44@test.com", "4324gdsgfdgfd5@#!@$!#", "435432");
        assertTrue(checkLevelPass(progressBarPasswordLevel, "STRONG"));
    }


}




