package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

abstract public class BaseTest {
    public static void SetUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @BeforeAll
    public static void init(){
        SetUp();
    }

    @AfterAll
    public static void TearDown(){
        Selenide.closeWebDriver();
    }
}
