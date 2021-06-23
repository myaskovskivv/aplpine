package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    TravelSteps travelSteps = new TravelSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран вид страхования \"(.+)\"$")
    public void stepSelectInsurance(String menuItem){
        mainSteps.selectMenuInsurance(menuItem);
    }

    @When("^нажата кнопка путешествие")
    public void stepSelectTravelBtn(){
        travelSteps.stepSendBtn();
    }
    @When("^нажата кнопка оформить")
    public void stepSelectInsBtn(){
        insuranceSteps.stepSendBtnIns();
    }

    @When("^заполняются поля ")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (field, value) -> sendAppSteps.stepFillField(field, value)
        );
    }


}
