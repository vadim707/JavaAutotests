package HelpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    private final String URL = "https://ft-sandbox.workbench.lanit.ru";

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

    public MainPage(){
        driver.get(URL);
        PageFactory.initElements(driver, this);
    }

    public MainPage createTicket(String titleValue, String bodyValue, String emailValue){
        queueList.click();
        queueValue.click();
        title.sendKeys(titleValue);
        body.sendKeys(bodyValue);
        dateField.click();
        dateValue.click();
        email.sendKeys(emailValue);
        return this;
    }
}
