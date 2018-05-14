package bddtask.model;

import bddtask.core.reporter.TestReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static bddtask.model.constants.TestData.*;
import static bddtask.model.templates.URL.*;
import static net.serenitybdd.rest.SerenityRest.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class LowerLevelStepsDefinition extends ScenarioSteps {
    private Response response;

    @Step
    public void getForecastForCity(String cityName) {
        response = when().get(String.format(FORECAST_FOR_CITY, cityName));
    }

    @Step
    public void getForecastForFiveDays(String cityName, String countryCode) {
        response = when().get(String.format(FORECAST_FOR_FIVE_DAYS, cityName, countryCode));
    }

    @Step
    public void sendRequestByCoordinates(String lon, String lat) {
        response = when().get(String.format(FORECAST_BY_COORDS, lat, lon));
    }

    @Step
    public void shouldFindCityInResponse(String cityName) {
        shouldContainValidItemInField("name", cityName);
    }

    @Step
    public void shouldNotFindCityInResponse(String cityName) {
        shouldNotContainInvalidItemInField("name", cityName);
    }

    @Step
    private void shouldContainValidItemInField(String field, String item) {
        response.then().body(field, is(item));
    }

    @Step
    private void shouldNotContainInvalidItemInField(String field, String item) {
        response.then().body(field, not(item));
    }

    @Step
    public void shouldContainValidItemInField(String field, int item) {
        response.then().body(field, is(item));
    }

    @Step
    public void shouldReturn200Response() {
        response.then().contentType(ContentType.JSON).statusCode(200);
    }

    @Step
    public void shouldReturn400Response() {
        response.then().contentType(ContentType.JSON).statusCode(400);
    }

    @Step
    public void shouldReturn404Response() {
        response.then().contentType(ContentType.JSON).statusCode(404);
    }

    @Step
    public void printResponseBody() {
        TestReporter.report(response.getBody().prettyPrint());
    }

    @Step
    public void shouldFindCityAndCountry(String cityName, String country) {
        response.then().body(LOCATION_NAME_FIELD, is(cityName));
        response.then().body(LOCATION_COUNTRY_FIELD, is(country));
    }
}
