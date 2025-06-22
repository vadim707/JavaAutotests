package HelpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketPage extends BaseSeleniumPage{
    @FindBy(xpath = "//tr[3]//td")
    protected WebElement emailTicket;

    @FindBy(xpath = "//tr[6]//td")
    protected WebElement descriptionTicket;

    public TicketPage(){
        PageFactory.initElements(driver, this);
    }

    public String getTextElement(WebElement element){
        if (element == emailTicket)
            return emailTicket.getText();
        if (element == descriptionTicket)
            return descriptionTicket.getText();
        return null;
    }
}
