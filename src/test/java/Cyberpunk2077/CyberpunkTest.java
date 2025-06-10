package Cyberpunk2077;

import core.BaseTest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CyberpunkTest extends BaseTest {
    private static final String URl = "https://www.cyberpunk.net/ru/ru/";

    @Test
    public void checkAttributeHashMap(){
        CyberpunkMainPage cyberpunkMainPage = new CyberpunkMainPage(URl);

        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put(CyberpunkMainPage.Word, "Cyberpunk");
        expectedMap.put(CyberpunkMainPage.Year, 2077);
        expectedMap.put(CyberpunkMainPage.Future, true);

        Map<String, Object> actualMap = cyberpunkMainPage.getMap();

        Assertions.assertEquals(expectedMap, actualMap);

    }

    @Test
    public void checkAttributeClass(){
        CyberpunkMainPage cyberpunkMainPage = new CyberpunkMainPage(URl);
        CyberpunkforClass expectedMap = new CyberpunkforClass("Cyberpunk", 2077, true);
        CyberpunkforClass actualMap = new CyberpunkforClass(cyberpunkMainPage.getWord(), cyberpunkMainPage.getNumber(),
                cyberpunkMainPage.trueFuture());

        //1й способ сравнение классов через EqualsBuilder
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(expectedMap, actualMap));

        //2й способ сравнения классов явно указывая значениея из них
        Assertions.assertEquals(expectedMap.getWord(), actualMap.getWord());
        Assertions.assertEquals(expectedMap.getYear(), actualMap.getYear());
        Assertions.assertEquals(expectedMap.isFuture(), actualMap.isFuture());
    }
}
