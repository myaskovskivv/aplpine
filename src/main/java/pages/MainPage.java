package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class MainPage {

    //верхнее меню
    @FindBy(xpath = "//*[contains(@class,'kitt-top-menu__list_icons')]")
    WebElement mainMenu;
    //блок меню с путешествием
    @FindBy(xpath = "(//DIV[@class='kitt-top-menu__dropdown kitt-top-menu__dropdown_icons'])[8]")
    WebElement subMenu;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
       // закрываем всплывающее окно предупреждение про куки
       // Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        // WebElement closeBtn = driver.findElement(By.xpath("//*[text()='Закрыть']"));
        // wait.until(ExpectedConditions.visibilityOf(closeBtn)).click();
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath(".//li/*[(text()='"+menuItem+"')]")).click();
    }
    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath(".//li/*[(text()='"+menuItem+"')]")).click();
    }

}
