package steps;

import pages.MainPage;
import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class SendAppSteps extends BaseSteps{
    //@Step("заполнить поля {0} заявки значением {1} ")
    public void stepFillField(String field, String value) {
      new SendAppPage(driver).fillField(field, value);
    }

    //@Step("заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields) {
       // fields.forEach((key, value) -> stepFillField(key, value));
        fields.forEach(this::stepFillField);
    }

}
