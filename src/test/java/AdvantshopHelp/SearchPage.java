package AdvantshopHelp;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {
    private final ElementsCollection articleClasses = $$x("//a[contains(@class, 'help-link')]");

    /**
     * Возвращает href из первой статьи
     * @return
     */
    public String getHrefFromFirstArticle(){
        return articleClasses.first().getAttribute("href");
    }
}
