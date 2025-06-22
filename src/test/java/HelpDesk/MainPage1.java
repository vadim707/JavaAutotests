package HelpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage1 extends BaseSeleniumPage {

    @FindBy(xpath = "//select[@id = 'id_queue']")
    private WebElement queueList;

    @FindBy(xpath = "//select[@id = 'id_queue']//option[@value = '1']")
    private WebElement queueValue;

    @FindBy(id = "id_title")
    private WebElement title;

    @FindBy(id = "id_body")
    private WebElement body;

    @FindBy(id = "id_due_date")
    private WebElement dateField;

    @FindBy(xpath = "//table[@class = 'ui-datepicker-calendar']//a[text() = '23']")
    private WebElement dateValue;

    @FindBy(id = "id_submitter_email")
    private WebElement email;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement sendticket;

    @FindBy(xpath = "//input[@name = 'ticket']")
    private WebElement ticketId;

    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement ticketEmail;

    @FindBy(xpath = "//input[@value = 'Просмотреть тикет']")
    private WebElement showTicket;

    @FindBy(xpath = "//form")
    private WebElement errorText;


    public MainPage1(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public MainPage1 createTicket(String titleValue, String bodyValue, String emailValue){
        queueList.click();
        queueValue.click();
        title.sendKeys(titleValue);
        body.sendKeys(bodyValue);
        dateField.click();
        dateValue.click();
        email.sendKeys(emailValue);
        sendticket.click();
        return this;
    }

    public MainPage1 checkTicket(String ticketIdValue, String ticketEmailValue){
        ticketId.sendKeys(ticketIdValue);
        ticketEmail.sendKeys(ticketEmailValue);
        showTicket.click();
        return this;
    }
}

