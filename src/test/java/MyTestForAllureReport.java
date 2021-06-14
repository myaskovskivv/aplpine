import org.junit.Ignore;
import org.junit.Test;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class MyTestForAllureReport extends BaseSteps {
    @Test
    @Title("Страхование Путешествий")
    public void testInsurance() {
        driver.get(baseUrl);
        MainSteps mainSteps = new MainSteps();
        MainPage mainPage = new MainPage(driver);
       // TravelSteps travelSteps = new TravelSteps();
       // InsuranceSteps insuranceSteps = new InsuranceSteps();
       // SendAppSteps sendAppSteps = new SendAppSteps();

        HashMap<String, String> testDate = new HashMap<>();
        testDate.put("Фамилия", "Иванов");
        testDate.put("Имя", "Иван");
        //если запускать метод главная страница на прямую, то работает.
        //mainPage.selectMainMenu("Страхование");
        //если запускать через step то падает с ошибкой
        //java.lang.ClassNotFoundException: javax.xml.bind.ValidationEventLocator
        //at MyTestForAllureReport.testInsurance(MyTestForAllureReport.java:25)
        //если закомментировать аннотацию @Step в классе mainSteps, то работает.
        mainSteps.stepSelectMainMenu("Страхование");
        //mainSteps.selectMenuInsurance("Путешествия");

        //8travelSteps.stepSendBtn();
       // insuranceSteps.stepSendBtnIns();
       // sendAppSteps.stepFillFields(testDate);

    }
}
