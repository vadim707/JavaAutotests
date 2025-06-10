package Wikipedia;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class WikiTest extends BaseTest{
    private static final String URL = "https://ru.wikipedia.org/wiki/Java";

    @Test
    public void openURL(){
        Selenide.open(URL);
        ElementsCollection hrefs = $$x("//div[@id='toc']//a[@href]");
        List<String> links = new ArrayList<>();
        //вытаскиваем из коллекции элементы с атрибутом href
        //1
        for (int i=0; i<hrefs.size(); i++){
            links.add(hrefs.get(i).getAttribute("href"));
        }
        //2
        for (SelenideElement element : hrefs){
            links.add(element.getAttribute("href"));
        }
        //3
        hrefs.stream().forEach(x->links.add(x.getAttribute("href")));


        //1 открываем ссылки в коллекции
        links.forEach(Selenide::open); //через ссылку на метод open
        //2 сравниваем ссылку из коллекции и из браузера
        for (int i=0; i<links.size(); i++){
            String listUrl = links.get(i);
            Selenide.open(listUrl);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            Assertions.assertEquals(currentUrl, listUrl);
        }
        //3 рандомно открываем ссылки и удаляем из коллекции уже открытые ссылки
        Random random = new Random();
        while (links.size() > 0){
            int randomNumber = random.nextInt(links.size());
            Selenide.open(links.get(randomNumber));
            links.remove(WebDriverRunner.getWebDriver().getCurrentUrl());
        }
        //получаем длину(кол-во символов) ссылок
        List <Integer> linksLength = hrefs.stream().map(x->x.getAttribute("href").length()).collect(Collectors.toList());
        int a = 0;
    }
}
