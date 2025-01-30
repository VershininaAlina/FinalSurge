package tests;

import io.qameta.allure.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.RegisterPage;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import utils.AllureUtils;


import static java.lang.module.Configuration.*;



public class BaseTest {

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        Configuration.baseUrl = "https://log.finalsurge.com/register.cshtml?page_redirect=%2f";
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        if (browser.equalsIgnoreCase("firefox")) {
            Configuration.browser = "firefox";
        }
        if (browser.equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
        }
    }


}
