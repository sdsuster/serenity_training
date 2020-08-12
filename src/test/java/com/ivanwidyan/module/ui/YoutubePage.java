package com.ivanwidyan.module.ui;

import com.ivanwidyan.steps.ui.PokemonPageSteps;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.youtube.com")
public class YoutubePage extends PageObject {

  @FindBy(xpath = "//input[@id='search']")
  WebElementFacade searchBox;

  @FindBy(xpath = "//button[@id='search-icon-legacy']")
  WebElementFacade searchButton;

  @FindBy(xpath = "//body/ytd-app/div[@id='content']/ytd-page-manager[@id='page-manager']/ytd-search[@class='style-scope ytd-page-manager']/div[@id='container']/ytd-two-column-search-results-renderer[@class='style-scope ytd-search']/div[@id='primary']/ytd-section-list-renderer[@class='style-scope ytd-two-column-search-results-renderer']/div[@id='contents']/ytd-item-section-renderer[@class='style-scope ytd-section-list-renderer']/div[3]")
  List<WebElementFacade> searchData;

  public void doSearch(){
    searchBox.click();
    searchBox.type(PokemonPageSteps.keyword);

    searchButton.click();
  }

  public List<String> getSearchData() {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < searchData.size(); i++) {
      list.add(searchData.get(i).getText());
    }
    return list;
  }

  public void openHomePage() {
    openUrl("https://www.youtube.com/");
  }
}