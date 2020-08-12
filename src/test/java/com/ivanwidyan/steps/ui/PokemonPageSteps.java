package com.ivanwidyan.steps.ui;

import com.ivanwidyan.module.api.data.Pokemon;
import com.ivanwidyan.module.api.data.Type;
import com.ivanwidyan.module.ui.GooglePage;
import com.ivanwidyan.module.ui.PokemonDBPage;
import com.ivanwidyan.module.ui.WikipediaPage;
import com.ivanwidyan.module.ui.YoutubePage;
import com.ivanwidyan.module.ui.data.GooglePageData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class PokemonPageSteps extends ScenarioSteps {

    private GooglePage googlePage;
    private WikipediaPage wikipediaPage;
    private PokemonDBPage pokemonDB;
    Pokemon pokemonWiki, pokemon;
    Response pokemonResponse;
    public static String keyword;


    //---------------------------- Preparations
    @Given("^\\[ui] google page is opened$")
    public void ui_youtube_page_is_opened() {
        googlePage.openHomePage();
    }

    @Given("^\\[ui] google set keyword to '(.*)'$")
    public void ui_set_keyword_to (String value) {
        keyword = value;
    }

    //---------------------------- Actions
    @When("^\\[ui] google search using keyword$")
    public void api_set_id_to () {
        googlePage.doSearch();

        String link = googlePage.getSearchData("id.wikipedia");

        wikipediaPage.openPage(link);
        pokemonWiki = wikipediaPage.fetchData();

        googlePage.openHomePage();
        googlePage.doSearch();
//
        link = googlePage.getSearchData("pokemondb");
        pokemonDB.openPage(link);
        pokemon = pokemonDB.fetchData();
        pokemonResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .get("https://pokeapi.co/api/v2/pokemon/"+keyword);
    }

    //---------------------------- Assertion
    @Then("^\\[ui] google search results should be containing keyword$")
    public void assert_result () {
        assertThat(pokemon.getName(), Matchers.equalTo(pokemonWiki.getName()));
        assertThat(pokemon.getHeight(), Matchers.equalTo(pokemonWiki.getHeight()));
        assertThat(pokemon.getJapanName(), Matchers.equalTo(pokemonWiki.getJapanName()));
        assertThat(pokemon.getWeight(), Matchers.equalTo(pokemonWiki.getWeight()));
        assertThat(pokemon.getNumber(), Matchers.equalTo(pokemonWiki.getNumber()));
        List<Type> types = pokemonResponse.
                then()
                .extract()
                .jsonPath()
                .getList("types", Type.class);
        pokemonResponse
                .then().body(
                "id", Matchers.equalTo(pokemon.getNumber()),
                "weight", Matchers.equalTo((int)(pokemon.getWeight()*10)),
                "height", Matchers.equalTo((int)(pokemon.getHeight()*10)),
                "stats[0].base_stat", Matchers.equalTo(pokemon.getHp())

        );

        for (int i = 0; i < pokemon.getTypes().size(); i++) {

//            assertThat(pokemon.getTypes().get(i).toLowerCase(), Matchers.containsString(pokemonWiki.getTypes().get(i).toLowerCase()));
            assertThat(pokemon.getTypes().get(i).toLowerCase(), Matchers.containsString(types.get(i).getType().getName().toLowerCase()));

        }
    }
}