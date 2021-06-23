package steps;


import pages.TravelPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelSteps //extends BaseSteps
{

    //@Step("нажать кнопку отправить заявку {0}")
    public void stepSendBtn(){
        new TravelPage().sendButton.click();
    }
}
