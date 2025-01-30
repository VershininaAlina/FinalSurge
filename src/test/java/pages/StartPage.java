package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;


public class StartPage {
    public static SelenideElement userInfo = $(".user-info");

    @Step("Проверка присутствия юзер инфо")
    public static boolean checkUserInfo() {
        return userInfo.exists();
    }

}
