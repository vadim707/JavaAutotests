package HelpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ResultSearchTicketPage extends BaseSeleniumPage {
    @FindBy(xpath = "//p")
    private WebElement errorText;

    public ResultSearchTicketPage(){
        PageFactory.initElements(driver, this);
    }

    public String getTextonPage(){
        return errorText.getText();
    }
}
