@SearchKeywordFeature @GooglePage @UI @Regression
Feature: Search Keyword

  # This is a sample scenario for testing search in Google

#  @Positive
#  Scenario: Search keyword success
#    Given [ui] youtube page is opened
#    And   [ui] youtube set keyword to 'Test'
#    When  [ui] youtube search using keyword
#    Then  [ui] youtube search results should be containing keyword

  @Positive
  Scenario Outline: Search keyword for '<keyword>' success
    Given [ui] google page is opened
    And   [ui] google set keyword to '<keyword>'
    When  [ui] google search using keyword
    Then  [ui] google search results should be containing keyword

    Examples:
      | keyword    |
      | eevee      |
      | bulbasaur  |
      | charmander |