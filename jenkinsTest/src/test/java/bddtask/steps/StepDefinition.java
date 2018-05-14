package bddtask.steps;

import bddtask.model.LowerLevelStepsDefinition;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class StepDefinition {

    @Steps
    private LowerLevelStepsDefinition openWeatherMapSteps;

    @When("User sends a forecast request for '$cityName' city")
    public void userSendsRequestForCity(String cityName) {
        openWeatherMapSteps.getForecastForCity(cityName);
    }

    @When("User sends a forecast request for '$cityName' city and '$countryCode'")
    public void userSendsRequestForCityAndCountryCode(String cityName, String countryCode) {
        openWeatherMapSteps.getForecastForFiveDays(cityName, countryCode);
    }

    @Then("User gets response for '$cityName' city")
    public void userGetsResponseWithValidFields(String cityName) {
        openWeatherMapSteps.shouldReturn200Response();
        openWeatherMapSteps.shouldFindCityInResponse(cityName);
    }

    @Then("User gets 400 in response")
    public void userDoesntGetResponseForInvalidFields() {
        openWeatherMapSteps.shouldReturn400Response();
    }

    @Then("User gets 404 in response for '$cityName' city")
    public void userGetsResponseWithInvalidFields(String cityName) {
        openWeatherMapSteps.shouldReturn404Response();
        openWeatherMapSteps.shouldNotFindCityInResponse(cityName);
    }

    @Then("User sees city id '$cityId' in response")
    public void userSeesCityIdInResponse(String cityId) {
        openWeatherMapSteps.shouldContainValidItemInField("id", Integer.valueOf(cityId));
    }

    @Then("User gets 200 OK in response for '$cityName' and '$countryCode'")
    public void userGetsResponseForCityAndCountry(String cityName, String country) {
        openWeatherMapSteps.shouldReturn200Response();
        openWeatherMapSteps.shouldFindCityAndCountry(cityName, country);
    }

    @Then("User prints response body")
    public void userPrintsResponseBody() {
        openWeatherMapSteps.printResponseBody();
    }

    @When("User sends a forecast request with coordinates '$lon' and '$lat'")
    public void userSendsRequestByCoordinates(String lon, String lat) {
        openWeatherMapSteps.sendRequestByCoordinates(lon, lat);
    }
}
