package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class InsurancePage {

    //кнопка оформить  на странице Страхование путешестивенников
    @FindBy(xpath = "//*[@class='btn btn-primary btn-large'][text()='Оформить']")
    public WebElement sendButton;

    public InsurancePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendButton));
    }

}
