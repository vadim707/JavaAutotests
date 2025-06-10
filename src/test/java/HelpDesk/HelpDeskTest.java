package HelpDesk;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.Test;

public class HelpDeskTest extends BaseSeleniumTest {

    @Test
    public void checkTicket(){
        String title = "Vadim Test";
        String body = "Тестовое сообщение в тех поддержку";
        String email = "test@mail.ru";
        MainPage mainPage = new MainPage();
        mainPage.createTicket(title, body, email);
    }
}
