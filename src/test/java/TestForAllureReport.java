
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class TestForAllureReport extends BaseSteps {
    @Test
    @Title("Страхование Путешествий")
    public void testInsurance() {
        driver.get(baseUrl);
     // закрываем всплывающее окно предупреждение про куки
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement closeBtn = driver.findElement(By.xpath("//*[text()='Закрыть']"));
        wait.until(ExpectedConditions.visibilityOf(closeBtn)).click();

        MainSteps mainSteps = new MainSteps();
        TravelSteps travelSteps = new TravelSteps();
        InsuranceSteps insuranceSteps = new InsuranceSteps();
        SendAppSteps sendAppSteps = new SendAppSteps();

        HashMap<String, String> testDate = new HashMap<>();
        testDate.put("Фамилия", "Иванов");
        testDate.put("Имя", "Иван");
        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.selectMenuInsurance("Путешествия");

        travelSteps.stepSendBtn();
        insuranceSteps.stepSendBtnIns();
        sendAppSteps.stepFillFields(testDate);

    }
}
