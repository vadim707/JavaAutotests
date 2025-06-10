package AdvantshopHelp;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/**
* Страница базы знаний сайта Advantshop.net
*/
    public class MainPage {
        private final SelenideElement textBoxInput = $x("//input[@type='search']");

    /**
     * Открывается страница сайта по заданному адресу
     * @param url адрес сайта
     */
    public MainPage(String url){
        Selenide.open(url);
    }

    /**
     * Выполняется поиск статьи по названию и нажимается Enter
     * @param searchString поисковая строка
     */
    public void Search(String searchString){
        textBoxInput.sendKeys(searchString + Keys.ENTER);
    }
}
