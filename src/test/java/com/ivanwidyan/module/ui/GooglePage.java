package com.ivanwidyan.module.ui;

import com.ivanwidyan.steps.ui.PokemonPageSteps;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://www.google.com")
public class GooglePage extends PageObject {

  @FindBy(xpath = "//input[@name='q']")
  WebElementFacade searchBox;

  @FindBy(xpath = "//input[@value='Google Search']")
  WebElementFacade searchButton;

  @FindBy(xpath = "//div[@class='g']//a")
  List<WebElementFacade> searchData;

  public void doSearch(){
    searchBox.click();
    searchBox.typeAndEnter(PokemonPageSteps.keyword);
  }

  public String getSearchData(String keyword) {
    for (int i = 0; i < searchData.size(); i++) {
      if(searchData.get(i).getAttribute("href").toLowerCase().contains(keyword.toLowerCase())){
        return searchData.get(i).getAttribute("href");
      }
    }
    return null;
  }

  public void openHomePage() {
    openUrl("https://www.google.com/");
  }
}