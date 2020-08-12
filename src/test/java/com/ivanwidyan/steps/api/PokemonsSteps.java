package com.ivanwidyan.steps.api;

import com.ivanwidyan.module.api.UsersController;
import com.ivanwidyan.module.api.data.UsersData;
import com.ivanwidyan.module.api.response.createuser.CreateUserResponse;
import com.ivanwidyan.module.api.response.get10_pokemons.PokemonsResponse;
import com.ivanwidyan.module.api.response.getuser.GetSingleUserResponse;
import com.ivanwidyan.module.api.response.updateuser.UpdateUserResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class PokemonsSteps extends ScenarioSteps {

    static Response response;
    static Integer limit, offset;
    //---------------------------- Set Parameters
    @Given("^\\[api] set limit to '(.*)' and offset to '(.*)'$")
    public void api_set_limit_offset_to (Integer limit, Integer offset) {

        this.limit = limit;
        this.offset = offset;
    }

    //---------------------------- Send Request
    @When("^\\[api] send get 10 pokemons request$")
    public void api_send_get_10_pokemons_request () {
        response = RestAssured.given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .param("limit", limit)
                    .param("offset", offset)
                .when()
                    .get("https://pokeapi.co/api/v2/pokemon?offset=1&limit=10");
    }
    //---------------------------- Check Status Code
    @Then("^\\[api] get 10 pokemons status code must be '(\\d+)'$")
    public void api_get_single_user_status_code_must_be (int code) {
        // Assert the status code from the Response to be equal to input code
        response.then()
                .statusCode(200);

    }


    //---------------------------- Assert Response
    @Then("^\\[api] get 10 pokemons response equals with request$")
    public void api_get_10_pokemons_response_equals_with_request () {

        // Assert directly using Rest Assured then commands
        response.
                then().
                    body("count", equalTo(964),
                            "results", hasSize(10));
    }
}