package HelpDesk;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HelpDeskTest extends BaseSeleniumTest {

    @Test
    public void createTicket() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String title = System.getProperty("title");
        String body = System.getProperty("body");
        String email = System.getProperty("email");
        MainPage mainPage = new MainPage();
        mainPage.createTicket(title, body, email);
        TicketPage ticketPage = new TicketPage();
        Assertions.assertEquals(ticketPage.getTextElement(ticketPage.emailTicket), email);
        Assertions.assertEquals(ticketPage.getTextElement(ticketPage.descriptionTicket), body);
    }

    @Test
    public void createTicket1(){
        String title = ConfigProvider.TITLE;
        String body = ConfigProvider.BODY;
        String email = ConfigProvider.EMAIL;
        MainPage1 mainPage1 = new MainPage1();
        mainPage1.createTicket(title, body, email);
        TicketPage ticketPage = new TicketPage();
        Assertions.assertEquals(ticketPage.getTextElement(ticketPage.emailTicket), email);
        Assertions.assertEquals(ticketPage.getTextElement(ticketPage.descriptionTicket), body);
    }

    @Test
    public void checkNonExistentTicket(){
        String ticketId = Integer.toString(ConfigProvider.TICKETID);
        String ticketEmail = ConfigProvider.EMAIL;
        MainPage1 mainPage1 = new MainPage1();
        mainPage1.checkTicket(ticketId, ticketEmail);
        ResultSearchTicketPage resultSearchTicketPage = new ResultSearchTicketPage();
        String errorText = resultSearchTicketPage.getTextonPage();
        Assertions.assertEquals("Ошибка: Неверный ID тикета или адрес электронной почты, Пожалуйста попробуйте ещё.", errorText);
    }
}
