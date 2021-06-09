import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.InsurancePage;
import pages.MainPage;
import pages.SendAppPage;
import pages.TravelPage;

import static org.junit.Assert.assertEquals;

public class MyRefactoringTest extends BaseTest {
//git // git
    @Test
    public void newInsTest() {
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);

        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Путешествия");

        new TravelPage(driver).sendButton.click();
        new InsurancePage(driver).sendButton.click();

        SendAppPage sendAppPage = new SendAppPage(driver);

        String actualTitle = sendAppPage.title.getText();
        String expectedTitle = "Страхование путешественников";
        Assert.assertEquals(actualTitle,expectedTitle);
        Assert.assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                        actualTitle, expectedTitle), actualTitle.contains(expectedTitle));

        sendAppPage.fillField("Фамилия", "Иванов");
        sendAppPage.fillField("Имя", "Иван");
        sendAppPage.fillField("Данные страхователя: Фамилия", "Петров");
        sendAppPage.fillField("Данные страхователя: Имя", "Петр");
        sendAppPage.fillField("Данные страхователя: Отчество", "Петрович");
        sendAppPage.fillField("серия", "1111");
        sendAppPage.fillField("номер", "222222");
        sendAppPage.fillField("кем выдан", "ОВД Лианозово");
        sendAppPage.fillField("Дата рождения застрахованных", "02.06.1977");
        sendAppPage.fillField("Данные страхователя: Дата рождения", "03.06.2003");
        sendAppPage.fillField("дата выдачи", "03.06.2018");

        assertEquals("Иванов", sendAppPage.getFillField("Фамилия"));
        assertEquals("Иван", sendAppPage.getFillField("Имя"));

        sendAppPage.sendButton.click();

        sendAppPage.checkFieldErrorMessage();
    }
}
