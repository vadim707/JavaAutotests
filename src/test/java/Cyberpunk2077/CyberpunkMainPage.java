package Cyberpunk2077;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.$$x;

public class CyberpunkMainPage {
    private final SelenideElement cyberpunkTitle = Selenide.element(By.className("header__title"));
    private final SelenideElement cyberpunkNews = Selenide.element(By.className("l-newsletter__text"));
    private final ElementsCollection introTitle = $$x("//h2");

    public static String Word = "Слово";
    public static String Year = "Год";
    public static String Future = "Есть слово Будущее ?";

    public Map<String, Object> getMap(){
        Map<String, Object> attributes = new HashMap<>();
        attributes.put(Word, getWord());
        attributes.put(Year, getNumber());
        attributes.put(Future, trueFuture());
        return attributes;
    }

    public CyberpunkMainPage(String url) {
        Selenide.open(url);
        Selenide.element(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
    }

    public String getWord(){
        return cyberpunkTitle.getText().equals("ПОЛНОЕ ПОГРУЖЕНИЕ В CYBERPUNK 2077") ? "Cyberpunk" : "Не найдено";
    }

    public int getNumber(){
       return Integer.parseInt(cyberpunkNews.getText().replaceAll("\\D+", ""));
    }

    public boolean trueFuture(){
        return introTitle.first().getText().split(" ")[4].equals("БУДУЩЕЕ");
    }
}
