package steps;

//import pages.MainPage;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {



    @Step //("выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem){
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void selectMenuInsurance(String menuItem){
        new MainPage().selectSubMenu(menuItem);
    }
}
