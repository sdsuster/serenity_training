package com.ivanwidyan.module.ui;

import com.ivanwidyan.module.api.data.Pokemon;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikipediaPage extends PageObject {


  @FindBy(xpath = "//table[@class='infobox']//center//abbr")
  WebElementFacade nationalNumber;

  @FindBy(xpath = "//tr[th/a/font[contains(text(), 'Jepang')]]/td")
  WebElementFacade japanName;

  @FindBy(xpath = "//tr[th[contains(text(), 'Tinggi')]]/td")
  WebElementFacade height;
  @FindBy(xpath = "//tr[th[contains(text(), 'Berat')]]/td")
  WebElementFacade weight;
  @FindBy(xpath = "//tr[th[contains(text(), 'Tipe')]]/td")
  WebElementFacade types;

  @FindBy(xpath = "//th[contains(text(),'Info Pokémon')]//a")
  WebElementFacade expandButton;


  public Pokemon fetchData(){
    Pokemon pokemon;
    pokemon = new Pokemon();
    pokemon.setName("0");
    pokemon.setJapanName(japanName.getText());
    pokemon.setTypes(Arrays.asList(types.getText().split("&")));

    Pattern pattern = Pattern.compile("\\((.*?)\\)");
    Matcher matcher = pattern.matcher(height.getText());
    if (matcher.find())
    {
      pokemon.setHeight(Float.parseFloat(height.getText().split(" ")[0].replace(",", ".")));
    }
    pokemon.setWeight(Float.parseFloat(weight.getText().split(" ")[0].replace(",", ".")));
    pokemon.setNumber(Integer.parseInt(nationalNumber.getText()));
    return pokemon;
  }


  public void openPage(String s) {
    openUrl(s);
    expandButton.click();
  }
}