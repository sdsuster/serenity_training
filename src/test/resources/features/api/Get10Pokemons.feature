@GetSingleUserFeature @Users @API @Regression
Feature: Get 10 Pokemons

  @Positive
  Scenario: Get 10 Pokemons success
    Given [api] set limit to '1' and offset to '0'
    When  [api] send get 10 pokemons request
    Then  [api] get 10 pokemons status code must be '200'
    And   [api] get 10 pokemons response equals with request