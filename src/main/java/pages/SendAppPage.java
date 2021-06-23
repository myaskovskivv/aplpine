package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class SendAppPage {
    WebDriver driver;
    @FindBy(xpath = "//*[contains(@class,'left-side')]//*[contains(text(),'Страхование путешественников')]")
    public WebElement title;

    @FindBy(xpath = "//INPUT[@id='surname_vzr_ins_0']")
    WebElement surname_vzr;

    @FindBy(xpath = "//INPUT[@id='name_vzr_ins_0']")
    WebElement name_vzr;

    @FindBy(xpath = "//INPUT[@id='person_lastName']")
    WebElement person_lastName;

    @FindBy(xpath = "//INPUT[@id='person_firstName']")
    WebElement person_firstName;

    @FindBy(xpath = "//INPUT[@id='person_middleName']")
    WebElement person_middleName;

    @FindBy(xpath = "//INPUT[@id='passportSeries']")
    WebElement passportSeries;

    @FindBy(xpath = "//INPUT[@id='passportNumber']")
    WebElement passportNumber;

    @FindBy(xpath = "//INPUT[@id='documentIssue']")
    WebElement documentIssue;

    @FindBy(xpath = "//INPUT[@id='birthDate_vzr_ins_0']")
    WebElement birthDate_vzr;

    @FindBy(xpath = "//INPUT[@id='person_birthDate']")
    WebElement person_birthDate;

    @FindBy(xpath = "//INPUT[@id='documentDate']")
    WebElement documentDate;

    //кнопка Продолжить на странице оформления заявки
    @FindBy(xpath = "//*[contains(@class,'btn-primary')]")
    public WebElement sendButton;

    public SendAppPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
        this.driver = BaseSteps.getDriver();
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия":
                fillField(surname_vzr, value);
                break;
            case  "Имя":
                fillField(name_vzr, value);
                break;
            case  "Данные страхователя: Фамилия":
                fillField(person_lastName, value);
                break;
            case  "Данные страхователя: Имя":
                fillField(person_firstName, value);
                break;
            case  "Данные страхователя: Отчество":
                fillField(person_middleName, value);
                break;
            case  "серия":
                fillField(passportSeries, value);
                break;
            case  "номер":
                fillField(passportNumber, value);
                break;
            case  "кем выдан":
                fillField(documentIssue, value);
                break;
            case  "Дата рождения застрахованных":
                fillField(birthDate_vzr, value);
                break;
            case  "Данные страхователя: Дата рождения":
                fillField(person_birthDate, value);
                break;
            case  "дата выдачи":
                fillField(documentDate, value);
                break;

            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public void  fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void checkFieldErrorMessage() {
        String xpath = "(//SPAN[@class='invalid-validate form-control__message'][text()='Поле не заполнено.'])[1]";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        Assert.assertEquals("Поле не заполнено.", actualValue);
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия":
                return surname_vzr.getAttribute("value");
            case "Имя":
                return name_vzr.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }
}
