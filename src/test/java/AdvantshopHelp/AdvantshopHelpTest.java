package AdvantshopHelp;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdvantshopHelpTest extends BaseTest {

    private final static String BASE_URL = "https://www.advantshop.net/help";
    private final static String SEARCH_STRING = "Подключение складов";

    @Test
    public void checkHrefArticle(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.Search(SEARCH_STRING);
        SearchPage searchPage = new SearchPage();
        String href = searchPage.getHrefFromFirstArticle();
        Assertions.assertTrue(href.contains("pokupka-na-markete"));
    }
}
