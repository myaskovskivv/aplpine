package steps;

import pages.InsurancePage;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceSteps //extends BaseSteps
{

    //@Step("кнопка оформить на странице Страхование путешестивенников {0}")
    public void stepSendBtnIns(){
        new InsurancePage().sendButton.click();
    }
}
